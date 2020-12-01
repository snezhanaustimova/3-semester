package com.example.snezhana.controllers;

import com.example.snezhana.exceptions.ResourceNotFoundException;
import com.example.snezhana.model.Answer;
import com.example.snezhana.repository.AnswerRepository;
import com.example.snezhana.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions/{questionId}/answers")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    @PostMapping("/questions/{questionId}/answers")
    public Answer createAnswer(@PathVariable (value = "questionId") Long questionId,
                               @Valid @RequestBody Answer answer) {
        return questionRepository.findById(questionId).map(question -> {
            answer.setQuestion(question);
            return answerRepository.save(answer);
        }).orElseThrow(() -> new ResourceNotFoundException("Question not found by id " + questionId));
    }

    @PutMapping("/questions/{questionId}/answers/{answerId}")
    public Answer updateAnswer(@PathVariable (value = "questionId") Long questionId,
                               @PathVariable (value = "answerId") Long answerId,
                               @Valid @RequestBody Answer answerRequest) {
        if (!questionRepository.existsById(questionId)) {
            throw new ResourceNotFoundException("Question not found by id " + questionId);
        }
        return answerRepository.findById(answerId).map(answer -> {
            answer.setText(answerRequest.getText());
            return answerRepository.save(answer);
        }).orElseThrow(() -> new ResourceNotFoundException("Answer not found by id " + answerId));
    }

    @DeleteMapping("/questions/{questionId}/answers/{answersId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable (value = "questionId") Long questionId,
                                          @PathVariable (value = "answerId") Long answerId) {
        return answerRepository.findById(answerId)
                .map(answer -> {
                    answerRepository.delete(answer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Answer not found bu id " + answerId));
    }

}

package dao;

import models.Student_answer;
import models.Test;
import models.Test_list;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class Student_answerDao extends Dao<Student_answer> {

    public Student_answer findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student_answer.class, id);
    }

    public List<Student_answer> findAll(){
        return (List<Student_answer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Student_answer").list();
    }

    public List<Test_list> getTestsByStudentId(int id){
        List<Student_answer> studentAnswers = findAll();
        ArrayList<Test_list> tests = new ArrayList<>();
        for (Student_answer s: studentAnswers) {
            if(s.getUser().getRow_id() == id) {
                tests.add(s.getTest());
            }
        }
        return tests;
    }

}

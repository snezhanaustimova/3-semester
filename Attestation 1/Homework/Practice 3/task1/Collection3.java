package task1;

import java.util.*;

public class Collection3 {

    public static void buildTextDictionary(String text){

        text = text.toLowerCase();
        HashMap<String, Integer> counter = new HashMap<String,Integer>();
        String[] words = text.split(" ");

        for(String word : words){
            if(counter.containsKey(word)){
                counter.put(word, counter.get(word)+1);
            } else {
                counter.put(word, 1);
            }
        }

        Set<String> wordsInText = counter.keySet();

        for(String word : wordsInText){
            System.out.println(word + ": " + counter.get(word));
        }
    }

    public static void main(String args[]){
        buildTextDictionary("Малинки малинки такие вечеринки зеленые тропинки где тихо и свежо малинки");
    }
}

package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    private static final String WORDS = "src/main/resources/words.txt";
    private static String[] readFile(String text){
        String result = "";
        try (FileReader reader = new FileReader(text)) {
            int c;
            while ((c = reader.read()) != -1) {
                if((char) c == '\r'){
                    result+=' ';
                }
                result+=(char) c;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String[] words = Arrays.copyOf(result.split(" "), result.split(" ").length);
        return words;
    }


    private static String[] uniqueWord(String[] words){
        String uniqueWord = words[0].strip();
        for (int i = 1; i < words.length; i++){
            if (!uniqueWord.contains(words[i].strip())){
                uniqueWord = uniqueWord + " " + words[i].strip();
            }
        }
        return uniqueWord.split(" ");

    }


    public static void main(String[] args) {
        String [] words = readFile(WORDS);
        String[] uniqueWords = uniqueWord(words);
        HashMap <String, Integer> map = new HashMap<>();
        for(String uniqueWord : uniqueWords){
            map.put(uniqueWord.strip(), 0);
            for (String word : words){
                if (uniqueWord.strip().equals(word.strip())){
                    map.put(uniqueWord.strip(), map.get(uniqueWord.strip()) + 1);
                }
            }
        }
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

}

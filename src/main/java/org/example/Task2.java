package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task2 {
    private static final String TEXT ="src/main/resources/text.txt";
    private static final String USER ="src/main/resources/user.json";


    private static String[] readFile(String text){
        String usersDada= "";
        try (FileReader reader = new FileReader(text)) {
            int c;
            while ((c = reader.read()) != -1) {
                usersDada+=(char) c;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String[] users = Arrays.copyOf(usersDada.split("\n"), usersDada.split("\n").length);
        return users;
    }
    private static void writeJsonFile() {
        String[] users = readFile(TEXT);
        User person;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = "";
        try (FileWriter writer = new FileWriter(USER)) {
            int i = 0;
            for(String a : users) {
                if (i > 0){
                String[] userDada = a.split(" ");
                for (int j = 0; j < userDada.length; j++) {
                    person = new User(userDada[j++], userDada[j].strip());
                    json = gson.toJson(person);
                    System.out.println(json);
                    writer.write(json);
                }}i++;
            }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    public static void main(String[] args) {
        writeJsonFile();
    }
}




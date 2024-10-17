package com.nathanasowata;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Question questions = new Question();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my quiz game!");


        try {
            Map<String, String> loadedQuestions = loadQuestions();

            if(!loadedQuestions.isEmpty() ){
                questions.setQuestions(loadedQuestions);
                Map<String, String> questionsList = questions.getQuestions();

                // I'm using a set to allow me implement a for each loop
                Set<String> quizQuestions = questionsList.keySet();

                for(String q : quizQuestions){
                    System.out.println("Q: " + q);

                    String answer = scanner.nextLine();
                    String userAnswer = answer.toLowerCase();
                    String correctAnswer = questionsList.get(q);

                     if(userAnswer.equals(correctAnswer)){
                         System.out.println("Correct");
                     }
                     else {
                         System.out.println("Wrong! The answer is: " + correctAnswer);
                     }
                }
            }
            else {
                System.out.println("No questions where loaded");
            }

            System.out.println("That's all for now.");

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static Map<String, String> loadQuestions () throws IOException {

        Path questionsFile = Path.of("./src/main/resources/questions.txt");

        try(BufferedReader reader = Files.newBufferedReader(questionsFile)){
            String line;
            Map<String, String> allQuestions = new HashMap<>();

            while ((line = reader.readLine()) != null){
                String[] questionDetails = line.split(",", 2);
                if(questionDetails.length == 2){
                    String question = questionDetails[0].trim();
                    String answer = questionDetails[1].trim();
                    answer = answer.toLowerCase();
                    answer = answer.replace(";", "");
                    allQuestions.put(question, answer);
                }
            }
            return allQuestions;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new HashMap<>();
    }
}
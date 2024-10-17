package com.nathanasowata;

import java.util.HashMap;
import java.util.Map;

public class Question {
    private Map<String, String> questions = new HashMap<>();

    public Map<String, String> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<String, String> questions) {
        this.questions = questions;
    }
}

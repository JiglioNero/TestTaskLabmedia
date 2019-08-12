package com.example.testtasklabmedia.db;

import com.example.testtasklabmedia.Entitys.Answer;
import com.example.testtasklabmedia.Entitys.Question;

import java.util.ArrayList;

public class DBInfoProvider {
    public static ArrayList<Question> initQuestionsList() {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(100, "Ответ 1", "Вопрос 1"));
        questions.add(new Question(200, "Ответ 2", "Вопрос 2"));
        questions.add(new Question(300, "Ответ 3", "Вопрос 3"));


        return questions;
    }

    public static ArrayList<Answer> initAnswersList() {
        ArrayList<Answer> answer = new ArrayList<>();

        answer.add(new Answer(1, "Неправильный ответ 1 на вопрос 1", 100));
        answer.add(new Answer(2, "Неправильный ответ 2 на вопрос 1", 100));
        answer.add(new Answer(3, "Неправильный ответ 3 на вопрос 1", 100));
        answer.add(new Answer(4, "Неправильный ответ 1 на вопрос 2", 200));
        answer.add(new Answer(5, "Неправильный ответ 2 на вопрос 2", 200));
        answer.add(new Answer(6, "Неправильный ответ 1 на вопрос 3", 300));
        answer.add(new Answer(7, "Неправильный ответ 2 на вопрос 3", 300));
        answer.add(new Answer(8, "Неправильный ответ 3 на вопрос 3", 300));
        answer.add(new Answer(9, "Неправильный ответ 4 на вопрос 3", 300));

        return answer;
    }
}

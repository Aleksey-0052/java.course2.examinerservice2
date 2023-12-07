package pro.sky.java.course2.examinerservice2.service;

import pro.sky.java.course2.examinerservice2.domain.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}

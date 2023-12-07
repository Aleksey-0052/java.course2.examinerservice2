package pro.sky.java.course2.examinerservice2.repository;

import pro.sky.java.course2.examinerservice2.domain.Question;

import java.util.Collection;


public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
    
}

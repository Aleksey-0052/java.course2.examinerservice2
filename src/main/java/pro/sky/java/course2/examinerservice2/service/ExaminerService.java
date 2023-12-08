package pro.sky.java.course2.examinerservice2.service;

import pro.sky.java.course2.examinerservice2.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}

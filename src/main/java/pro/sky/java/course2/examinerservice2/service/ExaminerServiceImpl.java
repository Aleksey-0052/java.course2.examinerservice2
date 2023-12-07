package pro.sky.java.course2.examinerservice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice2.domain.Question;
import pro.sky.java.course2.examinerservice2.exceptions.ExceededTheLimitOfQuestionsException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;

    private final QuestionService mathQuestionService;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService, @Qualifier("mathQuestionService") QuestionService mathQuestionService) {

        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> allQuestions = javaQuestionService.getAll();
        int x = allQuestions.size();                          // В переменную x записываем размер множества questions

        if (amount > x) {
            throw new ExceededTheLimitOfQuestionsException("Превышен лимит вопросов, всего вопросов " + x);
        }

        Set<Question> setResult = new HashSet<>();            // Создаем множество setResult, которое будет заполняться
                                                              // из множества - questions вопросами в количестве amount,
                                                              // указанном пользователем, в рандомном порядке при помощи
                                                              // вызова метода getRandomQuestion()
        if (amount == x) {
            return javaQuestionService.getAll();
        }
        while (setResult.size() < amount) {
            Random random = new Random();
            if (random.nextBoolean()) {
                setResult.add(javaQuestionService.getRandomQuestion());
            } else {
                setResult.add(mathQuestionService.getRandomQuestion());
            }
        }
        return setResult;
    }

}

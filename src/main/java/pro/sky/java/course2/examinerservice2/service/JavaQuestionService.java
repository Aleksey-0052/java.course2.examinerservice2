package pro.sky.java.course2.examinerservice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice2.domain.Question;
import pro.sky.java.course2.examinerservice2.repository.QuestionRepository;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;
    private final Random random;
    @Autowired
    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.random = new Random();

    }
    

    @Override
    public Question add(String question, String answer) {
        Question quest = new Question(question, answer);

        return questionRepository.add(quest);
    }

    @Override
    public Question add(Question question) {

        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {

        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {

        return questionRepository.getAll();
                                                        
    }

//    @Override
//    public Question getRandomQuestion() {
//
//        Collection<Question> allQuestions = questionRepository.getAll();
//        int size = allQuestions.size();
//        int item = random.nextInt(size);
//
//        int i = 0;
//        for(Question question : allQuestions) {
//            if (i == item) {
//                return question;
//            }
//            i++;
//        }
//        return null;
//    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> allQuestions = questionRepository.getAll();
        int size = allQuestions.size();
        int item = random.nextInt(size);

        List<Question> questionsList = new ArrayList<>(allQuestions);
        for (int i = 0; i < questionsList.size(); i++) {
            if (i == item) {                                        // если значение индекса i элемента будет равно рандомному значению,
                return questionsList.get(i);                        // то элемент по этому индексу отбирается
            }
        }
        return null;
    }




}

package pro.sky.java.course2.examinerservice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice2.domain.Question;
import pro.sky.java.course2.examinerservice2.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;
    private final Random random;

    @Autowired
    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
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
//                                                                           // При помощи данного метода будем создавать в классе ExaminerServiceImpl
//        Collection<Question> allQuestions = questionRepository.getAll();   // множество с вопросами и ответами,  выбранными из множества - questions
//                                                                           // в рандомном порядке и в количестве - amount, указанном пользователем
//        int size = allQuestions.size();                                    // В переменную size записываем размер множества questions
//        int item = random.nextInt(size);                                   // В переменную item записываем генерируемое рандомное значение,
//                                                                           // которое находится в интервале >= 0, но меньше size
//        int i = 0;
//        for(Question question : allQuestions) {                            // запускаем цикл по элементам множества
//            if (i == item) {                                               // если значение переменной (счетчика) i будет равно рандомному значению,
//                return question;                                           // то такой элемент отбирается
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

package pro.sky.java.course2.examinerservice2.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice2.domain.Question;
import pro.sky.java.course2.examinerservice2.exceptions.QuestionAlreadyAddedException;
import pro.sky.java.course2.examinerservice2.exceptions.QuestionNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static pro.sky.java.course2.examinerservice2.constants.QuestionConstants.ALL_MATH_QUESTIONS;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public MathQuestionRepository() {

        this.questions = new HashSet<>();
    }

    @PostConstruct
    private void init() {                         // данный метод заполняет коллекцию при запуске spring

        questions.addAll(ALL_MATH_QUESTIONS);
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyAddedException("Такой объект уже существует");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException("Такой объект не найден");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {

        return Collections.unmodifiableSet(questions);
    }

}

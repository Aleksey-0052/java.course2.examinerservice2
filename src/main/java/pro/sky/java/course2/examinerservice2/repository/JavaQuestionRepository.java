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

import static pro.sky.java.course2.examinerservice2.constants.QuestionConstants.ALL_JAVA_QUESTIONS;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;
    private static final Integer MAX_QUESTIONS = 10;

    public JavaQuestionRepository() {

        this.questions = new HashSet<>(MAX_QUESTIONS);
    }

    @PostConstruct
    private void initMethod() {                 // данный метод заполняет коллекцию при запуске spring

        questions.addAll(ALL_JAVA_QUESTIONS);
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

        return Collections.unmodifiableSet(questions);         // В этом случае будет возвращена неизменяемая коллекция
    }

}

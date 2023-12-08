package pro.sky.java.course2.examinerservice2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAlreadyAddedException extends RuntimeException {

    public QuestionAlreadyAddedException(String message) {

        super(message);
    }
}

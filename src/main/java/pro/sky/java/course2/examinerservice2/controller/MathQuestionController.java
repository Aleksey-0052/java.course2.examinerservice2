package pro.sky.java.course2.examinerservice2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice2.domain.Question;
import pro.sky.java.course2.examinerservice2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/math")
public class MathQuestionController {

    private final QuestionService service;
    @Autowired
    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService service) {

        this.service = service;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam String question, String answer) {
        return service.add(question, answer);

    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam String question, String answer) {

        Question quest = new Question(question, answer);
        return service.remove(quest);

    }
    @GetMapping
    Collection<Question> getQuestions() {

        return service.getAll();
    }

}

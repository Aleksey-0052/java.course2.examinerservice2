package pro.sky.java.course2.examinerservice2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice2.domain.Question;
import pro.sky.java.course2.examinerservice2.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;
    @Autowired
    public ExamController(ExaminerService examinerService) {

        this.examinerService = examinerService;
    }
    @GetMapping(path = "/exam/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {

        return examinerService.getQuestions(amount);
    }

}

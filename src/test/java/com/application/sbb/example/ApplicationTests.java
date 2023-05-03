package com.application.sbb.example;

import com.application.sbb.example.answer.Answer;
import com.application.sbb.example.answer.AnswerRepository;
import com.application.sbb.example.question.Question;
import com.application.sbb.example.question.QuestionRepository;
import com.application.sbb.example.question.QuestionService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {
        for (int i = 0; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다: [%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content);
        }
    }

}

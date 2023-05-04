package com.application.sbb.example.question;

import com.application.sbb.example.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;

    //    @GetMapping("/list")
//    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
//        Page<Question> paging = this.questionService.getList(page);
//        model.addAttribute("paging", paging);
//        return "question_list";
//    }
    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list_2";
    }

    //    @GetMapping(value = "/detail/{id}")
//    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
//        Question question = this.questionService.getQuestion(id);
//        model.addAttribute("question", question);
//        return "question_detail";
//    }
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail_2";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; // 저장 후 list로 이동
    }
}

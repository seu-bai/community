package com.bai.community.controller;

import com.bai.community.dto.QuestionDTO;
import com.bai.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/06 10:01
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public  String question(@PathVariable(name = "id") Long id,
                            Model model){
        QuestionDTO questionDTO=questionService.getById(id);
        questionService.addViewCount(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}

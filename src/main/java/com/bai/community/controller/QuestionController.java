package com.bai.community.controller;

import com.bai.community.dto.QuestionDTO;
import com.bai.community.mapper.QuestionMapper;
import com.bai.community.service.QuestionService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebParam;

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
    public  String question(@PathVariable(name = "id") Integer id,
                            Model model){
        QuestionDTO questionDTO=questionService.getById(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}

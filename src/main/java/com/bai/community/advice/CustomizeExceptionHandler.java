package com.bai.community.advice;

import com.bai.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/10 10:58
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
     ModelAndView handle(Throwable ex, Model model){
        if (ex instanceof CustomizeException){
            model.addAttribute("message", ex.getMessage());
        }else{
            model.addAttribute("message","服务器冒烟了，紧急降温中，你稍后再来吧！");
        }
        return new ModelAndView("error");
    }
}

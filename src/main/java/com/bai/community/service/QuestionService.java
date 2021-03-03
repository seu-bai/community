package com.bai.community.service;

import com.bai.community.dto.QuestionDTO;
import com.bai.community.mapper.QuestionMapper;
import com.bai.community.mapper.UserMapper;
import com.bai.community.model.Question;
import com.bai.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/03 9:59
 */
@Service
public class QuestionService {
@Autowired
private QuestionMapper questionMapper;
@Autowired
private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for (Question question : questions) {
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}

package com.bai.community.service;

import com.bai.community.enums.CommentTypeEnum;
import com.bai.community.exception.CustomizeErrorCode;
import com.bai.community.exception.CustomizeException;
import com.bai.community.mapper.CommentMapper;
import com.bai.community.mapper.QuestionExtMapper;
import com.bai.community.mapper.QuestionMapper;
import com.bai.community.model.Comment;
import com.bai.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/19 10:40
 */
@Service
public class CommentService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;

    public void insert(Comment comment) {
        if (comment.getParentId()==null||comment.getParentId()==0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType()==null|| !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType()==CommentTypeEnum.Comment.getType()){
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment==null){
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        }else{
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question==null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }else {
                commentMapper.insert(comment);
                question.setCommentCount(1);
                questionExtMapper.addCommentCount(question);
            }
        }
    }
}

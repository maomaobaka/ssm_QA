package com.company;

import com.company.dao.QuestionDao;
import com.company.dao.UserDao;
import com.company.model.Question;
import com.company.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@MapperScan
public class AppTest {
    @Autowired
    UserDao userdao;
    @Autowired
    QuestionDao questionDao;

    @Test
    public void user() {
        userdao.addUser(new User("231","321","rreq","uiewrh"));
    }

    @Test
    public void question() {
        for (int i = 0; i < 11; ++i) {
            Question question = new Question();
            question.setCommentCount(i);
            Date date=new Date();
            date.setTime(date.getTime()+1000*3600*5*i);
            question.setCreateDate(date);
            question.setId(i+1);
            question.setTitle(String.format("TITLE{%d}",i));
            question.setContent(String.format("dadsasdad Content %d",i));
            questionDao.addQuestion(question);
        }

    }

    @Test
    public void selectQuestion(){
        System.out.println(userdao.findUser(1));
    }


}

package com.vereview.dao;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/26/17.
 */
public class QuestionDaoTest extends DaoTest{

    /*
    @Test
    public void getQuestionsTest(){
        try {
            QuestionDao dao = new QuestionDao(mgr);
            Map<Long, String> questions = dao.getQuestions();
            questions.forEach((k,v) -> {
                System.out.println("QuestionId: " + k + " | Name: " + v);
            });
            System.out.println(questions.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}

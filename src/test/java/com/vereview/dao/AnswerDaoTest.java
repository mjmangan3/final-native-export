package com.vereview.dao;

import com.vereview.model.Answer;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by mjmangan on 8/26/17.
 */
public class AnswerDaoTest extends DaoTest{
    /*
    @Test
    public void getAnswersTest(){
        try {
            AnswerDao dao = new AnswerDao(mgr);
            Map<Long, Map<Long, List<Answer>>> answers = dao.getAnswers();
            answers.forEach((k,v) -> {
                System.out.println("FileId: " + k);
                v.forEach((q,l) -> {
                    System.out.println("\tQuestionId: " + q);
                    l.forEach(answer -> {
                        System.out.println("\t\t" + answer);
                    });
                });
            });

            System.out.println(answers.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */

}

package com.vereview.csv;

import com.vereview.dao.AnswerDao;
import com.vereview.dao.QuestionDao;
import com.vereview.dao.ResponseDao;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/26/17.
 */
public class QuestionBuilderTest extends BuilderTest{
    //255785, 255257, 225789


    @Test
    public void buildTest(){
        try {
            QuestionDao questionDao = new QuestionDao(mgr);
            indexManager.setQuestionsByQuestionId(questionDao.getQuestions());
            ResponseDao responseDao = new ResponseDao(mgr);
            indexManager.setResponseByResponseId(responseDao.getResponses());
            AnswerDao answerDao = new AnswerDao(mgr);
            indexManager.setAnswersByFileId(answerDao.getAnswers());
            Long[] fileIds = {new Long(255785), new Long(255257), new Long(225789)};
            for(Long fileId : fileIds){
                Map<String, String> row = new QuestionBuilder(fileId).questions().build();
                System.out.println(row);
            }
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
}

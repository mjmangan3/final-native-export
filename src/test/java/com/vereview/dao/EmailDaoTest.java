package com.vereview.dao;

import com.vereview.model.Email;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/18/17.
 */
public class EmailDaoTest extends DaoTest {

    /*
    @Test
    public void fetchAllEmailsTest(){
        try {
            EmailDao dao = new EmailDao(mgr);
            Map<Long, Email> emails = dao.fetchAllEmails();
            emails.forEach((k,v) -> {
                System.out.println("FileId: " + k + " | " + v.toString());
            });
            System.out.println(emails.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}

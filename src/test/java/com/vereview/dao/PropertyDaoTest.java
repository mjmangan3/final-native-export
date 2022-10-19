package com.vereview.dao;

import com.vereview.model.Property;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/20/17.
 */
public class PropertyDaoTest extends DaoTest{

    /*
    @Test
    public void getPropertiesTest(){
        try{
            Long productionId = new Long(9);
            PropertyDao dao = new PropertyDao(mgr);
            Map<Long, Property> props = dao.findAll();
            props.forEach((k,v) -> {
                System.out.println("FileId: " + k + " | " + v);
            });
            System.out.println(props.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}

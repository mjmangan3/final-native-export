package com.vereview.csv;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mjmangan on 9/2/17.
 */

public class RelitivityDelimitersTest {

    @Test
    public void testDelimiters(){
        try {
            System.out.println(RelitivityDelimiters.COLUMN.getCharacter().toString());
            System.out.println(RelitivityDelimiters.QUOTE.getCharacter());
            System.out.println(RelitivityDelimiters.NEW_LINE.getCharacter());
            System.out.println(RelitivityDelimiters.MULTI_VALUE.getCharacter());
            System.out.println(RelitivityDelimiters.NESTED_VALUE.getCharacter());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
}

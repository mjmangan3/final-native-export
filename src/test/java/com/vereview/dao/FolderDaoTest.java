package com.vereview.dao;

import com.vereview.model.Folder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/13/17.
 */
public class FolderDaoTest extends DaoTest{

    /*
    @Test
    public void findAllFoldersTest(){
        try {
            FolderDao dao = new FolderDao(mgr);
            Map<Long, Folder> folders = dao.findAll();
            folders.forEach((folderId, folder) ->{
                System.out.println("folderId: " + folderId + " | " + folder);
            });
            System.out.println(folders.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}

package com.javapro.cloudservice.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Oleg on 01.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-config.xml")
@Rollback
@Transactional(transactionManager = "transactionManager")
public class FolderDaoTest {
    @Autowired
    FolderDao folderDao;
    @Test
    public void test() throws Exception {
        folderDao.getFolders("test");
        folderDao.addFolder("testname","fuckers");
        folderDao.addMainFolder("fuckers");

    }
    @Test
    public void getMainFolder(){
        folderDao.getMainFolder("fuckers");
    }
}

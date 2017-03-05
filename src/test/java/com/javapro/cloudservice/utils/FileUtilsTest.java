package com.javapro.cloudservice.utils;
import com.javapro.cloudservice.utils.impl.FileUtilsImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Oleg on 02.03.2017.
 */
@RunWith(MockitoJUnitRunner.class)
@Rollback
@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = "classpath:/test-config.xml")
public class FileUtilsTest {
    @Mock
    FileUtils fileUtils1;
    @Autowired
    FileUtilsImpl fileUtils=new FileUtilsImpl();
@Test
    public void mockTest(){

    MockMultipartFile multipartFile=new MockMultipartFile("file","orig.txt",null,"bar".getBytes());

    fileUtils.createDirectory("D\\CloudUsers\\test");
    fileUtils.delateDirectory("D\\CloudUsers\\test");
//fileUtils.uploadFile("D:\\CloudUsers",multipartFile);
}
}

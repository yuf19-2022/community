package com.yuf19_2022.community;

import com.yuf19_2022.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class TransactionTests {

    @Autowired
    AlphaService alphaService;

    @Test
    public void testSave1(){
        Object obj=alphaService.save1();
        System.out.println(obj);
    }

    @Test
    public void testSave2(){
        Object obj=alphaService.save2();
        System.out.println(obj);
    }
}

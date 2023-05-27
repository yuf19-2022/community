package com.yuf19_2022.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.FileNotFoundException;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class LoggerTests {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTests.class);

    @Test
    public void testLogger() throws FileNotFoundException {
        System.out.println(logger.getName());
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("eerror log");
    }
}

package com.yuf19_2022.community;

import com.yuf19_2022.community.dao.IDiscussPostMapper;
import com.yuf19_2022.community.dao.elasticsearch.IDiscussPostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class ElasticsearchTests {

    @Autowired
    private IDiscussPostMapper iDiscussPostMapper;

    private IDiscussPostRepository iDiscussPostRepository;

//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testInsert() {
        iDiscussPostRepository.save(iDiscussPostMapper.selectDiscussPostById(234));
        iDiscussPostRepository.save(iDiscussPostMapper.selectDiscussPostById(239));
        iDiscussPostRepository.save(iDiscussPostMapper.selectDiscussPostById(242));
    }
}

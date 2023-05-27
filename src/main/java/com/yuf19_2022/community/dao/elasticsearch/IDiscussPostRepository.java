package com.yuf19_2022.community.dao.elasticsearch;

import com.yuf19_2022.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

//Integer表示主键的类型
@Repository
public interface IDiscussPostRepository extends ElasticsearchRepository<DiscussPost,Integer> {

//    Object save(DiscussPost discussPost);
}

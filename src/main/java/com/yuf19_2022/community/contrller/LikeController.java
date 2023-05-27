package com.yuf19_2022.community.contrller;

import com.yuf19_2022.community.annotion.LoginRequired;
import com.yuf19_2022.community.entity.Event;
import com.yuf19_2022.community.entity.User;
import com.yuf19_2022.community.event.EventProducer;
import com.yuf19_2022.community.service.LikeService;
import com.yuf19_2022.community.util.DemoUtil;
import com.yuf19_2022.community.util.HostHolder;
import com.yuf19_2022.community.util.IDenoConstant;
import com.yuf19_2022.community.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LikeController implements IDenoConstant {

    @Autowired
    private LikeService likeService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private RedisTemplate redisTemplate;

    @LoginRequired
    @RequestMapping(path = "/like", method = RequestMethod.POST)
    @ResponseBody
    public String like(int entityType, int entityId, int entityUserId, int postId) {
        User user = hostHolder.getUser();
        //点赞
        likeService.like(user.getId(), entityType, entityId, entityUserId);
        //数量
        long likeCount = likeService.findEntityLikeCount(entityType, entityId);
        //状态
        int likeStatus = likeService.findEntityLikeStatus(user.getId(), entityType, entityId);

        //返回的结果
        Map<String, Object> map = new HashMap<>();
        map.put("likeCount", likeCount);
        map.put("likeStatus", likeStatus);

        //触发点赞事件
        if (likeStatus == 1) {
            Event event = new Event()
                    .setTopic(TOPIC_LIKE)
                    .setUserId(hostHolder.getUser().getId())
                    .setEntityType(entityType)
                    .setEntityId(entityId)
                    .setEntityUserId(entityUserId)
                    .setData("postId", String.valueOf(postId));
            //当不是自己给自己点赞时才发通知
            if (hostHolder.getUser().getId() != entityUserId) {
                eventProducer.fireEvent(event);
            }
        }

        if (hostHolder.getUser().getId() != entityUserId && entityType == ENTITY_TYPE_POST) {
            //计算帖子分数
            String redisKey = RedisKeyUtil.getPostScoreKey();
            redisTemplate.opsForSet().add(redisKey, postId);
        }

        return DemoUtil.getJSONString(0, null, map);
    }
}

package learning.redis_as_messaging.publisher;

import learning.redis_as_messaging.dto.Product;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {
    private final RedisTemplate redisTemplate;
    private final ChannelTopic channel;

    public Publisher(
        RedisTemplate redisTemplate,
        ChannelTopic channel
    ){
        this.redisTemplate=redisTemplate;
        this.channel=channel;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody Product product){
        redisTemplate.convertAndSend(channel.getTopic(),product.toString());
        return "Event Published!";
    }
}

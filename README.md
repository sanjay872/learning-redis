# REDIS
Redis can be used as a cache, in-memory database, messaging queue.

In spring boot, spring data redis is used.

Redis in windows - https://github.com/microsoftarchive/redis/releases

use the zip file and run `redis-server` file.

## Redis as Database

**Dependencies**
  - `Spring Web`
  - `Spring Data Redis (Access + driver)`
  - `jedis` (from maven repository)

**Steps**
1. create entity and add @RedisHash(”Table_name”)
2. create a class for adding redis configuration, add configuration and EnableRedisRepository
3. create JedisConnectionFactory bean and add hostname and port.
4. with this the connection is established, now we need a template to access the redis.
5. access the redis database by injecting redis template and getting the data.

## Redis as cache

- add @EnableCaching on top of main class
- add @Cacheable on top of the get request of the controller or on the service method.
- add args of key as ‘#id’ and value as “Product” (which is the hash key)

`@Cacheable(key="#id", value = "Product")`

**With Condition**

`unless = "#result.price>1000"`

this will ensure that only the product that has price less than 1000 will be cached.

The data is opposite of the given condition will be cached.

**CacheEvict**

Delete data from Cache that is deleted from database.
`@CacheEvict(key = "#id",value = "Product")`

**CachePut**

To update the cache if the data got updated in db.

## Redis as Messaging queue

To create Event driven architecture, it has publisher and subscriber.

**Dependencies**

- Spring Redis
- web
- Jedis

**Steps**

- create redis config file
    - create JedisConnectionFactory bean and add hostname and port.
    - with this the connection is established, now we need a template to access the redis.
    - For access the redis database by injecting redis template and getting the data.
    - Create a channel topic as a bean  using ChannelTopic and add any name for the channel in the constructor.
    - Create a MessageListenerAdapter to config on how to handle messages. The receiver class will be passed on the argument.
    - Create MessageListenerContainer, it is the core component that handles message listener in the background.
        - set config factory, listener adapter and topic channel.
    - Create a Receiver Class,
        - it must implement MessageListener interface overriding on message method.
        - the OnMessage method will get executed after an message is published.
        - This is the receiver class that will be passed with in the MessageListenerAdapter.
    - create a controller to publish the message using redisTemplate and pass the message with channel topic.

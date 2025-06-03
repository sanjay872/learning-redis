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

package com.it.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig {
    @Bean
    @SuppressWarnings(value = { "unchecked", "rawtypes" })
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory)
    {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        FastJsonRedisSerializer serializer = new FastJsonRedisSerializer(Object.class);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }




    /**
     * 配置缓存管理器
     * @param factory Redis 线程安全连接工厂
     * @return 缓存管理器
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        // 生成两套默认配置，通过 Config 对象即可对缓存进行自定义配置
        RedisCacheConfiguration cacheConfig1 = RedisCacheConfiguration.defaultCacheConfig()
                // 设置过期时间 10 分钟
                .entryTtl(Duration.ofMinutes(10))
                // 设置缓存前缀
                .prefixKeysWith("cache:user:")
                // 禁止缓存 null 值
                .disableCachingNullValues()
                // 设置 key 序列化
                .serializeKeysWith(keyPair())
                // 设置 value 序列化
                .serializeValuesWith(valuePair());

        RedisCacheConfiguration cacheConfig2 = RedisCacheConfiguration.defaultCacheConfig()
                // 设置过期时间 30 秒
                .entryTtl(Duration.ofSeconds(30))
                .prefixKeysWith("cache:admin:")
                .disableCachingNullValues()
                .serializeKeysWith(keyPair())
                .serializeValuesWith(valuePair());

        // 返回 Redis 缓存管理器
        return RedisCacheManager.builder(factory)
                .withCacheConfiguration("user", cacheConfig1)
                .withCacheConfiguration("admin", cacheConfig2)
                .build();
    }

    /**
     * 配置键序列化
     * @return StringRedisSerializer
     */
    private RedisSerializationContext.SerializationPair<String> keyPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
    }

    /**
     * 配置值序列化，使用 GenericJackson2JsonRedisSerializer 替换默认序列化
     * @return GenericJackson2JsonRedisSerializer
     */
    private RedisSerializationContext.SerializationPair<Object> valuePair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    }
}

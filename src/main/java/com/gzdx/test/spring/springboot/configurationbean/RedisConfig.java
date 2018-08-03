package com.gzdx.test.spring.springboot.configurationbean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 *
 * @author oKong
 *
 */
@Configuration
@EnableCaching
public class RedisConfig {

	/**
	 *  定义 StringRedisTemplate ，指定序列化和反序列化的处理类
	 * @param factory
	 * @return
	 */
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
				Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		//序列化 值时使用此序列化方法
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {
		RedisCacheManager cacheManager = RedisCacheManager.create(factory);
		return cacheManager;
	}
}
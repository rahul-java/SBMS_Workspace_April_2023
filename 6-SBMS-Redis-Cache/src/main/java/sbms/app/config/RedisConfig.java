package sbms.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import sbms.app.binding.User;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory getJedisConnection()
	{
		JedisConnectionFactory factory = new JedisConnectionFactory();
		
		//factory.setHostName(null);
		//factory.setPassword(null);
		//factory.setPort(0);
		
		return factory;
	}
	
	@Bean
	@Primary
	public RedisTemplate<String, User> getRedisTemplate(JedisConnectionFactory factory)
	{
		RedisTemplate<String, User> rt=new RedisTemplate<>();
		rt.setConnectionFactory(factory);
		return rt;
	}

}

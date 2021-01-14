package com.redislabs.springredisbootstrap;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Data
@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {
    private String host;
    private Integer port;
    private String prefix;

    // TODO - connection pooling!
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration(this.host, this.port));
    }

}

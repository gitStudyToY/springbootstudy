//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import redis.clients.jedis.JedisPoolConfig;
//
//@Configuration
//public class RedisConfigGuard  extends RedisConfig{
//
//    /**
//     * 配置redis的哨兵
//     * @return RedisSentinelConfiguration
//     * @autor lpl
//     * @date 2017年12月21日
//     * @throws
//     */
//    @Bean
//    public RedisSentinelConfiguration sentinelConfiguration(){
//        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
//        //配置matser的名称
////        RedisNode redisNode = new RedisNode(hostName, port);
////        redisNode.setName("mymaster");
////        redisSentinelConfiguration.master(redisNode);
////        //配置redis的哨兵sentinel
////        RedisNode senRedisNode = new RedisNode(senHost1,senPort1);
////        Set<RedisNode> redisNodeSet = new HashSet<>();
////        redisNodeSet.add(senRedisNode);
// //       redisSentinelConfiguration.setSentinels(redisNodeSet);
//        return redisSentinelConfiguration;
//    }
//    /**
//     * 配置工厂
//     * @param jedisPoolConfig
//     * @return
//     */
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig, RedisSentinelConfiguration sentinelConfig) {
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(sentinelConfig,jedisPoolConfig);
//        return jedisConnectionFactory;
//    }
//
//
//}
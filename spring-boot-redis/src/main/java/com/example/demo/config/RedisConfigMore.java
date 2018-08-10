//package com.example.demo.config;
//
//import com.example.demo.util.RedisUtil;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisNode;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Configuration
//public class RedisConfigMore extends RedisConfig{
//
////    @Value("${spring.redis.cluster.nodes}")
////    private String clusterNodes;
////
////    @Value("${spring.redis.cluster.max-redirects}")
////    private Integer mmaxRedirectsac;
//
//    /**
//     * Redis集群的配置
//     * @return RedisClusterConfiguration
//     * @autor lpl
//     * @date 2017年12月22日
//     * @throws
//     */
//    @Bean
//    public RedisClusterConfiguration redisClusterConfiguration(){
//        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
////        //Set<RedisNode> clusterNodes
////        String[] serverArray = clusterNodes.split(",");
////
////        Set<RedisNode> nodes = new HashSet<RedisNode>();
////
////        for(String ipPort:serverArray){
////            String[] ipAndPort = ipPort.split(":");
////            nodes.add(new RedisNode(ipAndPort[0].trim(),Integer.valueOf(ipAndPort[1])));
////        }
////
////        redisClusterConfiguration.setClusterNodes(nodes);
////        redisClusterConfiguration.setMaxRedirects(mmaxRedirectsac);
//
//        return redisClusterConfiguration;
//    }
//    /**
//     * 配置工厂
//     * @Title: JedisConnectionFactory
//     * @param @param jedisPoolConfig
//     * @param @return
//     * @return JedisConnectionFactory
//     * @autor lpl
//     * @date 2017年12月22日
//     * @throws
//     */
//    @Bean
//    public JedisConnectionFactory JedisConnectionFactory(JedisPoolConfig jedisPoolConfig, RedisClusterConfiguration redisClusterConfiguration){
//        JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration,jedisPoolConfig);
//
//        return JedisConnectionFactory;
//    }
//
//
//}
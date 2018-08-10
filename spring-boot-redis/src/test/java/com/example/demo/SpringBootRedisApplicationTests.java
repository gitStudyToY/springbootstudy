package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.util.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
//
//	@Test
//	public void contextLoads() {
//
//		// 保存字符串
//		stringRedisTemplate.opsForValue().set("bbb", "111");
//		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("bbb"));
//
//		System.out.println(stringRedisTemplate.opsForValue().get("bbb"));
//
//
//	}
//
//	@Autowired
//	private RedisTemplate<String, User> redisTemplate;
//
//	@Test
//	public void test() throws Exception {
//
//		// 保存对象
//		User user = new User("超人", 20);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//
//		user = new User("蝙蝠侠", 30);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//
//		user = new User("蜘蛛侠", 40);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//
//		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
//		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
//		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
//
//	}

	@Resource
	private RedisUtil redisUtil;


	@Test
	public void testRedis() throws Exception {

//		redisUtil.set("num",1);
//		System.out.println(redisUtil.get("num")  + "*********************");
//		System.out.println(redisUtil.expire("num",30)  + "**************");
//		System.out.println(redisUtil.getExpire("num"));
//		System.out.println(redisUtil.hasKey("num"));
//		redisUtil.del("num");

		System.out.println(redisUtil.set("num","1",60));
//		redisUtil.incr("num",5);
//		redisUtil.decr("num",2);
		System.out.println(redisUtil.get("num"));
		System.out.println(redisUtil.getExpire("num"));
		redisUtil.del("num");
//
//		redisUtil.hset("car","name","BM");
//		System.out.println(redisUtil.hget("car","name"));
//		redisUtil.hset("car","price","160",60);
//		System.out.println(redisUtil.hmget("car"));
//		Map<String,Object> user = new HashMap<>();
//		user.put("name","张三");
//		user.put("age","23");
//	//	redisUtil.hmset("user",user);
//		//redisUtil.hmset("user",user,60);
//		redisUtil.hdel("car","price");
//		System.out.println(redisUtil.hHasKey("car","name"));
//		System.out.println(redisUtil.hget("car","name"));
//		System.out.println(redisUtil.hget("car","price"));
//		//System.out.println(redisUtil.hmget("user"));
//		redisUtil.hincr("car","id",5);
//		redisUtil.hdecr("car","id",1);
//		System.out.println(redisUtil.hmget("car"));

////		Map<String,Object> user = new HashMap<>();
////		user.put("name","张三");
////		user.put("age","23");
//		redisUtil.sSet("user","1");
//		System.out.println(redisUtil.sGetSetSize("user"));
////		Map<String,Object> user1 = new HashMap<>();
////		user.put("name","张三1");
////		user.put("age","23");
//		redisUtil.sSetAndTime("user",60,"2");
//		System.out.println(redisUtil.sGetSetSize("user"));
//		System.out.println(redisUtil.sGet("user"));
//		System.out.println(redisUtil.sHasKey("user","1"));
//		System.out.println(redisUtil.setRemove("user","1"));
//		System.out.println(redisUtil.sGet("user"));

//		redisUtil.lSet("user","1");
//		redisUtil.lSet("user","2");
//		System.out.println(redisUtil.lGet("user",0,-1));
//		System.out.println(redisUtil.lGetListSize("user"));
//		System.out.println(redisUtil.lGetIndex("user",1));
//		redisUtil.lUpdateIndex("user",0,"3");
//		System.out.println(redisUtil.lGetIndex("user",0));
//		redisUtil.lRemove("user",1,"2");
//		System.out.println(redisUtil.lGetListSize("user"));
//		System.out.println(redisUtil.lGetIndex("user",0));
//		List<String> list = new ArrayList<>();
//		list.add("4");
//		list.add("5");
//		redisUtil.lSet("users",list);
//		System.out.println(redisUtil.lGet("users",0,-1));
//		System.out.println(redisUtil.lGetListSize("users"));
//		System.out.println(redisUtil.lGetIndex("users",1));
//		redisUtil.lUpdateIndex("users",0,"3");
//		System.out.println(redisUtil.lGetIndex("users",0));
//		redisUtil.lRemove("users",1,"3");
//		System.out.println(redisUtil.lGetListSize("users"));
//		System.out.println(redisUtil.lGetIndex("users",0));




	}


}

package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void findByName() throws Exception {
		userMapper.insert("AAAA", 20);
		User u = userMapper.findByName("AAAA");
		Assert.assertEquals(20, u.getAge().intValue());
    }

}

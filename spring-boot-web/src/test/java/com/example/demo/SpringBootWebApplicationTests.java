package com.example.demo;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskFuture;
import com.example.demo.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.concurrent.Future;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void testUserController() throws Exception {
		// 测试UserController
		RequestBuilder request = null;

		// 1、get查一下user列表，应该为空
		request = get("/users/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content().string(equalTo("[]")));

		// 2、post提交一个user
		request = post("/users/")
				.param("id", "1")
				.param("name", "测试大师")
				.param("age", "20");
		mvc.perform(request)
				.andExpect((ResultMatcher) content().string(equalTo("success")));

		// 3、get获取user列表，应该有刚才插入的数据
		request = get("/users/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

		// 4、put修改id为1的user
		request = put("/users/1")
				.param("name", "测试终极大师")
				.param("age", "30");
		mvc.perform(request)
				.andExpect((ResultMatcher) content().string(equalTo("success")));

		// 5、get一个id为1的user
		request = get("/users/1");
		mvc.perform(request)
				.andExpect((ResultMatcher) content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

		// 6、del删除id为1的user
		request = delete("/users/1");
		mvc.perform(request)
				.andExpect((ResultMatcher) content().string(equalTo("success")));

		// 7、get查一下user列表，应该为空
		request = get("/users/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content().string(equalTo("[]")));

	}


	@Autowired
	private Task task;

	@Test
	public void task() throws Exception{
		task.doTaskOne();
		task.doTaskTwo();
		task.doTaskThree();
	}

	@Autowired
	private TaskFuture taskFuture;

	/**
	 * 在测试用例一开始记录开始时间
	 在调用三个异步函数的时候，返回Future<String>类型的结果对象
	 在调用完三个异步函数之后，开启一个循环，根据返回的Future<String>对象来判断三个异步函数是否都结束了。若都结束，就结束循环；若没有都结束，就等1秒后再判断。
	 跳出循环之后，根据结束时间 - 开始时间，计算出三个任务并发执行的总耗时。
	 * @throws Exception
	 */
	@Test
	public void taskFuture() throws Exception{
		long start = System.currentTimeMillis();

		Future<String> task1 = taskFuture.doTaskOne();
		Future<String> task2 = taskFuture.doTaskTwo();
		Future<String> task3 = taskFuture.doTaskThree();

		while(true) {
			if (task1.isDone() && task2.isDone() && task3.isDone()) {
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

	}


}

package com.example.demo;

import com.example.demo.controller.DtoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCommonApplicationTests {


	@Autowired
	private DtoController dtoController;

	@Test
	public void contextLoads() {

		String in = "{\n" +
				"    \"ROOT\": {\n" +
				"        \"BODY\": {\n" +
				"            \"REQUEST_INFO\": {\n" +
				"                \"BUSI_INFO_LIST\": {\n" +
				"                    \"BUSI_INFO\": {\n" +
				"                        \"CUST_ID\": \"\",\n" +
				"                        \"ECENTPERMIT\": \"\",\n" +
				"                        \"ECMANNAME\": \"\",\n" +
				"                        \"ECTYPE\": \"\",\n" +
				"                        \"EC_ID\": \"4797000409\",\n" +
				"                        \"EC_STATUS\": \"\",\n" +
				"                        \"PAGE_NUM\": \"1\",\n" +
				"                        \"TOTAL_COUNT\": \"0\"\n" +
				"                    }\n" +
				"                }\n" +
				"            }\n" +
				"        },\n" +
				"        \"HEADER\": {\n" +
				"            \"CHANNEL_ID\": \"11\",\n" +
				"            \"CONTACT_ID\": \"\",\n" +
				"            \"DB_ID\": \"B1\",\n" +
				"            \"ENV_ID\": \"\",\n" +
				"            \"KEEP_LIVE\": \"10.208.201.160\",\n" +
				"            \"PARENT_CALL_ID\": \"F1F9722B2D47F873107FD9EC194C0A0B\",\n" +
				"            \"POOL_ID\": \"2\",\n" +
				"            \"ROUTING\": {\n" +
				"                \"APP_CODE\": \"custm\",\n" +
				"                \"BALANCE\": \"w\",\n" +
				"                \"ROUTE_KEY\": \"15\",\n" +
				"                \"ROUTE_VALUE\": \"16\"\n" +
				"            },\n" +
				"            \"SUB_TRACE_ID\": \"\",\n" +
				"            \"TRACE_ID\": \"11*20160623094600*3895*baNP01*497168\"\n" +
				"        }\n" +
				"    }\n" +
				"}";



	}

}

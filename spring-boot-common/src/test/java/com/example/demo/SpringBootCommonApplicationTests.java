package com.example.demo;

import com.example.demo.controller.DtoController;
import com.example.demo.dto.BodyResp;
import com.example.demo.dto.Header;
import com.example.demo.dto.RootResp;
import com.example.demo.dto.param.DtoOut;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
	public void contextLoads() throws JsonProcessingException {

		RootResp<DtoOut> caseb = new RootResp<DtoOut>();



		ObjectMapper mapper = new ObjectMapper();

	//	mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

		Header header = new Header();
		header.setChannel_Id("464655");
		header.setKeepLive("465656");

		caseb.setHeader(header);

		BodyResp<DtoOut> bodyResp = new BodyResp<>();
		bodyResp.setReturnCode("0");
		bodyResp.setReturnMsg("OK");

		caseb.setBody(bodyResp);

		String jsonStr = mapper.writeValueAsString(caseb);

		System.out.println("JSON:" + jsonStr);

	}

}

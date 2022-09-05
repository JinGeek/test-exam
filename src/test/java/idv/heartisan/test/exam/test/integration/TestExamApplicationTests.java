package idv.heartisan.test.exam.test.integration;

import idv.heartisan.test.exam.TestExamApplication;
import idv.heartisan.test.exam.dao.mapper.ActorDMOMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = TestExamApplication.class, args = "--spring.config.location=classpath:application-test-yml")
@AutoConfigureMockMvc
@Slf4j
class TestExamApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ActorDMOMapper actorDMOMapper;

	@DisplayName("用户注册")
	@Test
	void registerTest() throws Exception {
		String requestBody = "{\n" +
				"  \"phone\": \"13819055415\",\n" +
				"  \"actorType\": \"STUDENT\",\n" +
				"  \"password\": \"123123123\",\n" +
				"  \"passwordDuplication\": \"123123123\",\n" +
				"  \"name\": \"Mophy\",\n" +
				"  \"age\": \"22\",\n" +
				"  \"gender\": \"MAN\"\n" +
				"}";
		log.info("total actor count: {}", actorDMOMapper.selectCount(null));
		MvcResult result = mockMvc.perform(
				post("/actor/register").contentType(MediaType.APPLICATION_JSON).content(requestBody)
				.accept(MediaType.APPLICATION_JSON)
		).andExpect(jsonPath("$.code").value("2-00"))
		.andReturn();
		log.info("result: {}", result.getResponse().getContentAsString());
		assertTrue(actorDMOMapper.selectCount(null) == 1, "注册未成功！");
	}

	@DisplayName("用户注册2")
	@Test
	void registerTest2() throws Exception {
		String requestBody = "{\n" +
				"  \"phone\": \"13819055414\",\n" +
				"  \"actorType\": \"STUDENT\",\n" +
				"  \"password\": \"123123123\",\n" +
				"  \"passwordDuplication\": \"123123123\",\n" +
				"  \"name\": \"Mophy\",\n" +
				"  \"age\": \"22\",\n" +
				"  \"gender\": \"MAN\"\n" +
				"}";
		log.info("total actor count: {}", actorDMOMapper.selectCount(null));
		MvcResult result = mockMvc.perform(
						post("/actor/register").contentType(MediaType.APPLICATION_JSON).content(requestBody)
								.accept(MediaType.APPLICATION_JSON)
				).andExpect(jsonPath("$.code").value("2-00"))
				.andReturn();
		log.info("result: {}", result.getResponse().getContentAsString());
		assertTrue(actorDMOMapper.selectCount(null) == 2, "注册未成功！");
	}

}

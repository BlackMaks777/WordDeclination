package com.bft.task1

import com.bft.task1.services.DeclinationService
import org.hamcrest.core.StringContains.containsString
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

@RunWith(SpringRunner :: class)
@SpringBootTest()
@AutoConfigureMockMvc
class WordDeclinationApplicationTests {
	private val uri = "http://localhost:8080/spell"
	private val answerList1 = listOf("машина", "машины", "машине", "машину", "машиной", "машине")
	private val answerString = "[\"гриб\",\"гриба\",\"грибу\",\"гриб\",\"грибом\",\"грибе\"]"


	@Autowired
	private lateinit var service: DeclinationService

	@Autowired
	private lateinit var mockMvc: MockMvc

	@Test
	fun serviceTest1() {
		assertEquals(answerList1, service.spell("машина"),)
	}

	@Test
	fun serviceTest2() {
		assertNotEquals(answerList1, service.spell("самолёт"),)
	}

	@Test
	fun restTest() {
		mockMvc.perform(get("$uri/гриб")).andExpect(content().string(containsString(answerString)))
	}

}

package com.example.backend

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity
import java.net.URI
import java.util.*


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTests {

	var responseType: ParameterizedTypeReference<Map<String?, String?>?> =
			object : ParameterizedTypeReference<Map<String?, String?>?>() {}

	@LocalServerPort
	private var port = 0

	@Autowired
	private lateinit var restTemplate: TestRestTemplate

	@Test
	fun `When call greeting by GET then a valid response is returned`() {

		val requestEntity = RequestEntity.get(URI("http://localhost:$port/api/greeting"))
				.accept(MediaType.APPLICATION_JSON).build()
		val response = restTemplate.exchange(requestEntity, responseType)

		assertThat(response.statusCode, equalTo(HttpStatus.OK))
		assertThat(response.body, hasEntry(`is`("msg"), `is`("Hello")))
	}

}

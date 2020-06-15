package com.example.backend

import com.example.backend.domain.Order
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


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTests {

	var mapType: ParameterizedTypeReference<Map<String?, String?>?> =
			object : ParameterizedTypeReference<Map<String?, String?>?>() {}

	var orderType: ParameterizedTypeReference<Order> =
			object : ParameterizedTypeReference<Order>() {}

	@LocalServerPort
	private var port = 0

	@Autowired
	private lateinit var restTemplate: TestRestTemplate

	@Test
	fun `When call greeting by GET then a valid response is returned`() {

		val requestEntity = RequestEntity.get(URI("http://localhost:$port/api/greeting"))
				.accept(MediaType.APPLICATION_JSON).build()
		val response = restTemplate.exchange(requestEntity, mapType)

		assertThat(response.statusCode, equalTo(HttpStatus.OK))
		assertThat(response.body, hasEntry(`is`("msg"), `is`("Hello")))
	}

	@Test
	fun `When call a single order by GET then a order with id is returned`() {

		val requestEntity = RequestEntity.get(URI("http://localhost:$port/api/order/1"))
				.accept(MediaType.APPLICATION_JSON).build()
		val response = restTemplate.exchange(requestEntity, orderType)

		assertThat(response.statusCode, equalTo(HttpStatus.OK))
		assertThat(response.body, equalTo(Order("50000111221", "Meier").apply { this.id = 1 }))
	}

}

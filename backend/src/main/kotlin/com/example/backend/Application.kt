package com.example.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer




@SpringBootApplication
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}

@Bean
fun corsConfigurer(): WebMvcConfigurer? {
	return object : WebMvcConfigurer {
		override fun addCorsMappings(registry: CorsRegistry) {
			registry.addMapping("/api").allowedOrigins("http://localhost:8081")
		}
	}
}


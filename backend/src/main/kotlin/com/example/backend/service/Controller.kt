package com.example.backend.service

import com.example.backend.domain.Order
import com.example.backend.repository.OrderRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController()
@RequestMapping("/api")
class Controller {

    private val logger = LoggerFactory.getLogger(Controller::class.java)

    @Autowired
    private lateinit var orderRepository: OrderRepository

    @GetMapping(path = ["/order/{id}"])
    fun getOrderById(@PathVariable("id") id: Long): Order? {
        return orderRepository.findById(id).get()
    }

    @RequestMapping(path = ["/order/{orderNo}/{name}"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(
            @PathVariable("orderNo") orderNo: String,
            @PathVariable("name") name: String
    ): Order {
        return orderRepository.save(Order(orderNo, name))
    }

    @RequestMapping(path = ["/order/{id}"], method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.OK)
    fun deleteOrder(@PathVariable("id") id: Long
    ) {
        orderRepository.deleteById(id)
    }

    /**
     * Forwards all routes to FrontEnd
     */
    @RequestMapping(value = ["{_:^(?!index\\.html|api).*$}"])
    fun redirectApi(): String? {
        logger.info("URL entered directly into the Browser, so we need to redirect...")
        return "forward:/"
    }

}
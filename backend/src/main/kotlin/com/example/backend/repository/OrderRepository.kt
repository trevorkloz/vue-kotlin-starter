package com.example.backend.repository;

import com.example.backend.domain.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface OrderRepository : CrudRepository<Order?, Long?> {
    fun findByOrderNo(@Param("orderNo") orderNo: String): List<Order?>?
    fun findByName(@Param("name") name: String): List<Order?>?
}
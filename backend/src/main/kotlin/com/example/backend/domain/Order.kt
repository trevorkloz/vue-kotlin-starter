package com.example.backend.domain

import javax.persistence.*


@Suppress("JpaDataSourceORMInspection")
@Entity
@Table(name = "orders")
class Order(val orderNo: String?, val name: String?) {

    constructor() : this(null, null) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

}
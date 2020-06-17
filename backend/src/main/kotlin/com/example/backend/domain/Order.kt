package com.example.backend.domain

import javax.persistence.*


@Suppress("JpaDataSourceORMInspection")
@Entity
@Table(name = "orders")
data class Order(val orderNo: String?, val name: String?) {

    constructor() : this(null, null) {
    }

    @Id
    @SequenceGenerator(name="seq_PK", sequenceName="SEQ_PRIMARYKEY", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_PK")
    var id: Long? = null

}
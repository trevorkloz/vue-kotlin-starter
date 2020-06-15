package com.example.backend.idiomatic

/**
 * - use not modifiable fields
 * - use nullable fields
 * - use default fields
 */
data class City(val name: String, var country: Country? = null) {

}

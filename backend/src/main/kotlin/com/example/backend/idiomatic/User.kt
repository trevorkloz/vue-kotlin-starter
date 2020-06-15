package com.example.backend.idiomatic;

/**
 * - Use Data Classes
 */
data class User(var name: String, var address: Address?, val someWeirdName: String = "is set by default") {
}

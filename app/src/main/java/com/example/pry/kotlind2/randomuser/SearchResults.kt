package com.example.pry.kotlind2.randomuser

/**
 * Created by pry on 29/01/2018.
 */


data class Info (val seed: String, val version: String, val page: Int, val results: Int)

data class User(val name: String, val gender: String, val nat: String)


data class Result (val info: Info, val results: List<User>)



//data class Result (val total_count: Int, val incomplete_results: Boolean, val items: List<UserModel>)
//
//
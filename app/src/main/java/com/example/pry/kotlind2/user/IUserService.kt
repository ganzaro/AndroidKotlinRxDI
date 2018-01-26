package com.example.pry.kotlind2.user

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by pry on 23/01/2018.
 */
interface IUserService {

    @GET("api/?inc=gender,name,nat")
    fun getUser(): Observable<UserModel>

}
package com.example.pry.kotlind2.randomuser

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by pry on 23/01/2018.
 */
interface IUserApi {

    @GET("?inc=gender,name,nat")
    fun getUser(): Observable<Result>

//    @GET("?inc=gender,name,nat")
//    fun getInfo(): Observable<InfoModel>

}

//{
//    results: [
//    {
//        gender: "female",
//        name: {
//        title: "mrs",
//        first: "helene",
//        last: "jung"
//    },
//        email: "helene.jung@example.com",
//        nat: "DE"
//    }
//    ],
//    info: {
//    seed: "27ef2b995fa4a9d1",
//    results: 1,
//    page: 1,
//    version: "1.1"
//}
//}



// {"results":[{"gender":"male","name":{"title":"mr","first":"andrew","last":"horton"},"nat":"IE"}],"info":{"seed":"7dcb738985b546df","results":1,"page":1,"version":"1.1"}}

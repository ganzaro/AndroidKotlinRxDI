package com.example.pry.kotlind2.common.states

/**
 * Created by pry on 04/02/2018.
 */

class Resource<T> private constructor(val status: Resource.Status, val data: T?, val error: Throwable?) {
    enum class Status {
        SUCCESS, ERROR, LOADING
    }
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }
        fun <T> error(error: Throwable?): Resource<T> {
            return Resource(Status.ERROR, null, error)
        }
        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}


//class Response private constructor(
//        val status: Status,
//        val data: String,
//        val error: Throwable) {
//
//    companion object {
//
//        fun loading(): Response {
//            return Response(Status.LOADING, null, null)
//        }
//
//        fun success(data: String): Response {
//            return Response(Status.SUCCESS, data, null)
//        }
//
//        fun error(error: Throwable): Response {
//            return Response(Status.ERROR, data="" , error = error)
//        }
//    }
//}

//package com.example.pry.kotlind2.common.states
//
///**
// * Created by pry on 04/02/2018.
// */
//enum class Status {
//    LOADING,
//    SUCCESS,
//    ERROR
//}

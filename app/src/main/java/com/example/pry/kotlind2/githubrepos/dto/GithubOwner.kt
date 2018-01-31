package com.example.pry.kotlind2.githubrepos.dto

import com.squareup.moshi.Json

/**
 * Created by pry on 31/01/2018.
 */

data class GithubOwner (@Json(name = "id")
                        var ownerId: Int,
                        @Json(name = "login")
                        var ownerName: String,
                        @Json(name = "avatar_url")
                        var avatarUrl: String,
                        @Json(name = "url")
                        var userUrl: String,
                        @Json(name = "public_repos")
                        var numOfPublicRepo: Int
)


//@Json(name = "created_at") val createdAt: Date,
//@Json(name = "closed_at") val closedAt: Date?,
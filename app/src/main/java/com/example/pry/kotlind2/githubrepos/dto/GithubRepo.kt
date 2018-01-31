package com.example.pry.kotlind2.githubrepos.dto

import com.squareup.moshi.Json
/**
 * Created by pry on 31/01/2018.
 */


data class GithubRepo (@Json(name = "id")
                       var repoId: Int,
                       @Json(name = "name")
                       var repoName: String,
                       @Json(name = "owner")
                       var githubOwner: GithubOwner,
                       @Json(name = "description")
                       var repoDesc: String
)
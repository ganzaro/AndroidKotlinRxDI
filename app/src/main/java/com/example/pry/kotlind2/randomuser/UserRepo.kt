package com.example.pry.kotlind2.randomuser

import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by pry on 23/01/2018.
 */

class UserRepo @Inject constructor(private val userApiClient: IUserApi) {

    fun getUser(): Observable<Result> {
        return userApiClient.getUser()
    }

//    fun getInfo(): Observable<InfoModel> {
//        return userApiClient.getInfo()
//    }
}




/*

class PlantRepository @Inject constructor(private val plantApiClient: PlantApiClient) {

    fun getAllPlants(): Observable<List<Plant>> {
        return plantApiClient.getPlants()
    }

    fun addPlant(plant: Plant) {
        plantApiClient.addPlant(plant).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                println("YOU DID IT")
            }

            override fun onFailure(call: Call<Void>?, t: Throwable?) {
                println("OH NO")
            }
        })
    }
}

///////////////////////

@Singleton
public class BlizzardController {

    private IBlizzardApi mApi;
    private EventBus mBus;

    @Inject
    public BlizzardController(IBlizzardApi api, EventBus bus) {
        mApi = api;
        mBus = bus;
    }

    public void fetchUserProfile(String tag) {

        mApi.getUserProfile(tag, new Callback<Profile>() {
            @Override
            public void success(Profile profile, Response response) {
                mBus.post(new ProfileEvent(profile));
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });
    }
}
 */
package com.example.pry.kotlind2.githubrepos

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.example.pry.kotlind2.R
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProviders
import retrofit2.adapter.rxjava2.Result.response
import android.R.attr.data
import android.arch.lifecycle.Observer
import com.example.pry.kotlind2.common.states.Resource


/**
 * Created by pry on 31/01/2018.
 */
class GithubRepoActivity : AppCompatActivity() {

    @Inject
    lateinit var mGithubRepo: GithubRepository

    @Inject
    lateinit var viewModelFactory:GithubRepoViewModelFactory

    private lateinit var viewModel: GithubRepoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GithubRepoViewModel::class.java!!)
        viewModel.response.observe(this, Observer{ response -> processResponse(response!!) })

        viewModel.getUserName()

    }

    private fun processResponse(response: Resource<String>) {
        when (response.status) {
            Resource.Status.LOADING -> renderLoadingState()

            Resource.Status.SUCCESS -> renderDataState(response.data)

            Resource.Status.ERROR -> renderErrorState(response.error)
        }
    }

    private fun renderErrorState(error: Throwable?) {

    }

    private fun renderDataState(data: String?) {
        val tv = findViewById(R.id.textView) as TextView
        tv.setText(data)
    }

    private fun renderLoadingState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


//    private fun getUserGender() {
//        val tv = findViewById(R.id.textView) as TextView
//        disposable = mGithubRepo.getUserInfo("pry")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        { result -> tv.setText(result.numOfPublicRepo.toString())},
//                        { error -> Toast.makeText(this, error.message, Toast.LENGTH_LONG).show() }
//                )
//    }
}
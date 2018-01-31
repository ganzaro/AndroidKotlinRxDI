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

/**
 * Created by pry on 31/01/2018.
 */
class GithubRepoActivity : AppCompatActivity() {

    @Inject
    lateinit var mGithubRepo: GithubRepository

    private var disposable: Disposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


        getUserGender()


    }

    private fun getUserGender() {
        val tv = findViewById(R.id.textView) as TextView
        disposable = mGithubRepo.getUserInfo("pry")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
//                        { result -> tv.setText("resultname") },
                        { result -> tv.setText(result.numOfPublicRepo.toString())},
                        { error -> Toast.makeText(this, error.message, Toast.LENGTH_LONG).show() }
                )
    }
}
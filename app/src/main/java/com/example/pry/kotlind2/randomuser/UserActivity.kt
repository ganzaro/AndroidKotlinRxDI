package com.example.pry.kotlind2.randomuser

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.example.pry.kotlind2.R
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UserActivity : AppCompatActivity() {

    @Inject lateinit var mUserRepo: UserRepository

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

//        val tv = findViewById(R.id.textView) as TextView
//        tv.setText("kotlin, sup")
//        tv.setText(mUserRepo.getUser().toString())
        getUserGender()
//        getUserInfo()


    }

    private fun getUserGender() {
        val tv = findViewById(R.id.textView) as TextView
        disposable = mUserRepo.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result -> tv.setText("resultname")},
//                        {result -> tv.setText(result.toString())},
                        {error -> Toast.makeText(this, error.message, Toast.LENGTH_LONG).show() }
                )
    }

//    private fun getUserInfo() {
//        val tv = findViewById(R.id.textView) as TextView
//        disposable = mUserRepo.getInfo()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {result -> tv.setText(result.toString())},
//                        {error -> Toast.makeText(this, error.message, Toast.LENGTH_LONG).show() }
//                )
//    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

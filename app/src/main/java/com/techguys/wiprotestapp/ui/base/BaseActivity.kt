package com.techguys.wiprotestapp.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.techguys.wiprotestapp.WiproTestApplication
import com.techguys.wiprotestapp.di.components.AppComponent

abstract class BaseActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies((application as WiproTestApplication).getAppComp())
        setContentView(getActivityLayout())
        init(savedInstanceState)
    }

    protected abstract fun injectDependencies(appComponent: AppComponent)

    protected abstract fun getActivityLayout():Int

    protected abstract fun init(savedInstanceState: Bundle?)

    protected fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
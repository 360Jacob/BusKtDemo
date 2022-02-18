package com.jacob.busktdemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.snackbar.Snackbar
import com.jacob.busktdemo.ui.theme.BusKtDemoTheme

abstract class BaseActivity: ComponentActivity() {
    private lateinit var mLiveData: MutableLiveData<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        setContentView()
        initData()
       mLiveData = MutableLiveData<String>()
        mLiveData.observe(this, Observer {
            Log.e(this.localClassName+":","onChanged: $it")
        })
        mLiveData.value = "onCreate"
    }
     abstract fun setContentView()
     abstract fun initData()
     fun showToast(txt: String){
         Toast.makeText(this, txt, Toast.LENGTH_LONG).show()
     }

    override fun onStart() {
        super.onStart()
        mLiveData.value = "onStart"
    }

    override fun onResume() {
        super.onResume()
        mLiveData.value = "onResume"
    }

    override fun onRestart() {
        super.onRestart()
        mLiveData.value = "onRestart"
    }

    override fun onPause() {
        super.onPause()
        mLiveData.value = "onPause"
    }

    override fun onStop() {
        super.onStop()
        mLiveData.value = "onStop"
    }

    override fun onDestroy() {
        super.onDestroy()
        mLiveData.value = "onDestroy"
    }
}
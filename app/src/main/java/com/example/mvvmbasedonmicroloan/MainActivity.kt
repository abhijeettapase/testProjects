package com.example.mvvmbasedonmicroloan

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmbasedonmicroloan.ViewModel.MainActivityViewModel
import com.example.mvvmbasedonmicroloan.utils.DataStatus
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_progress.*

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCall.setOnClickListener {
            callApiData()
        }
        btnCallLiveData.setOnClickListener {
            callApiDataUsingStateLiveData()
        }


    }

    private fun callApiData() {
        mainActivityViewModel.getApiData().observe(this, Observer { apiData ->

            if(apiData.isNullOrEmpty()){
                Toast.makeText(this, "Data is empty", Toast.LENGTH_SHORT).show()
                tvMain.text = "Data is Empty"
            }else{
                tvMain.text = "Data Received!!!"
                Log.i("MainActivity", "callApiData Response: $apiData")
            }

        })
    }

    private fun callApiDataUsingStateLiveData(){

        val dialog = ProgressDialog(this)

        mainActivityViewModel.getApiDataUsingStateLiveData().observe(this, Observer { result ->

            when(result.status){

                DataStatus.LOADING -> dialog.showLoading()
                DataStatus.SUCCESS ->{
                    dialog.dismissLoading()
                    tvMain.text = "Data Received!!!"
                    Log.i("MainActivity", "callApiDataUsingStateLiveData Response: ${result.data}")
                }
                DataStatus.COMPLETED -> dialog.dismissLoading()
                DataStatus.ERROR ->{
                    dialog.dismissLoading()
                    Toast.makeText(this, result.error?.message ?: "went so wrong", Toast.LENGTH_SHORT).show()
                }
            }



        })
    }
}
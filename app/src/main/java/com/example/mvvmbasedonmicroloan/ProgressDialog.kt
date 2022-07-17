package com.example.mvvmbasedonmicroloan

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

class ProgressDialog(context: Activity):Dialog(context) {

        init {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setContentView(R.layout.dialog_progress)
            setCancelable(false)
            setCanceledOnTouchOutside(false)
        }

    fun showLoading(){
        if(this.isShowing)
            dismiss()
        show()

    }

    fun dismissLoading(){
        dismiss()
    }
}
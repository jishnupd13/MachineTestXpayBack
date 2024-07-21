package com.xpayback.machinetest.utils

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}

fun Fragment.showToast(msg:String){
    Toast.makeText(this.requireContext(),msg,Toast.LENGTH_SHORT).show()
}
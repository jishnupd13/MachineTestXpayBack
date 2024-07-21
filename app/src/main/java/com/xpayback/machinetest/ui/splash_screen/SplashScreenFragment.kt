package com.xpayback.machinetest.ui.splash_screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.xpayback.machinetest.databinding.FragmentSplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment: Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding
    val viewModel by viewModels<SplashScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    //initializing the views
    private fun initViews(){
        viewModel.timer.observe(viewLifecycleOwner){
            if (it){
                findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToUsersFragment())
            }
        }
    }
}
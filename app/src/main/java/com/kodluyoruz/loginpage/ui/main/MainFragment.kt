package com.kodluyoruz.loginpage.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kodluyoruz.loginpage.base.BaseFragment
import com.kodluyoruz.loginpage.databinding.FragmentMainBinding
import com.kodluyoruz.loginpage.utils.SharedPreferencesModule

class MainFragment : BaseFragment() {
    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.logoutButton?.setOnClickListener {
            SharedPreferencesModule.saveString(SharedPreferencesModule.TOKEN, "")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
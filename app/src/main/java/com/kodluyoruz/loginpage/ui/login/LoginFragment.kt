package com.kodluyoruz.loginpage.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kodluyoruz.loginpage.base.BaseFragment
import com.kodluyoruz.loginpage.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment() {
    private var binding: FragmentLoginBinding? = null

    val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTokenLiveData().observe(viewLifecycleOwner, Observer {
            Log.v("LoginFragment", "it:\n $it \n")
        })

        binding?.let {
            it.textView.text = "Login Screen With ViewBinding"
            it.loginButton.setOnClickListener {
                viewModel.login()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
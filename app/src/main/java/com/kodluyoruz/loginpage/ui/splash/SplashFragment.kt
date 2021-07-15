package com.kodluyoruz.loginpage.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.loginpage.R
import com.kodluyoruz.loginpage.base.BaseFragment
import com.kodluyoruz.loginpage.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment() {
    private var binding: FragmentSplashBinding? = null
    val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLoginObserver().observe(viewLifecycleOwner, Observer {
            navigating(it)
        })

        Handler().postDelayed({
            viewModel.checkUserLoginState()
        }, 500)

    }

    private fun navigating(it: String) {
        Toast.makeText(context, "Login State: $it", Toast.LENGTH_SHORT).show()
        when (it) {
            "login" -> {
                binding?.textView2?.text = "Redirecting to login"
                Handler().postDelayed({
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                }, 1000)
            }
            "main" -> {
                binding?.textView2?.text = "Redirecting to main"
                Handler().postDelayed({
                    findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
                }, 1000)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
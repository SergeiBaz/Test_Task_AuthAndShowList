package com.example.testtask1.view

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testtask1.R
import com.example.testtask1.databinding.FragmentLogInBinding
import com.example.testtask1.model.TokenStorage
import com.example.testtask1.model.User
import com.example.testtask1.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

@AndroidEntryPoint
class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            singInButton.setOnClickListener {
                if (isValidEmailAndPassword(
                        emailEditText.text.toString(),
                        passwordEditText.text.toString()
                    )
                ) {
                    CoroutineScope(Dispatchers.Main).launch {
                        viewModel.logInUser(
                            User(
                                emailEditText.text.toString(),
                                passwordEditText.text.toString()
                            )
                        )
                        progressBar.max = 3000
                        ObjectAnimator.ofInt(
                            progressBar,
                            "progress",
                            500
                        ).setDuration(5000).start()
                        progressBar.visibility = View.VISIBLE
                        delay(5000)
                    }
                    viewModel.currentTokenState.observe(viewLifecycleOwner) {
                        TokenStorage.token = it ?: throw Exception("Токен не пришёл!")
                        findNavController().navigate(R.id.listPaymentsFragment)
                    }
                } else {
                    AlertDialog.Builder(requireContext())
                        .setTitle("Логин/Пароль неверны")
                        .setMessage("Попробуйте ещё раз")
                        .setPositiveButton("Okay") { _, _ ->
                            binding.emailEditText.text = null
                            binding.passwordEditText.text = null
                        }
                        .show()
                }
            }
        }
    }

    private fun isValidEmailAndPassword(email: String?, password: String?): Boolean {
        if (email != "demo" || password != "12345") {
            return false
        }
        return true
    }
}
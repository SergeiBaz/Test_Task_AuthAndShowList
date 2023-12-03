package com.example.testtask1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import kotlinx.coroutines.launch

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
        viewModel.currentTokenState.observe(viewLifecycleOwner) {
            TokenStorage.token = it ?: ""
        }
        viewModel.currentResponseState.observe(viewLifecycleOwner) { it ->
            if (it) {
                Toast.makeText(context, "User authorization success", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.listPaymentsFragment)
            } else {
                viewModel.currentResponseErrorState.observe(viewLifecycleOwner) { message ->
                    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                    binding.emailEditText.text = null
                    binding.passwordEditText.text = null
                }
            }
        }
        binding.apply {
            singInButton.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.logInUser(
                        User(
                            emailEditText.text.toString(),
                            passwordEditText.text.toString()
                        )
                    )
                }
            }
        }
    }
}
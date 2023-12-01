package com.example.testtask1.view

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testtask1.R
import com.example.testtask1.databinding.FragmentLogInBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LogInFragment : Fragment() {
    lateinit var binding: FragmentLogInBinding
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
            singInButton.setOnClickListener{
                CoroutineScope(Dispatchers.Main).launch {
                    progressBar.max = 1000
                    ObjectAnimator.ofInt(
                        progressBar,
                        "progress",
                        1000
                    ).setDuration(3000).start()
                    progressBar.visibility = View.VISIBLE
                    delay(3000)
                    findNavController().navigate(R.id.listPaymentsFragment)
                }
            }
        }
    }
}
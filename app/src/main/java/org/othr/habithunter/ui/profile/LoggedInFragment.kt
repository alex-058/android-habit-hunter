package org.othr.habithunter.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentLoggedInBinding
import org.othr.habithunter.databinding.FragmentProfileBinding

class LoggedInFragment : Fragment() {

    private var _binding: FragmentLoggedInBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoggedInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoggedInBinding.inflate(inflater, container, false)
        val root = binding.root

        return root
    }

}
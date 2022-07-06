package org.othr.habithunter.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentLoggedInBinding

class LoggedInFragment : Fragment() {

    private var _binding: FragmentLoggedInBinding? = null
    private val binding get() = _binding!!

    private lateinit var loggedInViewModel: LoggedInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoggedInBinding.inflate(inflater, container, false)

        loggedInViewModel = ViewModelProvider(this).get(LoggedInViewModel::class.java)

        binding.buttonlogOut.setOnClickListener {
            loggedInViewModel.logOut()
        }



        return binding.root
    }

    override fun onStart() {
        super.onStart()

        loggedInViewModel.liveFirebaseUser.observe (viewLifecycleOwner, Observer { liveFirebaseUser ->
            if (liveFirebaseUser != null) {
                binding.textloggedInUser.setText("Logged In User: " + liveFirebaseUser.getEmail())
                binding.buttonlogOut.setEnabled(true);
            }

            else {
                binding.buttonlogOut.setEnabled(false);
            }
        })

        loggedInViewModel.loggedOut.observe(viewLifecycleOwner, Observer { loggedOut ->
            if (loggedOut) {
                findNavController().navigate(R.id.action_loggedInFragment_to_navigation_profile) }
        })

    }

}
package org.othr.habithunter.ui.profile

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentProfileBinding
import org.othr.habithunter.ui.dashboard.DashboardFragmentDirections
import timber.log.Timber

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var profileViewModel: ProfileViewModel
    private val loggedInViewModel : LoggedInViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.loginButton.setOnClickListener {
            signIn(
                binding.emailFieldText.text.toString(),
                binding.passwordFieldText.text.toString()
            )
        }
        binding.registerButton.setOnClickListener {
            createAccount(
                binding.emailFieldText.text.toString(),
                binding.passwordFieldText.text.toString()
            )
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        profileViewModel.liveFirebaseUser.observe(this, Observer
        { firebaseUser -> if (firebaseUser != null)
        // navigate to loggedIn screen if user is already logged-in
            loggedInViewModel.liveFirebaseUser.value = profileViewModel.liveFirebaseUser.value
            loggedInViewModel.loggedOut.value = false
            findNavController().navigate(R.id.action_navigation_profile_to_navigation_dashboard) })
    }


    private fun createAccount(email: String, password: String) {
        Timber.d("createAccount:$email")
        if (!validateForm()) {
            return
        }

        profileViewModel.register(email, password)
    }



    private fun signIn(email: String, password: String) {
        Timber.d("signIn:$email")
        if (!validateForm()) {
            return
        }

        profileViewModel.login(email, password)
    }

    private fun validateForm(): Boolean {
        var valid = true

        val email = binding.emailFieldText.text.toString()
        if (TextUtils.isEmpty(email)) {
            binding.emailFieldText.error = "Required."
            valid = false
        } else {
            binding.emailFieldText.error = null
        }

        val password = binding.passwordFieldText.text.toString()
        if (TextUtils.isEmpty(password)) {
            binding.passwordFieldText.error = "Required."
            valid = false
        } else {
            binding.passwordFieldText.error = null
        }
        return valid
    }

}
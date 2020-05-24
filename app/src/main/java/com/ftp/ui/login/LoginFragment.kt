package com.ftp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.ftp.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_dashboard_graph)
        }

        register.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_loginFragment_to_signUpFragment,
                null
            )
        )
    }
}

package com.ftp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.ftp.R
import kotlinx.android.synthetic.main.fragment_create_account.*

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login.setOnClickListener { v ->
            v.findNavController().popBackStack()
        }
        create_account.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_createAccountFragment_to_verifyOtpFragment,
                null
            )
        )
    }
}

package com.ftp.ui.grocery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.ftp.R
import com.ftp.ui.MainActivity
import com.ftp.utils.loadImage
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private val navArgs by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = navArgs.product
        product_image.loadImage(product.imgUrl, container) {
            (activity as MainActivity).window?.statusBarColor = it
            (activity as MainActivity).toolbar?.setBackgroundColor(it)
        }

        checkout.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_detailsFragment_to_ftp_checkout_graph)
        }
    }
}

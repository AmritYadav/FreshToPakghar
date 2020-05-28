package com.ftp.ui.cart

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ftp.R
import com.ftp.ui.MainActivity
import com.ftp.ui.cart.adapter.CartProductsAdapter
import com.ftp.ui.grocery.models.Product
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_cart.*

/**
 * A simple [Fragment] subclass.
 */
class CartFragment : Fragment() {

    private lateinit var cartProductsAdapter: CartProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).window?.statusBarColor = Color.WHITE
        (activity as MainActivity).toolbar?.setBackgroundColor(Color.WHITE)

        setupRecycler()
        setupObserver()
    }

    private fun setupRecycler() {
        cartProductsAdapter = CartProductsAdapter()

        rv_cart_products.apply {
            adapter = cartProductsAdapter
            setHasFixedSize(true)
        }
        cartProductsAdapter.submitList(
            listOf(
                Product(
                    1, "coconunt", "", "", 150,
                    100, "", 3, 200
                ),
                Product(
                    2, "coconunt", "", "", 150,
                    100, "", 3, 200
                ),
                Product(
                    3, "coconunt", "", "", 150,
                    100, "", 3, 200
                ),
                Product(
                    4, "coconunt", "", "", 150,
                    100, "", 3, 200
                )

            )
        )
    }

    private fun setupObserver() {

    }

}

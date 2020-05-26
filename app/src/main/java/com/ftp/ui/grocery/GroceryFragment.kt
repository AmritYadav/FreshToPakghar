package com.ftp.ui.grocery

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.ftp.R
import com.ftp.ui.MainActivity
import com.ftp.ui.grocery.adapters.ProductAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_grocery.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class GroceryFragment : Fragment() {

    private val productsViewModel by viewModel<ProductsViewModel>()
    private lateinit var productsAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grocery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).window?.statusBarColor = Color.WHITE
        (activity as MainActivity).toolbar?.setBackgroundColor(Color.WHITE)

        setupRecycler()
        setupObserver()
    }

    private fun setupRecycler() {
        productsAdapter = ProductAdapter() {
            val action = GroceryFragmentDirections.actionGroceryFragmentToDetailsFragment(it)
            view?.findNavController()?.navigate(action)
        }
        rv_grocery.apply {
            adapter = productsAdapter
            setHasFixedSize(true)
        }
    }

    private fun setupObserver() {
        productsViewModel.getProducts().observe(viewLifecycleOwner, Observer {
            productsAdapter.submitList(it)
        })

    }

}

package com.ftp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.ftp.R
import com.ftp.data.common.NetworkState
import com.ftp.ui.dashboard.adapter.CategoryAdapter
import com.ftp.ui.dashboard.adapter.OffersPagerAdapter
import com.ftp.ui.dashboard.models.Category
import com.ftp.ui.dashboard.models.OfferModel
import com.ftp.utils.gone
import com.ftp.utils.showToast
import com.ftp.utils.visible
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.layout_offer_slider_content.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {

    private val categoryViewModel by viewModel<CategoryViewModel>()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryViewModel.loadDashboardCategories()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        slider_view.apply {
            setSliderAdapter(OffersPagerAdapter(OFFERS))
            startAutoCycle()
        }
        setupObserver()
        setupRecycler()
    }

    private fun setupObserver() {
        categoryViewModel.networkState.observe(viewLifecycleOwner) {
            when (it) {
                NetworkState.LOADING -> progress_dashboard.visible(activity?.window)
                else -> {
                    progress_dashboard.gone(activity?.window)
                    it.msg?.let { it1 -> updateUserView(it1) }
                }
            }
        }
        categoryViewModel.categoryList.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
        }
    }

    private fun setupRecycler() {
        categoryAdapter = CategoryAdapter() {
            view?.let { findNavController().navigate(R.id.action_dashboardFragment_to_groceryFragment) }
        }
        rv_category.apply {
            adapter = categoryAdapter
            setHasFixedSize(true)
        }
    }

    private fun updateUserView(message: String) = activity?.showToast(message)
}

val OFFERS = listOf(
    OfferModel(1, R.drawable.slider_img_1),
    OfferModel(2, R.drawable.slider_img_2),
    OfferModel(3, R.drawable.slider_img_3),
    OfferModel(4, R.drawable.slider_img_4)
)

val CATEGORIES = listOf(
    Category(1, R.drawable.ic_grocery, "Grocery"),
    Category(2, R.drawable.ic_poultry, "Poultry")
)

package com.ftp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.ftp.R
import com.ftp.ui.MainActivity
import com.ftp.ui.dashboard.adapter.CategoryAdapter
import com.ftp.ui.dashboard.adapter.OffersPagerAdapter
import com.ftp.ui.dashboard.models.Category
import com.ftp.ui.dashboard.models.OfferModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.layout_offer_slider_content.*

class DashboardFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        rv_category.apply {
            adapter =
                CategoryAdapter(CATEGORIES) { categoryId ->
                    view.findNavController().navigate(R.id.action_dashboardFragment_to_groceryFragment)
                }
        }

    }
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
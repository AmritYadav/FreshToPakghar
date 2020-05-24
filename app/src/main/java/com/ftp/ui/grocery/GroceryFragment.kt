package com.ftp.ui.grocery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ftp.R
import com.ftp.ui.grocery.adapters.ProductAdapter
import com.ftp.ui.grocery.models.Product
import kotlinx.android.synthetic.main.fragment_grocery.*

class GroceryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grocery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_grocery.apply {
            adapter = ProductAdapter(PRODUCTS)
        }
    }
}

val PRODUCTS = listOf(
    Product(1, "Avocado", "", R.drawable.avocado, 240, 225),
    Product(2, "Banana", "", R.drawable.banana, 148, 132),
    Product(3, "Blackberries", "", R.drawable.blackberries, 45, 34),
    Product(4, "Guava", "", R.drawable.guava, 35, 32),
    Product(5, "Kiwis", "", R.drawable.kiwis, 58, 50),
    Product(6, "Mango", "", R.drawable.mango, 25, 18),
    Product(7, "Strawberry", "", R.drawable.strawberry, 55, 49),
    Product(8, "Apple", "", R.drawable.apple, 240, 225),
    Product(9, "Bell Pepper", "", R.drawable.bell_pepper, 240, 225),
    Product(10, "Butternut Squash", "", R.drawable.butternut_squash, 240, 225),
    Product(11, "Coconut", "", R.drawable.coconut, 240, 225),
    Product(12, "Grapes", "", R.drawable.grape, 240, 225),
    Product(13, "Radishes", "", R.drawable.radishes, 240, 225)
)

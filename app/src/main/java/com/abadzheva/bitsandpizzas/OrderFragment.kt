package com.abadzheva.bitsandpizzas

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.abadzheva.bitsandpizzas.databinding.FragmentOrderBinding

class OrderFragment : Fragment(R.layout.fragment_order) {
    private val binding by viewBinding(FragmentOrderBinding::bind)

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbar)
    }
}

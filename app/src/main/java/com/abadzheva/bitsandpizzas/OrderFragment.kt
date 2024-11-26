package com.abadzheva.bitsandpizzas

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.abadzheva.bitsandpizzas.databinding.FragmentOrderBinding
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment(R.layout.fragment_order) {
    private val binding by viewBinding(FragmentOrderBinding::bind)

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbar)
        binding.fab.setOnClickListener {
            val pizzaType = binding.pizzaGroup.checkedRadioButtonId
            if (pizzaType == -1) {
                val textNoChoice = "You need to choose a pizza type"
                Toast.makeText(activity, textNoChoice, Toast.LENGTH_SHORT).show()
            } else {
                var textChoice = (
                    when (pizzaType) {
                        R.id.radio_diavolo -> "Diavolo pizza"
                        else -> "Funghi pizza"
                    }
                )
                val parmesan = view.findViewById<Chip>(R.id.parmesan)
                textChoice += if (parmesan.isChecked) ", extra parmesan" else ""
                val chiliOil = view.findViewById<Chip>(R.id.chili_oil)
                textChoice += if (chiliOil.isChecked) ", extra chili oil" else ""
                Snackbar.make(binding.fab, textChoice, Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}

package com.abadzheva.bitsandpizzas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abadzheva.bitsandpizzas.databinding.FragmentOrderBinding
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root

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
                textChoice += if (binding.parmesan.isChecked) ", extra parmesan" else ""
                textChoice += if (binding.chiliOil.isChecked) ", extra chili oil" else ""
                Snackbar.make(binding.fab, textChoice, Snackbar.LENGTH_SHORT).show()
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

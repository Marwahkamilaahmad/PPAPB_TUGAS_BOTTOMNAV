package com.example.tugaspertemuan10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.tugaspertemuan10.databinding.FragmentOrderBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private val orderTicket = arrayOf(
    "First Class Ticket","Bussiness Class Ticket", "Economy Class Ticket"
)

/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var selectedOrder: String? = null

        with(binding) {
            val adapterOrderTicket = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                orderTicket
            )

            adapterOrderTicket.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
            spinnerOrderTicket.adapter = adapterOrderTicket

            spinnerOrderTicket.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedOrder = spinnerOrderTicket.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

            buttonBuy.setOnClickListener {
                findNavController().apply {
                    previousBackStackEntry?.savedStateHandle?.
                    set("OrderTicket", selectedOrder)
                }.navigateUp()
            }
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            OrderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
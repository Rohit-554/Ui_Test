package `in`.jadu.uitest.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import `in`.jadu.uitest.R
import `in`.jadu.uitest.databinding.FragmentRefineBinding


class Refine : Fragment() {
    private lateinit var binding: FragmentRefineBinding
    private lateinit var dropDownArrayAdapter: ArrayAdapter<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRefineBinding.inflate(inflater, container, false)
        binding.chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            checkedIds.forEach {
                when(it){
                    R.id.chip1 -> {
                        binding.chip1.isChecked = true
                    }
                    R.id.chip2 -> {
                        binding.chip2.isChecked = true
                    }
                    R.id.chip3 -> {
                        binding.chip3.isChecked = true
                    }
                    R.id.chip4 -> {
                        binding.chip4.isChecked = true
                    }
                    R.id.chip5 -> {
                        binding.chip5.isChecked = true
                    }
                    R.id.chip6 -> {
                        binding.chip6.isChecked = true
                    }
                }
            }
        }
        setupAvailabilityFilters()
        return binding.root
    }

    private fun setupAvailabilityFilters() {
        binding.availabilitySelector.onItemClickListener =
            AdapterView.OnItemClickListener() { _: AdapterView<*>, _: View, position: Int, _: Long ->
                val goalValues:List<String> = listOf("Available | Hey Let Us Connect", "Away | Stay Discreet ", "Not Available | Busy", "SOS| Need Help")
                val selectedValue = goalValues[position]
                binding.availabilitySelector.setText(selectedValue,false)
            }
    }

    override fun onResume() {
        super.onResume()
        dropDownArrayAdapter = ArrayAdapter(
            requireContext(),
            R.layout.availability_selector,
            listOf("Available | Hey Let Us Connect", "Away | Stay Discreet ", "Not Available | Busy", "SOS| Need Help")
        )
        binding.availabilitySelector.setAdapter(dropDownArrayAdapter)

    }


}
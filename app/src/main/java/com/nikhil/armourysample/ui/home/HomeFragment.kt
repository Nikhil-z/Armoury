package com.nikhil.armourysample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nikhil.armoury.utils.callback.Resource
import com.nikhil.armourysample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }



        homeViewModel.deviceConfiguration.observe(viewLifecycleOwner) { configModelResource ->

            when (configModelResource) {
                is Resource.Success -> {

                    Toast.makeText(requireContext(), "Success ${configModelResource.message}", Toast.LENGTH_SHORT).show()
                }

                is Resource.Error -> {
                    Toast.makeText(requireContext(), "Error ${configModelResource.message}", Toast.LENGTH_SHORT).show()
                }

                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "Loading ${configModelResource.message}", Toast.LENGTH_SHORT).show()
                }
            }

            /*  configModelResource.data?.let {
                  Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
              }


              Toast.makeText(requireContext(), "${configModelResource.message}", Toast.LENGTH_SHORT)
                  .show()*/
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
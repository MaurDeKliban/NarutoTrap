package com.example.narutotrap.narutoViewModel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.narutotrap.R
import com.example.narutotrap.databinding.NarutoListFragmentBinding

class NarutoListFragment : Fragment() {

    private val viewModel: NarutoViewModel by viewModels()
    private var _binding: NarutoListFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NarutoListFragmentBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NarutoGridAdapter()
        viewModel.characters.observe(this.viewLifecycleOwner) { items ->
            items.let {
                adapter.submitList(it)
            }
        }
        binding.narutoGrid.adapter = adapter
        binding.narutoGrid.layoutManager = LinearLayoutManager(this.context)
    }
}


package com.example.demoappfornewjoiner.fragment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demoappfornewjoiner.databinding.Fragment3Binding

class Fragment3:Fragment() {

	private var binding: Fragment3Binding? = null

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		binding = Fragment3Binding.inflate(inflater, container, false)
		return binding?.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		arguments?.let {
			binding?.textViewFragment3?.text = Fragment3Args.fromBundle(it).testData
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		binding = null
	}
}
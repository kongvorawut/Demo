package com.example.demoappfornewjoiner.fragment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.demoappfornewjoiner.R
import com.example.demoappfornewjoiner.base.BaseFragment
import com.example.demoappfornewjoiner.databinding.Fragment1Binding
import com.example.demoappfornewjoiner.fragment2.presenter.Fragment2

class Fragment1 : BaseFragment() {

	private var binding: Fragment1Binding? = null

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		binding = Fragment1Binding.inflate(inflater, container, false)
		return binding?.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		arguments?.let {
			binding?.textView?.text = Fragment1Args.fromBundle(it).data
		}

		binding?.buttonToFragment2?.setOnClickListener {
			val name = "Kong"
			findNavController().navigate(R.id.toFragment2, Bundle().apply {
				putString(Fragment2.KEY_NAME, name)
			})
		}

		binding?.buttonToFragment3?.setOnClickListener {
			findNavController().navigate(Fragment1Directions.toFragment3(testData = "Tar"))
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		binding = null
	}
}
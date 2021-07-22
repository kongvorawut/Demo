package com.example.demoappfornewjoiner.fragment2.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.demoappfornewjoiner.base.BaseFragment
import com.example.demoappfornewjoiner.databinding.Fragment2Binding
import javax.inject.Inject

class Fragment2: BaseFragment(), Fragment2Contract.View {

	@Inject
	lateinit var presenter: Fragment2Contract.UserActionListener

	private var binding: Fragment2Binding? = null

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		binding = Fragment2Binding.inflate(inflater, container, false)
		return binding?.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		presenter.randomCat()
	}

	override fun showCat(url: String) {
		binding?.let {
			Glide.with(this).load(url).into(it.imageView)
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		binding = null
	}

	companion object {
		const val KEY_NAME = "key_name"
	}
}
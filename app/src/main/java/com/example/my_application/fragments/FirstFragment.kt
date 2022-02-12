package com.example.my_application.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_application.R
import com.example.my_application.adapters.ElementsAdapter
import com.example.my_application.classes.Element
import com.example.my_application.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), ElementsAdapter.ItemClickListener {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.elements.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
        Element.fillElements()
        binding.elements.adapter = ElementsAdapter(this, Element.getElements())
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }

    override fun onItemClick(element: Element, view: AppCompatImageView) {
        val actions = activity?.supportFragmentManager?.beginTransaction()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            actions?.addSharedElement(view, element.getTitle())
        actions?.addToBackStack(null)?.replace(R.id.FrameLayout, SecondFragment.newInstance(element))?.commit()
    }
}
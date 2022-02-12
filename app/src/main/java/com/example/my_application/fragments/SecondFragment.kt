package com.example.my_application.fragments

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.my_application.R
import com.example.my_application.classes.Constants
import com.example.my_application.classes.Element
import com.example.my_application.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSecondBinding.inflate(inflater)

        val bundle = arguments ?: return binding.root
        binding.avatarFr2.setImageResource(bundle.getInt(Constants.AVATAR))
        binding.elementTitleFr2.text = bundle.getString(Constants.TITLE)
        binding.elementDescriptionFr2.text = bundle.getString(Constants.DESCRIPTION)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            binding.avatarFr2.transitionName = bundle.getString(Constants.TITLE)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_elements, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.close -> activity?.finish()
            R.id.back -> activity?.supportFragmentManager?.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun newInstance(element: Element): SecondFragment {
            val secondFragment = SecondFragment()
            val bundle = Bundle()
            bundle.putInt(Constants.AVATAR, element.getAvatar())
            bundle.putString(Constants.TITLE, element.getTitle())
            bundle.putString(Constants.DESCRIPTION, element.getDescription())
            secondFragment.arguments = bundle
            return secondFragment
        }
    }
}
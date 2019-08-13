package com.example.waterbalance.View


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.waterbalance.R
import kotlinx.android.synthetic.main.fragment_info.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_info, container, false)

        val waterV = rootView.waterBtn
        val coffeV = rootView.coffeBtn
        val teaV = rootView.teaBtn
        val juseV = rootView.juseBtn

        waterV.setOnClickListener {
            var bundle: Bundle  = bundleOf("drink" to "water")
            it.findNavController().navigate(R.id.action_infoFragment_to_aditionFragment, bundle)
        }

        coffeV.setOnClickListener {
            var bundle  = bundleOf("drink" to "coffee")
            it.findNavController().navigate(R.id.action_infoFragment_to_aditionFragment, bundle)
        }

        teaV.setOnClickListener {
            var bundle  = bundleOf("drink" to "tea")
            view?.findNavController()?.navigate(R.id.action_infoFragment_to_aditionFragment, bundle)
        }

        juseV.setOnClickListener {
            var bundle = bundleOf("drink" to "juse")
            view?.findNavController()?.navigate(R.id.action_infoFragment_to_aditionFragment, bundle)
        }


        return rootView
    }


}

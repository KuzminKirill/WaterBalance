package com.example.waterbalance.View


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.waterbalance.Model.WaterDrinks
import com.example.waterbalance.Presistance.WaterRepository
import android.widget.SeekBar
import kotlinx.android.synthetic.main.fragment_adition.view.*
import kotlinx.android.synthetic.main.fragment_adition.view.drinkTypeText
import kotlinx.coroutines.runBlocking


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AditionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(com.example.waterbalance.R.layout.fragment_adition, container, false)

        var mWaterRepo = WaterRepository(context)

        val drinkText = rootView.drinkTypeText
        val mil = rootView.mililiters
        val bar = rootView.seekBar
        var subBtn = rootView.submit

        var mills = 0

        bar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                mil.text = progress.toString()
                mills = progress
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //
            }

        })
        val drink = arguments?.getString("drink")
        drinkText.text = drink

        subBtn.setOnClickListener{
            runBlocking {
                //mWaterRepo.insertTask()
            }
        }

        return rootView
    }




}

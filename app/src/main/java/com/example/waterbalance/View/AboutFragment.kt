package com.example.waterbalance.View


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import android.content.SharedPreferences;
import android.content.Context.MODE_PRIVATE
import android.util.Log
import androidx.navigation.findNavController
import com.example.waterbalance.R


class AboutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        lateinit var pref: SharedPreferences

        //счетчики параметров
        var height_count = 0
        var mass_count = 0
        var old_count = 0

        val rootView: View = inflater.inflate(R.layout.fragment_about, container, false)

        //бары
        var height = rootView.findViewById<SeekBar>(R.id.height)
        val mass = rootView.findViewById<SeekBar>(R.id.mass)
        val old = rootView.findViewById<SeekBar>(R.id.old)

        //текстовые поля
        val heightText = rootView.findViewById<TextView>(R.id.height_text)
        val massText = rootView.findViewById<TextView>(R.id.mass_text)
        val oldText = rootView.findViewById<TextView>(R.id.old_text)

        var sex = rootView.findViewById<Switch>(R.id.sex_switch)

        var check: Boolean = true  //пол

        val submit = rootView.findViewById<Button>(R.id.sumbitBtn)

        //проверка положения счетчика
        if (sex != null) {
            sex.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
                override fun onCheckedChanged(p0: CompoundButton?, isChecked: Boolean) {
                    check = isChecked
                }

            })
        }


        height.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                heightText.text = progress.toString()
                height_count = progress

            }
        })


        mass.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                massText.text = progress.toString()
                mass_count = progress

            }
        })


        old.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                oldText.text = progress.toString()
                old_count = progress

            }
        })

        submit.setOnClickListener {
            pref = activity!!.getSharedPreferences("Settings", MODE_PRIVATE)
            val editor = pref.edit()

            try {
                editor.putFloat("water", formula(height_count, mass_count, old_count))
                editor.apply()
                it.findNavController().navigate(R.id.action_aboutFragment_to_infoFragment)
            } catch (e: Exception) {
                Log.e("save issue", "Something wrong with save")
            }


        }



        return rootView


    }

}

fun formula(
    height: Int,
    mass: Int,
    old: Int
): Float { //формула подсчета количества воды, может быть любая, тут для примера
    return (height + mass + old).toFloat()
}













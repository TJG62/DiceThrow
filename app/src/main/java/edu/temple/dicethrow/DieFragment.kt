package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"
    val CURRENT_DIE_VALUE = "currentValue"

    lateinit var dieTextView: TextView

    lateinit var dieViewModel: DieViewModel

    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
        dieViewModel = ViewModelProvider(this)[DieViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dieViewModel.getCurrentIndex().observe(viewLifecycleOwner){
            dieTextView.text = it.toString()
        }





        if(dieViewModel.getCurrentIndex().value == null)
            throwDie()

    }

    fun throwDie() {
        dieViewModel.setCurrentIndex(Random.nextInt(dieSides) + 1)
    }

    fun throwDie(dieNum: Int){
        dieTextView.text = dieNum.toString()
    }


}
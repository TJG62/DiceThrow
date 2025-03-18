package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"
    val CURRENT_DIE_VALUE = "currentValue"
    var currentIndex = 0
    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(CURRENT_DIE_VALUE, currentIndex)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(savedInstanceState ==null){
            throwDie()
        }else{
            currentIndex = savedInstanceState.getInt(CURRENT_DIE_VALUE)
            dieTextView.text = currentIndex.toString()
        }
    }

    fun throwDie() {
        currentIndex = (Random.nextInt(dieSides) + 1)
        dieTextView.text = currentIndex.toString()
    }

    fun throwDie(dieNum: Int){
        dieTextView.text = dieNum.toString()
    }


}
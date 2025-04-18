package home.tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.R
import com.example.islamy.databinding.FragmentHadeethBinding
import com.example.islamy.databinding.FragmentSebhaBinding

class tasbeeh_fragment : Fragment(){
    lateinit var viewBinding: FragmentSebhaBinding
    lateinit var azkarList: MutableList<String>
    private var currentIndex =0
    private var counter =0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        initView()
        onsebhaClick()


    }

    private fun onsebhaClick() {
        viewBinding.sebhaBody.setOnClickListener{
            viewBinding.sebhaBody.rotation+=(360/33).toFloat()

            if(counter<33){
                counter++
            }
            else{
                counter = 0
                val  lastINdex = azkarList.size-1
                currentIndex = if (currentIndex < lastINdex)
                    ++currentIndex else 0
                viewBinding.tvzikr.text  = azkarList[currentIndex]
            }
            viewBinding.txcounter.text = "$counter"
        }
    }

    private fun initView() {
        viewBinding.tvzikr.text = azkarList[currentIndex]
        viewBinding.txcounter.text="$counter"
    }

    override fun onDestroy(){
        super.onDestroy()

    }

}
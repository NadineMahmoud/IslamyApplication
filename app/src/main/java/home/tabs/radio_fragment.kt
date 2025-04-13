package home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.databinding.FragmentHadeethBinding
import com.example.islamy.databinding.FragmentRadioBinding

class radio_fragment : Fragment(){
    lateinit var viewBinding: FragmentRadioBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentRadioBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

}
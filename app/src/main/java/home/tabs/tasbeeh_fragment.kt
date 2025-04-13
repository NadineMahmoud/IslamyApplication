package home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.databinding.FragmentHadeethBinding
import com.example.islamy.databinding.FragmentSebhaBinding

class tasbeeh_fragment : Fragment(){
    lateinit var viewBinding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

}
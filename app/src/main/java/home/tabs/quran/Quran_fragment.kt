package home.tabs.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islamy.ChapterDetailsActivity
import com.example.islamy.R
import com.example.islamy.databinding.FragmentQuranBinding
import home.AppConstans

class quran_fragment : Fragment() {
    lateinit var  viewBinding : FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentQuranBinding.inflate(
            inflater,
            container,
            false
        )
        return viewBinding.root
    }

    lateinit var adapter: chapters_adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = chapters_adapter(chpters)
        adapter.onItemClicked = chapters_adapter.onItemClick{position, chapter ->
            val intent  = Intent(activity,ChapterDetailsActivity::class.java)
            intent.putExtra(AppConstans.EXTRA.Extra_CHAPTER,chapter)
            startActivity(intent)
        }
        viewBinding.chapterRecycler.adapter = adapter
    }

    val chpters= AppConstans.getChapters()


}
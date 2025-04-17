package home.tabs.quran

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamy.databinding.ItemVerseBinding

class VersesAdapter(val verses : List<String>) :RecyclerView.Adapter<ViewHolder>(){

    class viewHolder (val binding: ItemVerseBinding): RecyclerView.ViewHolder(

        binding.root
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = verses.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}

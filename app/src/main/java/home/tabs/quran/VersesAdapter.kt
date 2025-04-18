package home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.ItemVerseBinding

class VersesAdapter(private val verses: List<String>) :
    RecyclerView.Adapter<VersesAdapter.VerseViewHolder>() {

    class VerseViewHolder(val binding: ItemVerseBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVerseBinding.inflate(inflater, parent, false)
        return VerseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) {
        holder.binding.content.text = verses[position]
    }

    override fun getItemCount(): Int = verses.size
}

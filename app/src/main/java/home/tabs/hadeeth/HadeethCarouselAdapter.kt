package home.tabs.hadeeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.ItemHadeethBinding
import models.Hadeeth

class HadeethCarouselAdapter(val hadeethList:List<Hadeeth>):
    RecyclerView.Adapter<HadeethCarouselAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemHadeethBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemHadeethBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = hadeethList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeeth = hadeethList[position]
        holder.viewBinding.title.text = hadeeth.title
        holder.viewBinding.content.text = hadeeth.content
    }
}
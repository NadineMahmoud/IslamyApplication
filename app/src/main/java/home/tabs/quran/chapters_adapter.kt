package home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.ItemChapterBinding
import models.chapter

class chapters_adapter (val chapters:List<chapter>): RecyclerView.Adapter<chapters_adapter.viewHolder>() {

    class viewHolder(val itemBinding: ItemChapterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemBinding = ItemChapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return viewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val chapter = chapters[position]

        holder.itemBinding.arTitleTv.text = chapter.titleAR
        holder.itemBinding.enTitleTv.text = chapter.titleEN
        holder.itemBinding.versesNum.text = chapter.versesNum
        holder.itemBinding.chapterIndexTv.text = "${chapter.index + 1}"
        onItemClicked?.let { onClick->
            holder.itemView.setOnClickListener {
                onClick.onItemClick(position, chapter)
            }
        }
    }

    var onItemClicked: onItemClick? = null

    fun interface onItemClick {
        fun onItemClick(position: Int, chapter: chapter)
    }
}
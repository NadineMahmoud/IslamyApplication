package home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.databinding.FragmentHadeethBinding
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import home.tabs.hadeeth.HadeethCarouselAdapter
import models.Hadeeth

class HadeethFragment : Fragment() {

    private lateinit var viewBinding: FragmentHadeethBinding
    private val hadeethLinesList: MutableList<Hadeeth> = mutableListOf()
    private lateinit var adapter: HadeethCarouselAdapter
    private lateinit var layoutManager: CarouselLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHadeethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHadeethRecycler()
        readHadeethFile()
    }

    private fun initHadeethRecycler() {
        // 1. تهيئة الـ Adapter قبل الاستخدام
        adapter = HadeethCarouselAdapter(hadeethLinesList)

        // 2. إصلاح خطأ `LayoutManager`
        layoutManager = CarouselLayoutManager(FullScreenCarouselStrategy())

        // 3. تعيين القيم الصحيحة لـ RecyclerView
        viewBinding.hadeethRecycler.layoutManager = layoutManager
        viewBinding.hadeethRecycler.adapter = adapter

        // 4. تفعيل Snap Helper عشان يعمل Scroll سلس
        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(viewBinding.hadeethRecycler)
    }

    private fun readHadeethFile() {
        val fileContent = context?.assets?.open("Ahadeeth.txt")

            ?.bufferedReader()
            ?.use { it.readText() }
            ?.trim() ?: return
        if (fileContent.isEmpty()) {
            println("File is empty or not found")
            return
        }

            val hadeethList = fileContent.split("#").mapNotNull { singleHadeeth ->
            val lines = singleHadeeth.trim().lines()
            if (lines.isNotEmpty()) {
                val title = lines.first()
                val content = lines.drop(1).joinToString("\n")
                Hadeeth(title, content)
            } else {
                null
            }
        }

        hadeethLinesList.clear()
        hadeethLinesList.addAll(hadeethList)

        // تحديث بيانات الـ Adapter بعد تحميل البيانات
        adapter.notifyDataSetChanged()
    }
}

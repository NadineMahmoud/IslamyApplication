package home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamy.R
import com.example.islamy.databinding.ActivityMainBinding
import home.tabs.HadeethFragment
import home.tabs.quran.quran_fragment
import home.tabs.radio_fragment
import home.tabs.tasbeeh_fragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            var fragment: Fragment = when (menuItem.itemId) {
                R.id.quran -> {quran_fragment()}
                R.id.hadeeth->{HadeethFragment()}
                R.id.tasbeeh -> { tasbeeh_fragment() }
                R.id.radio -> { radio_fragment() }
                else -> {
                    radio_fragment()
                }
            }
            showFragment(fragment)
            return@setOnItemSelectedListener true
        }
        binding.bottomNavView.selectedItemId =R.id.quran
    }

        fun showFragment(fragment: Fragment) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()

        }


    }

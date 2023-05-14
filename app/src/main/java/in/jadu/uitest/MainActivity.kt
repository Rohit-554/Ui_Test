package `in`.jadu.uitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import `in`.jadu.uitest.adapters.UserDisplayAdapter
import `in`.jadu.uitest.screens.ExploreFrag
import `in`.jadu.uitest.screens.Refine

class MainActivity : AppCompatActivity() {
    var frames:FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        frames = findViewById(R.id.frames_ui)
        supportFragmentManager.beginTransaction().replace(R.id.frames_ui, Refine()).commit()
        setupBottomNav()
    }



    private fun setupBottomNav() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener {item->
            when(item.itemId){
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frames_ui, Refine()).commit()
                }
                R.id.explore -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frames_ui, ExploreFrag()).commit()
                }
            }
            true
        }
    }
}
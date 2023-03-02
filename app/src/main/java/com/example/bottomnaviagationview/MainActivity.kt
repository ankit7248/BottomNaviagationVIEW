package com.example.bottomnaviagationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        val fourthFragment = FourthFragment()

        setcurrentFragment(secondFragment)


        bottomNavigationView.setOnNavigationItemSelectedListener{
                when(it.itemId)
                {
                    R.id.miHome -> setcurrentFragment(firstFragment)
                    R.id.miMessage -> setcurrentFragment(secondFragment)
                    R.id.miProfile -> setcurrentFragment(thirdFragment)
                    R.id.miPhone -> setcurrentFragment(fourthFragment)
                }
                true
        }
        bottomNavigationView.getOrCreateBadge(R.id.miMessage).apply {
            number = 10
            isVisible = true
        }

        bottomNavigationView.getOrCreateBadge(R.id.miPhone).apply {
            number = 12
            isVisible = true
        }
    }

    private fun setcurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}
package com.kodego.activity.one.studentassistanceapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityStudentAppHomeScreenBinding
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityStudentCalendarBinding
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityViewPagerBinding

class ViewPager : AppCompatActivity() {

    lateinit var binding: ActivityViewPagerBinding

    private var introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Manage your Account",
                "",
                R.drawable.studentprofile
            ),
            IntroSlide(
                "View your Schedule",
                "",
                R.drawable.studentschedule
            ),
            IntroSlide(
                "Be up to date with Announcements",
                "",
                R.drawable.megaphonepink
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //DON'T FORGET THE BINDING. !!! :-)
        binding.introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)
        binding.introSliderViewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        binding.buttonNext.setOnClickListener  {
            if (binding.introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount){
                binding.introSliderViewPager.currentItem  += 1
            }else{
                Intent(applicationContext, LoginSAv2::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
        binding.textSkipIntro.setOnClickListener{
            Intent(applicationContext, LoginSAv2::class.java).also {
                startActivity(it)
                finish()
        }
        }
    }

    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(0,0,0,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.indicatorsContainer.addView(indicators[i])
        }
    }
    private fun setCurrentIndicator(index: Int){
        val childCount = binding.indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = binding.indicatorsContainer[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.indicator_active
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}
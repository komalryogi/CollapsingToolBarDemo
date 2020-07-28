package com.komal.collapsetoolbardemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initCollapsingToolbar() {
        ctl_slider.title = ""
        app_bar_layout.setExpanded(true)

        // hiding & showing the title when toolbar expanded & collapsed
        app_bar_layout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    try {
                        ctl_slider.title = ""
                    } catch (e: Exception) {
                        e.printStackTrace()
                        ctl_slider.title = getString(R.string.app_name)
                    }
                    isShow = true
                } else if (isShow) {
                    ctl_slider.title = " "
                    isShow = false
                }
            }
        })
    }
}
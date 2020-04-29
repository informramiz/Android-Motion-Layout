package github.informramiz.motionlayoutanimations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout

class Step8Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step8)

        coordinateMotion()
    }

    private fun coordinateMotion() {
        val appBar = findViewById<AppBarLayout>(R.id.appbar_layout)
        val motionLayout: MotionLayout = findViewById(R.id.motion_layout)
        appBar.addOnOffsetChangeProgressListener { progress ->
            motionLayout.progress = progress
        }
    }

    private fun AppBarLayout.addOnOffsetChangeProgressListener(callback: (progress: Float) -> Unit) {
        addOnOffsetChangedListener( AppBarLayout.OnOffsetChangedListener{ _, verticalOffset ->
            val seekPosition = -verticalOffset / totalScrollRange.toFloat()
            callback(seekPosition)
        })
    }
}

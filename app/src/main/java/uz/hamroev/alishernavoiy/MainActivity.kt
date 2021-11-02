package uz.hamroev.alishernavoiy

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.snackbar.Snackbar
import uz.hamroev.alishernavoiy.activity.HomeActivity
import uz.hamroev.alishernavoiy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()

        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 2000)

        startAnimation()

        binding.introImg.setOnLongClickListener {
            val snack = Snackbar.make(it,"Doston Hamroyev",Snackbar.LENGTH_LONG)
            snack.show()
            true
        }


    }

    private fun startAnimation() {
        binding.introTv.setText("")
        binding.introTv.animateText("Alisher Navoiy")
        binding.introTv.setCharacterDeley(50)

        val anim = AnimationUtils.loadAnimation(this, R.anim.intro_img)
        binding.introImg.startAnimation(anim)

    }
}
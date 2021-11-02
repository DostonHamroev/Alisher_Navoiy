package uz.hamroev.alishernavoiy.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pdfview.PDFView
import uz.hamroev.alishernavoiy.R
import uz.hamroev.alishernavoiy.cache.Cache
import uz.hamroev.alishernavoiy.databinding.ActivitySlaydBinding

class SlaydActivity : AppCompatActivity() {
    lateinit var binding: ActivitySlaydBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlaydBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Cache.init(this)
        loadData()
    }

    private fun loadData() {
        when (Cache.position) {
            "0" -> {
                findViewById<PDFView>(R.id.pdf_view).fromAsset("slayd1.pdf").show()
            }
            "1" -> {
                findViewById<PDFView>(R.id.pdf_view).fromAsset("slayd2.pdf").show()
            }
            "2" -> {
                findViewById<PDFView>(R.id.pdf_view).fromAsset("slayd3.pdf").show()
            }
        }
    }
}
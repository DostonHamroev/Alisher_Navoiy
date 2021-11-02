package uz.hamroev.alishernavoiy.activity

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import uz.hamroev.alishernavoiy.R
import uz.hamroev.alishernavoiy.adapter.MyMenuAdapter
import uz.hamroev.alishernavoiy.adapter.SearchAdapter
import uz.hamroev.alishernavoiy.adapter.onMyMeneClickListener
import uz.hamroev.alishernavoiy.cache.Cache
import uz.hamroev.alishernavoiy.databinding.ActivityHomeBinding
import uz.hamroev.alishernavoiy.db.MavzuDatabase
import uz.hamroev.alishernavoiy.model.Mavzu
import uz.hamroev.alishernavoiy.model.MyMenu

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var myMenuAdapter: MyMenuAdapter
    lateinit var list: ArrayList<MyMenu>
    lateinit var database: MavzuDatabase
    lateinit var data: ArrayList<Mavzu>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        database = MavzuDatabase(binding.root.context)
        data = database.getMavzu()

        Cache.init(binding.root.context)
        loadData()
        myMenuAdapter = MyMenuAdapter(binding.root.context, list, object : onMyMeneClickListener {
            override fun onMyClick(myMenu: MyMenu, position: Int) {
                when (position) {
                    0 -> {
                        Cache.position = "0"
                        startActivity(Intent(binding.root.context, SlaydActivity::class.java))

                    }
                    1 -> {
                        Cache.position = "1"
                        startActivity(Intent(binding.root.context, SlaydActivity::class.java))
                    }
                    2 -> {
                        Cache.position = "2"
                        startActivity(Intent(binding.root.context, SlaydActivity::class.java))
                    }
                }
            }
        })
        binding.rvMenu.adapter = myMenuAdapter

        searchItems()
    }

    private fun searchItems() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0!!.isEmpty()) {
                    binding.rvMenu.adapter = myMenuAdapter
                } else
                    filter(p0.toString())
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0!!.isEmpty()) {
                    binding.rvMenu.adapter = myMenuAdapter
                } else
                    filter(p0.toString())
                return true
            }

        })
    }

    private fun filter(string: String) {
         val list = ArrayList<Mavzu>()
        for (datum in data) {
            if ( datum.title!!.contains(string)
            ) {
                list.add(datum)
            }
        }
        var searchAdapter = SearchAdapter(this, list)
        binding.rvMenu.adapter = searchAdapter
    }


    private fun loadData() {
        list = ArrayList()
        list.add(MyMenu("Alisher\nNavoiyning\nHayoti", R.drawable.menu1))
        list.add(MyMenu("Davlat\nva\nJamoat\nArbobi", R.drawable.menu2))
        list.add(MyMenu("Xamsa", R.drawable.menu3))
    }
}
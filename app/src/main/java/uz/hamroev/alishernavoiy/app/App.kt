package uz.hamroev.alishernavoiy.app

import android.app.Application
import uz.hamroev.alishernavoiy.db.MavzuDatabase

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        MavzuDatabase.init(this)
    }
}
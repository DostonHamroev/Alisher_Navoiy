package uz.hamroev.alishernavoiy.cache

import android.content.Context
import android.content.SharedPreferences


object Cache {
    private const val NAME = "alishernavoiy"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context){
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var til:String?
        get() = sharedPreferences.getString("til1","ru")
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putString("til1",value)
            }
        }

    var position:String?
        get() = sharedPreferences.getString("joy","0")
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putString("joy",value)
            }
        }

    var mavzu:String?
        get() = sharedPreferences.getString("mavzu1","0")
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putString("mavzu1",value)
            }
        }

    var night: Boolean?
        get() = sharedPreferences.getBoolean("n", true)
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null) {
                it.putBoolean("n", value)
            }
        }

    var exit:String?
        get() = sharedPreferences.getString("exit1","0")
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putString("exit1",value)
            }
        }

}
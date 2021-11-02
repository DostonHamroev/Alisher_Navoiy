package uz.hamroev.alishernavoiy.db

import android.content.Context
import uz.hamroev.alishernavoiy.model.Mavzu

class MavzuDatabase(context: Context) : DataBaseHelper(context, "navoiy.db") {

    private val TABLE_NAME = "navoiy"
    private val ID = "id"

    private val INFO = "info"

    companion object {
        @Volatile
        private var database: MavzuDatabase? = null

        fun init(context: Context) {
            synchronized(this) {
                if (database == null) {
                    database = MavzuDatabase(context.applicationContext)
                }
            }
        }

        fun getDatabase(): MavzuDatabase = database!!
    }

    fun getMavzu(): ArrayList<Mavzu> {
        val readableDatabase = database?.readableDatabase
        val data = ArrayList<Mavzu>()
        val cursor = readableDatabase?.rawQuery("select * from ${TABLE_NAME}", null)
        cursor?.moveToFirst()
        while (!cursor!!.isAfterLast) {
            data.add(
                Mavzu(
                    cursor.getInt(cursor.getColumnIndex(ID)),
                    cursor.getString(cursor.getColumnIndex(INFO))
                )
            )
            cursor.moveToNext()
        }
        cursor.close()
        return data
    }

}
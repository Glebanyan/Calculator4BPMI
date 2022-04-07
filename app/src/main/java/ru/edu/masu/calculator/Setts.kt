package ru.edu.masu.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var sharedPreferences: SharedPreferences

class Setts : AppCompatActivity() {

    private lateinit var saveData: SaveData

    @SuppressLint("CutPasteId")
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        saveData = SaveData(this)
        when {
            saveData.loadDarkModeState() == "1" -> {
                setTheme(R.style.AppBaseTheme)

            }
            saveData.loadDarkModeState() == "2" -> {
                setTheme(R.style.AppThemeDark)
            }
            saveData.loadDarkModeState() == "3" -> {
                setTheme(R.style.AppTheme)
            }
        }

        when {
            saveData.loadLang() == "en" -> {
                val context = LocaleHelper.setLocale(this, "en")
                val resources = context.resources

                setContentView(R.layout.setts)


                val inflatedView = getLayoutInflater().inflate(R.layout.activity_main, null);
                val cp: TextView = inflatedView.findViewById(R.id.copy);


                val messageView: TextView = findViewById(R.id.textView)
                val rb1: RadioButton = findViewById(R.id.light)
                val rb2: RadioButton = findViewById(R.id.dark)
                val rb3: RadioButton = findViewById(R.id.child)
                val men: TextView = findViewById(R.id.menu)
                val AV: TextView = findViewById(R.id.AV)

                messageView.text = resources.getString(R.string.textView)
                rb1.text = resources.getString(R.string.light)
                rb2.text = resources.getString(R.string.dark)
                rb3.text = resources.getString(R.string.child)
                men.text = resources.getString(R.string.menu)
                AV.text = resources.getString(R.string.author)

                Toast.makeText(applicationContext, "im", Toast.LENGTH_SHORT).show()

            }

            saveData.loadLang() == "ru" -> {
                val context = LocaleHelper.setLocale(this, "ru")
                val resources = context.resources

                setContentView(R.layout.setts)

                val messageView: TextView = findViewById(R.id.textView)
                val rb1: RadioButton = findViewById(R.id.light)
                val rb2: RadioButton = findViewById(R.id.dark)
                val rb3: RadioButton = findViewById(R.id.child)
                val men: TextView = findViewById(R.id.menu)
                val AV: TextView = findViewById(R.id.AV)

                messageView.text = resources.getString(R.string.textView)
                rb1.text = resources.getString(R.string.light)
                rb2.text = resources.getString(R.string.dark)
                rb3.text = resources.getString(R.string.child)
                men.text = resources.getString(R.string.menu)
                AV.text = resources.getString(R.string.author)

                Toast.makeText(applicationContext, "imru", Toast.LENGTH_SHORT).show()
            }
        }

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.setts)

        val inflatedView = getLayoutInflater().inflate(R.layout.activity_main, null);
        val cp: TextView = inflatedView.findViewById(R.id.copy);

        val buttonL: RadioButton = findViewById(R.id.light)
        val buttonD: RadioButton = findViewById(R.id.dark)
        val buttonC: RadioButton = findViewById(R.id.child)

        val lanru: RadioButton = findViewById(R.id.ru)
        val lanen: RadioButton = findViewById(R.id.en)
        val messageView: TextView = findViewById(R.id.textView)
        val rb1: RadioButton = findViewById(R.id.light)
        val rb2: RadioButton = findViewById(R.id.dark)
        val rb3: RadioButton = findViewById(R.id.child)
        //val cp: TextView = findViewById(R.id.copy)
        //val pas: TextView = findViewById(R.id.paste)
        //val sim: TextView = findViewById(R.id.mode)
        val men: TextView = findViewById(R.id.menu)

        buttonL.setOnClickListener {
            saveData.setDarkModeState("1")
            recreate()
        }
        buttonD.setOnClickListener {
            saveData.setDarkModeState("2")
            recreate()
        }
        buttonC.setOnClickListener {
            saveData.setDarkModeState("3")
            recreate()
        }

        lanru.setOnClickListener {
            saveData.setLang("ru")
            recreate()
            //val context = LocaleHelper.setLocale(this, "ru")
            //val resources = context.resources
            //messageView.text = resources.getString(R.string.textView)
          //  rb1.text = resources.getString(R.string.light)
           // rb2.text = resources.getString(R.string.dark)
           // pas.text = resources.getString(R.string.paste)
          //  cp.text = resources.getString(R.string.copy)
           // sim.text = resources.getString(R.string.science)
          //  rb3.text = resources.getString(R.string.child)
           // men.text = resources.getString(R.string.menu)


        }
        lanen.setOnClickListener {
            saveData.setLang("en")
            recreate()
            //val context = LocaleHelper.setLocale(this, "en")
            //val resources = context.resources
            //messageView.text = resources.getString(R.string.textView)
            //rb1.text = resources.getString(R.string.light)
            //rb2.text = resources.getString(R.string.dark)
            // pas.text = resources.getString(R.string.paste)
           // cp.text = resources.getString(R.string.copy)
            // sim.text = resources.getString(R.string.science)
           // rb3.text = resources.getString(R.string.child)
           // men.text = resources.getString(R.string.menu)

        }

    }
}


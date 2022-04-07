package ru.edu.masu.calculator

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private lateinit var saveData: SaveData

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        saveData=SaveData(this)
        when {
            saveData.loadDarkModeState()== "1" -> {
                setTheme(R.style.AppBaseTheme)

            }
            saveData.loadDarkModeState()== "2" -> {
                setTheme(R.style.AppThemeDark)
            }
            else -> setTheme(R.style.AppTheme)
        }
        setContentView(R.layout.activity_main)
        val cp: TextView = findViewById(R.id.copy);
        val pas: TextView = findViewById(R.id.paste);
        val sim: TextView = findViewById(R.id.mode);

        when {
            saveData.loadLang() == "en" -> {
                val context = LocaleHelper.setLocale(this, "en")
                val resources = context.resources



                pas.text = resources.getString(R.string.paste)
                cp.text = resources.getString(R.string.copy)
                sim.text = resources.getString(R.string.simple)

                when {(requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) -> {
                    //sim.text = resources.getString(R.string.simple)
                }
                    (requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) -> {
                        //sim.text = resources.getString(R.string.science)
                    }
                }

                Toast.makeText(applicationContext, "im", Toast.LENGTH_SHORT).show()

            }

            saveData.loadLang() == "ru" -> {
                val context = LocaleHelper.setLocale(this, "ru")
                val resources = context.resources


                pas.text = resources.getString(R.string.paste)
                cp.text = resources.getString(R.string.copy)
                sim.text = resources.getString(R.string.simple)

                when {(requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) -> {
                    //sim.text = resources.getString(R.string.simple)
                }
                    (requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) -> {
                        //sim.text = resources.getString(R.string.science)
                    }
                }

                Toast.makeText(applicationContext, "imru", Toast.LENGTH_SHORT).show()
            }
        }

        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())

        zer.setOnClickListener {setTextFields("0")}
        one.setOnClickListener {setTextFields("1")}
        two.setOnClickListener {setTextFields("2")}
        thr.setOnClickListener {setTextFields("3")}
        fou.setOnClickListener {setTextFields("4")}
        fiv.setOnClickListener {setTextFields("5")}
        six.setOnClickListener {setTextFields("6")}
        sev.setOnClickListener {setTextFields("7")}
        eig.setOnClickListener {setTextFields("8")}
        nin.setOnClickListener {setTextFields("9")}

        div.setOnClickListener {setTextFields("/")}
        mul.setOnClickListener {setTextFields("*")}
        plu.setOnClickListener {setTextFields("+")}
        min.setOnClickListener {setTextFields("-")}
        lef.setOnClickListener {setTextFields("(")}
        rig.setOnClickListener {setTextFields(")")}
        dot.setOnClickListener {setTextFields(".")}

        cle.setOnClickListener {
            action.text=""
            result.text=""
        }

        und.setOnClickListener {
            val str = action.text.toString()
            if(str.isNotEmpty())
                action.text = str.substring(0, str.length-1)
            result.text=""
        }

        equ.setOnClickListener {
            try {
                val ex = ExpressionBuilder(action.text.toString()).build()
                val whatwehave = ex.evaluate()

                val longRes = whatwehave.toLong()
                if(whatwehave==longRes.toDouble())
                    result.text=longRes.toString()
                else
                    result.text=whatwehave.toString()
            } catch(e:Exception) {
                Log.d("Ошибка", "${e.message}")
            }
        }

        abs.setOnClickListener {
            setTextFields("abs(")
        }
        pow.setOnClickListener {
            setTextFields("^")
        }
        sinn.setOnClickListener {
            setTextFields("sin(")
        }
        ln.setOnClickListener {
            setTextFields("log(")
        }
        log.setOnClickListener {
            setTextFields("log10(")
        }
        coss.setOnClickListener {
            setTextFields("cos(")
        }
        tan.setOnClickListener {
            setTextFields("tan(")
        }
        fac.setOnClickListener {
            val number = ((action.text.toString().toIntOrNull()))
            fun multiplyNumbers(number: Int): Long {
                return if (number >= 1)
                    number * multiplyNumbers(number - 1)
                else
                    1
            }
            result.text= number?.let { it1 -> multiplyNumbers(it1).toString() }
        }


        to8.setOnClickListener {
            val number = action.text
            if (number.isNotEmpty()) {
                val intt = number.toString()
                result.text=((intt.toIntOrNull())?.toString(8) ?: "")
            }

        }
        to7.setOnClickListener {
            val number = action.text
            if (number.isNotEmpty()) {
                val intt = number.toString()
                result.text=((intt.toIntOrNull())?.toString(7) ?: "")
            }
        }
        to6.setOnClickListener {
            val number = action.text
            if (number.isNotEmpty()) {
                val intt = number.toString()
                result.text=((intt.toIntOrNull())?.toString(6) ?: "")
            }
        }
        to5.setOnClickListener {
            val number = action.text
            if (number.isNotEmpty()) {
                val intt = number.toString()
                result.text=((intt.toIntOrNull())?.toString(5) ?: "")
            }
        }
        to4.setOnClickListener {
            val number = action.text
            if (number.isNotEmpty()) {
                val intt = number.toString()
                result.text=((intt.toIntOrNull())?.toString(4) ?: "")
            }
        }
        to3.setOnClickListener {
            val number = action.text
            if (number.isNotEmpty()) {
                val intt = number.toString()
                result.text=((intt.toIntOrNull())?.toString(3) ?: "")
            }
        }
        to2.setOnClickListener {
            val number = action.text
            if (number.isNotEmpty()) {
                val intt = number.toString()
                result.text=((intt.toIntOrNull())?.toString(2) ?: "")
            }
        }



        mode.setOnClickListener {
            val orientation = resources.configuration.orientation
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            } else {
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }

        }

        info.setOnClickListener{
            openSetts()
        }

        copy.setOnClickListener{
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText( "EditText", result.text.toString())
            //Edit text id
            clipboard.setPrimaryClip(clip)
        }


        paste.setOnClickListener {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?

                val abc = clipboard?.primaryClip
                val item = abc?.getItemAt(0)

                action.text = item?.text.toString()

        }




    }

    private fun setTextFields(str: String) {
        if(result.text != ""){
            action.text=result.text
            result.text=""
        }
        action.append(str)

    }



    private fun openSetts() {
        val intent = Intent(this, Setts::class.java)
        startActivity(intent)
    }
}
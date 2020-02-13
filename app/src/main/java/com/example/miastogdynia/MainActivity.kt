package com.example.miastogdynia

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lista = ""
    private var counter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun dodaj(v: View) {
        hideKeyboard(this)
        val rzeczDodanaPrzezUzytkownika: String = text_uzytkownika.text.toString()
        text_uzytkownika.text.clear()
        lista = lista.plus("$counter. $rzeczDodanaPrzezUzytkownika\n")

        counter++
        lista_atrakcji.visibility = View.VISIBLE
        lista_atrakcji.text = lista
    }

    private fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager =
            activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

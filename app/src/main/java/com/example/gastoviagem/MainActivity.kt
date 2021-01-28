package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

/**
 * Implement the interface View.OnClickListener.
 * alt + Enter at MainActivity to implement the interface methods.
 *
 * A MainActivity will behave in the same way as the OnClickListener interface,
 * so the onClick method was implemented.
 */

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this) //this se refere a MainActivity
    }

    /**
     * Button treatment function!
     *
     * Search which button will be pressed and what it should do.
     *
     */

    override fun onClick(view: View) {

        val id = view.id //procura qual id a função onClick irá receber

        if (id == R.id.buttonCalculate) {
            calculate()
        }

    }

    /**
     * Does the expense calculation "(distance * price)/ autonomy.
     *
     * If an error occurs, a Toast return with the notification.
     */

    private fun calculate() {

        if (validationOk()) {


            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy

                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}" //formata a string para um float com duas casas decimais

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG).show()
            }


        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG).show()
        }

    }

    /**
     * Validates whether fields are different from empty or with a zero value.
     */

    private fun validationOk(): Boolean {
        return (editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() != ""
                && editAutonomy.text.toString() != "0")


    }
}

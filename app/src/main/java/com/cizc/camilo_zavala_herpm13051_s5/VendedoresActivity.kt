package com.cizc.camilo_zavala_herpm13051_s5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cizc.camilo_zavala_herpm13051_s5.adapter.VendedorAdapter
import com.cizc.camilo_zavala_herpm13051_s5.adapter.Vendedor

class VendedoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendedores)

        // Lista de cinco vendedores como ejemplo
        val listaVendedores = listOf(
            Vendedor("Juan Perez",  R.drawable.imagen_predeterminada, "Área 1" , "1.500.000"),
            Vendedor("Andres Flores", R.drawable.imagen_predeterminada, "Área 2" , "2.800.000"),
            Vendedor("Gabriel Cepeda", R.drawable.imagen_predeterminada, "Área 3" , "1.500.000"),
            Vendedor("Ana Lopez", R.drawable.imagen_predeterminada, "Área 4" , "1.100.000"),
            Vendedor("Fernanda Arias", R.drawable.imagen_predeterminada, "Área 5" , "4.500.000")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewVendedores)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = VendedorAdapter(listaVendedores) { index ->
            if (index == 2) { // Si se selecciona el tercer vendedor (index 2)
                val intent = Intent(this, AudioActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

package com.cizc.camilo_zavala_herpm13051_s5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class GraphActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        val listaVendedores = listOf(
            Vendedor("Juan Perez", "Área 1", 1500000f),
            Vendedor("Andres Flores", "Área 2", 2800000f),
            Vendedor("Gabriel Cepeda", "Área 3", 1500000f),
            Vendedor("Ana Lopez", "Área 4", 1100000f),
            Vendedor("Fernanda Arias", "Área 5", 4500000f)
        )

        val barChart: BarChart = findViewById(R.id.barChart)
        val barEntries: ArrayList<BarEntry> = ArrayList()
        val xAxisLabels: ArrayList<String> = ArrayList()

        listaVendedores.forEachIndexed { index, vendedor ->
            barEntries.add(BarEntry(index.toFloat(), vendedor.ventas))
            xAxisLabels.add(vendedor.nombre)
        }

        val barDataSet = BarDataSet(barEntries, "Ventas")
        val dataSets: ArrayList<IBarDataSet> = ArrayList()
        dataSets.add(barDataSet)

        val barData = BarData(dataSets)
        barChart.data = barData

        // Configurar las etiquetas del eje X
        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
        barChart.xAxis.granularity = 1f
        barChart.xAxis.setCenterAxisLabels(true)

        barChart.invalidate()
    }
}

// Suponiendo que esta es la estructura de Vendedor
data class Vendedor(val nombre: String, val area: String, val ventas: Float)
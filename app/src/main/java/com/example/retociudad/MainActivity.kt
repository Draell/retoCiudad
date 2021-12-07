package com.example.retociudad

import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.retociudad.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

       // val boton = findViewById<Button>(R.id.btnGetLocation)
        binding.btnGetLocation.setOnClickListener{
            var ciudad:String = etCiudad.text.toString()
            var geo = Geocoder(this, Locale.getDefault())
            var direcciones = geo.getFromLocationName(ciudad,2)
            var address = direcciones.get(0)
            //var address:Address = direcciones.get(0)
            binding.tvCoordenadas.setText("${direcciones[0].latitude}.toString(), ${direcciones[0].longitude}")
        }
    }

}
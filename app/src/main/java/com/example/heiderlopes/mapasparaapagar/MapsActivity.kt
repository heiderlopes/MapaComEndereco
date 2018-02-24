package com.example.heiderlopes.mapasparaapagar

import android.location.Address
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.location.Geocoder



class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val coder = Geocoder(this)
        val address: List<Address>?

        try {
            address = coder.getFromLocationName("Avenida Lins de Vasconcelos, 1222", 1)
            val location = address[0]
            val lat = location.latitude
            val lng = location.longitude

            val fiap = LatLng(lat, lng)
            mMap.addMarker(MarkerOptions().position(fiap).title("FIAP - Aclimação"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(fiap))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(fiap.latitude, fiap.longitude), 16.0f))
        } catch (e: Exception) { }
    }
}

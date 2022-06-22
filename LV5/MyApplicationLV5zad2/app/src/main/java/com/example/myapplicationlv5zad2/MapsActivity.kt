package com.example.myapplicationlv5zad2

import android.content.Context
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.myapplicationlv5zad2.databinding.ActivityMapsBinding
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val locationPermission = android.Manifest.permission.ACCESS_FINE_LOCATION

    private val locationRequestCode = 10

    private lateinit var locationManager: LocationManager

    private val locationListener = object : LocationListener {
        override fun onProviderEnabled(provider: String) {
            //super.onProviderEnabled(provider)
        }

        override fun onProviderDisabled(provider: String) {
            //super.onProviderDisabled(provider)
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            //super.onStatusChanged(provider, status, extras)
        }

        override fun onLocationChanged(p0: Location) {
            updateLocationDisplay(p0)
        }
    }

//    private val locationListener = object:
//        LocationListener {
//        override fun onProviderEnabled(provider: String?) { }
//        override fun onProviderDisabled(provider: String?) { }
//        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) { }
//        override fun onLocationChanged(location: Location?) {
//            updateLocationDisplay(location)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        binding.btnScreenshot.setOnClickListener{  }
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        trackLocation()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }



    private fun updateLocationDisplay(location: Location?) {
        val lat = location?.latitude ?: 0.0
        val lon = location?.longitude ?: 0.0
        binding.tvGeoHeight.text = "Lat: $lat\nLon: $lon"

        mMap.clear()
        mMap.addMarker(MarkerOptions().position(LatLng(lat as Double, lon as Double)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(lat as Double, lon as Double)))
        
    }

    private fun trackLocation() {
        if(hasPermissionCompat(locationPermission))
        {
            startTrackingLocation()
        }
        else
        {
            requestPermisionCompat(arrayOf(locationPermission), locationRequestCode) }
        }
    override fun onRequestPermissionsResult( requestCode: Int,
                                             permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){ locationRequestCode -> {
            if(grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) trackLocation()
            else
                Toast.makeText(this, R.string.permissionNotGranted, Toast.LENGTH_SHORT).show()
        }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults) }
    }
    fun startTrackingLocation() { Log.d("TAG", "Tracking location")
        val criteria: Criteria = Criteria()
        criteria.accuracy = Criteria.ACCURACY_FINE
        val provider = locationManager.getBestProvider(criteria, true)
        val minTime = 1000L
        val minDistance = 10.0F
        try{
            provider?.let { locationManager.requestLocationUpdates(it, minTime, minDistance, locationListener) }
        } catch (e: SecurityException){
            Toast.makeText(this, R.string.permissionNotGranted, Toast.LENGTH_SHORT).show() }
    }
    override fun onPause() { super.onPause()
        locationManager.removeUpdates(locationListener) }
}
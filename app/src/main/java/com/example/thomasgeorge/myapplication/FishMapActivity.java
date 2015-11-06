package com.example.thomasgeorge.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FishMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        BitmapDescriptor customMapIcon = BitmapDescriptorFactory.fromAsset("fish_map_marker.png");

        LatLng ll_test0, ll_test1, ll_test2;
        ll_test0 = new LatLng(28,-82.850485);
        ll_test1 = new LatLng(27.82, -82.448);
        ll_test2 = new LatLng(27.372157,-82.590493);
        mMap.addMarker(new MarkerOptions().position(ll_test0).title("Gulf of Mexico").icon(customMapIcon));
        mMap.addMarker(new MarkerOptions().position(ll_test1).title("Tampa Bay").icon(customMapIcon));
        mMap.addMarker(new MarkerOptions().position(ll_test2).title("Sarasota Bay").icon(customMapIcon));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll_test1));
    }
}

package com.example.marija.myapplication;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by marija on 16.10.16.
 */
public class ReturnCallBack implements Callback<Mirko> {
    LatLng ll;

    public void success(Mirko model, Response response) {
        String city = model.getCity();
        Double latitude = model.getLatitude();
        Double longitude = model.getLongitude();
        LatLng ll = new LatLng(latitude,longitude);


    }

    @Override
    public void failure(RetrofitError error) {

    }

}

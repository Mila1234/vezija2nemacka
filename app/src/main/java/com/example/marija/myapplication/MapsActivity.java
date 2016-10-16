package com.example.marija.myapplication;

import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.multidex.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<LatLng> arrayLatLng = new ArrayList<>();
    private EditText textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        textView = (EditText) findViewById(R.id.textView);

// Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Button button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{

                    // CALL GetText method to make post method call
                    GetText();
                }
                catch(Exception ex)
                {
                    Toast.makeText(MapsActivity.this,"greska",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    // Create GetText Metod
    public  void  GetText()  throws UnsupportedEncodingException
    {
        // Get user defined values


        // Create data variable for sent values to server

        String data = URLEncoder.encode("/json/", "UTF-8")
                + "?q=" + URLEncoder.encode("37.201.171.130", "UTF-8");



        String text = "";
        BufferedReader reader=null;

        // Send data
        try
        {

            // Defined URL  where to send data
            URL url = new URL("https://freegeoip.net");

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        }
        catch(Exception ex)
        {

        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {}
        }

        // Show response on activity
        textView.setText( text  );

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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        LatLng belgrade = new LatLng(44.808748, 20.426625);
        mMap.addMarker(new MarkerOptions().position(belgrade).title("Marker in Belgrade"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(belgrade));


        String url = "https://freegeoip.net/";

        RestAdapter radapter=new RestAdapter.Builder().setEndpoint(url).build();

        MInterface restInt=radapter.create(MInterface.class);

        Callback callback = new Callback<Mirko>() {
            @Override
            public void success(Mirko model, Response response) {
                String city = model.getCity();
                Double latitude = model.getLatitude();
                Double longitude = model.getLongitude();
                LatLng ll = new LatLng(latitude,longitude);

               // mMap.addMarker(new MarkerOptions().position(ll).icon( BitmapDescriptorFactory.fromBitmap(  BitmapFactory.decodeResource( getResources(),                                R.mipmap.ic_launcher ))) .title("Marker icon"));

                mMap.addMarker(new MarkerOptions().position(ll).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("Marker icon"));

                mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        };


         restInt.getIP("37.201.171.130",callback);



       /* String url = "http://freegeoip.net";

       RestAdapter radapter=new RestAdapter.Builder().setEndpoint(url).build();

        MInterface restInt=radapter.create(MInterface.class);

        restInt.getUser(new Callback<Mirko>() {
                            @Override
                            public void success(Mirko model, Response response) {
                                String city = model.getCity();
                                Double latitude = model.getLatitude();
                                Double longitude = model.getLongitude();
                                LatLng ll = new LatLng(latitude,longitude);

                                mMap.addMarker(new MarkerOptions().position(ll).title("Marker from get"));
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
                            }

                            @Override
                            public void failure(RetrofitError error) {

                            }
                        }
        );*/






    }
}

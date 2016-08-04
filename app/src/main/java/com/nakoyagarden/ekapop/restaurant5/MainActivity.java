package com.nakoyagarden.ekapop.restaurant5;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    JsonParser jsonparser = new JsonParser();
    String ab;
    JSONObject jobj = null;
    JSONArray jarrA, jarrT;
    public RestaurantControl rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnCookV = (Button)findViewById(R.id.btnCookView);
        final  Button btnOrderA = (Button)findViewById(R.id.btnOrderAdd);
        rs = new RestaurantControl();

        btnCookV.setText("ห้องครัว");
        btnOrderA.setText("รับ Order");
        btnOrderA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s1 = new Intent(view.getContext(), OrderAddActivity.class);
                s1.putExtra("RestaurantControl",rs);
                startActivityForResult(s1, 0);
            }
        });
        btnCookV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url_delete_product="http://10.0.1.103:80/restaurant/testjson.php";
                //JSONObject json = jsonParser.makeHttpRequest(url_delete_product, "POST", params);
                new retrieveArea().execute();
                new retrieveTable().execute();

            }
        });
    }
    class retrieveArea extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... arg0) {
            //Log.d("Login attempt", jobj.toString());
            try {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                jarrA = jsonparser.getJSONFromUrl("http://172.25.4.62:80/restaurant/getArea.php",params);
                if(jarrA!=null){
                    rs.sCboArea.clear();
                    //JSONArray categories = jobj.getJSONArray("area");
                    //JSONArray json = new JSONArray(jobj);
                    for (int i = 0; i < jarrA.length(); i++) {
                        JSONObject catObj = (JSONObject) jarrA.get(i);
                        rs.sCboArea.add(catObj.getString("name"));
                    }
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return ab;
        }
        @Override
        protected void onPostExecute(String ab){

        }
        @Override
        protected void onPreExecute() {

        }
    }
    class retrieveTable extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... arg0) {
            //Log.d("Login attempt", jobj.toString());
            try {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                jarrT = jsonparser.getJSONFromUrl("http://172.25.4.62:80/restaurant/getTable.php",params);
                if(jarrT!=null){
                    //JSONArray categories = jobj.getJSONArray("area");
                    //JSONArray json = new JSONArray(jobj);
                    rs.sCboTable.clear();
                    for (int i = 0; i < jarrT.length(); i++) {
                        JSONObject catObj = (JSONObject) jarrT.get(i);
                        rs.sCboTable.add(catObj.getString("name"));
                    }
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return ab;
        }
        @Override
        protected void onPostExecute(String ab){

        }
        @Override
        protected void onPreExecute() {

        }
    }
}

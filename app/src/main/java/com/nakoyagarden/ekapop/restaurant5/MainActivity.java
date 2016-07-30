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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    JsonParser jsonparser = new JsonParser();
    String ab;
    JSONObject jobj = null;
    public RestaurantControl rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnCookV = (Button)findViewById(R.id.btnCookView);
        final  Button btnOrderA = (Button)findViewById(R.id.btnOrderAdd);
        //rs = new RestaurantControl();

        btnCookV.setText("ห้องครัว");
        btnOrderA.setText("รับ Order");
        btnOrderA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s1 = new Intent(view.getContext(), OrderAddActivity.class);
                startActivityForResult(s1, 0);
            }
        });
        btnCookV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url_delete_product="http://10.0.1.103:80/restaurant/testjson.php";
                //JSONObject json = jsonParser.makeHttpRequest(url_delete_product, "POST", params);
                new retrievedata1().execute();
            }
        });
    }
    class retrievedata1 extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... arg0) {
            // TODO Auto-generated method stub
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("foods_id", "333"));
            params.add(new BasicNameValuePair("foods_code", "444"));
            params.add(new BasicNameValuePair("foods_name", "555"));
            params.add(new BasicNameValuePair("remark", "666"));
            params.add(new BasicNameValuePair("foods_type_id", "777777"));
            jobj = jsonparser.getJSONFromUrl("http://10.0.1.103:80/restaurant/testjson.php", params);

            // check your log for json response
            Log.d("Login attempt", jobj.toString());

            try {
                ab = jobj.getString("key");
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return ab;
        }
        protected void onPostExecute(String ab){

            //tv.setText(ab);
        }
    }
}

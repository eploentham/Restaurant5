package com.nakoyagarden.ekapop.restaurant5;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.hrules.horizontalnumberpicker.HorizontalNumberPicker;
import com.hrules.horizontalnumberpicker.HorizontalNumberPickerListener;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderAddActivity extends AppCompatActivity implements HorizontalNumberPickerListener {
    Spinner cboTable, cboArea;
    TextView lbDate, lbMinced, lbFall, lbKoy, lbBoilZaa, lbThickSoup,lbPapazaSalad,lbGrillPorkNeck,lbWeepingTiger,lbGrillRibBeef,lbStickyRice,lbBambooShootSalad,lbBurnBeef;
    HorizontalNumberPicker txtQtyMinced,txtQtyFall,txtQtyKoy,txtQtyBoilZaa,txtQtyThickSoup,txtQtyPapazaSalad,txtQtyGrillPorkNeck,txtQtyWeepingTiger,txtQtyGrillRibBeef,txtQtyStickyRice,txtQtyBambooShootSalad,txtQtyBurnBeef;
    EditText txtRemarkMinced;
    RadioButton chkMincedPork, chkMincedBeef, chkMincedCatFish;
    RadioButton chkFallPork, chkFallBeef, chkFallBitter, chkFallSour;
    RadioButton chkKoy, chkKoyKoo, chkKoyBitter, chkKoySour;
    RadioButton chkBoilZaaBonePork, chkBoilZaaBeef, chkBoilZaaBitter, chkBoilZaaSour;
    RadioButton chkThickSoupPork, chkThickSoupBeef;
    RadioButton chkPapazaSaladThai,chkPapazaSaladCrab, chkPapazaSaladCrabPickledFish;
    Button btnSave;

    JsonParser jsonparser = new JsonParser();
    JSONObject jobj = null;
    String ab;

    public RestaurantControl rs;
    public ArrayList<String> sCboTable = new ArrayList<String>();
    public ArrayList<String> sCboArea = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Integer min=9;
        String txt="";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_add);
        cboTable = (Spinner)findViewById(R.id.cboTable);
        cboArea = (Spinner)findViewById(R.id.cboArea);

        lbDate = (TextView) findViewById(R.id.lbDate);
        lbMinced = (TextView) findViewById(R.id.lbMinced);
        lbFall = (TextView) findViewById(R.id.lbFall);
        lbKoy = (TextView) findViewById(R.id.lbKoy);
        lbBoilZaa = (TextView) findViewById(R.id.lbBoilZaa);
        lbThickSoup = (TextView) findViewById(R.id.lbThickSoup);
        lbPapazaSalad = (TextView) findViewById(R.id.lbPapazaSalad);
        lbGrillPorkNeck = (TextView) findViewById(R.id.lbGrillPorkNeck);
        lbWeepingTiger = (TextView) findViewById(R.id.lbWeepingTiger);
        lbGrillRibBeef = (TextView) findViewById(R.id.lbGrillRibBeef);
        lbStickyRice = (TextView) findViewById(R.id.lbStickyRice);
        lbBambooShootSalad = (TextView) findViewById(R.id.lbBambooShootSalad);
        lbBurnBeef = (TextView) findViewById(R.id.lbBurnBeef);
        txtRemarkMinced = (EditText) findViewById(R.id.txtRemarkMinced);
        btnSave = (Button) findViewById(R.id.btnSave);

        txtQtyMinced = (HorizontalNumberPicker) findViewById(R.id.txtQtyMinced);
        txtQtyMinced.setMaxValue(min);
        txtQtyMinced.setMinValue(0);
        //txtQtyMinced.getButtonMinusView().set
        txtQtyMinced.setListener(this);

        txtQtyFall = (HorizontalNumberPicker) findViewById(R.id.txtQtyFall);
        txtQtyFall.setMaxValue(min);
        txtQtyFall.setMinValue(0);
        txtQtyKoy = (HorizontalNumberPicker) findViewById(R.id.txtQtyKoy);
        txtQtyKoy.setMaxValue(min);
        txtQtyKoy.setMinValue(0);
        txtQtyBoilZaa = (HorizontalNumberPicker) findViewById(R.id.txtQtyBoilZaa);
        txtQtyBoilZaa.setMaxValue(min);
        txtQtyBoilZaa.setMinValue(0);
        txtQtyThickSoup = (HorizontalNumberPicker) findViewById(R.id.txtQtyThickSoup);
        txtQtyThickSoup.setMaxValue(min);
        txtQtyThickSoup.setMinValue(0);
        txtQtyPapazaSalad = (HorizontalNumberPicker) findViewById(R.id.txtQtyPapazaSalad);
        txtQtyPapazaSalad.setMaxValue(min);
        txtQtyPapazaSalad.setMinValue(0);
        txtQtyGrillPorkNeck = (HorizontalNumberPicker) findViewById(R.id.txtQtyGrillPorkNeck);
        txtQtyGrillPorkNeck.setMaxValue(min);
        txtQtyGrillPorkNeck.setMinValue(0);
        txtQtyWeepingTiger = (HorizontalNumberPicker) findViewById(R.id.txtQtyWeepingTiger);
        txtQtyWeepingTiger.setMaxValue(min);
        txtQtyWeepingTiger.setMinValue(0);
        txtQtyGrillRibBeef = (HorizontalNumberPicker) findViewById(R.id.txtQtyGrillRibBeef);
        txtQtyGrillRibBeef.setMaxValue(min);
        txtQtyGrillRibBeef.setMinValue(0);
        txtQtyStickyRice = (HorizontalNumberPicker) findViewById(R.id.txtQtyStickyRice);
        txtQtyStickyRice.setMaxValue(min);
        txtQtyStickyRice.setMinValue(0);
        txtQtyStickyRice = (HorizontalNumberPicker) findViewById(R.id.txtQtyStickyRice);
        txtQtyStickyRice.setMaxValue(min);
        txtQtyStickyRice.setMinValue(0);
        txtQtyBambooShootSalad = (HorizontalNumberPicker) findViewById(R.id.txtQtyBambooShootSalad);
        txtQtyBambooShootSalad.setMaxValue(min);
        txtQtyBambooShootSalad.setMinValue(0);
        txtQtyBurnBeef = (HorizontalNumberPicker) findViewById(R.id.txtQtyBurnBeef);
        txtQtyBurnBeef.setMaxValue(min);
        txtQtyBurnBeef.setMinValue(0);

        chkMincedPork = (RadioButton)findViewById(R.id.chkMincedPork);
        chkMincedBeef = (RadioButton)findViewById(R.id.chkMincedBeef);
        chkMincedCatFish = (RadioButton)findViewById(R.id.chkMincedCatFish);

        chkFallPork = (RadioButton)findViewById(R.id.chkFallPork);
        chkFallBeef = (RadioButton)findViewById(R.id.chkFallBeef);
        chkFallBitter = (RadioButton)findViewById(R.id.chkFallBitter);
        chkFallSour = (RadioButton)findViewById(R.id.chkFallSour);

        chkKoy = (RadioButton)findViewById(R.id.chkKoy);
        chkKoyKoo = (RadioButton)findViewById(R.id.chkKoyKoo);
        chkKoyBitter = (RadioButton)findViewById(R.id.chkKoyBitter);
        chkKoySour = (RadioButton)findViewById(R.id.chkKoySour);

        chkBoilZaaBonePork = (RadioButton)findViewById(R.id.chkBoilZaaBonePork);
        chkBoilZaaBeef = (RadioButton)findViewById(R.id.chkBoilZaaBeef);
        chkBoilZaaBitter = (RadioButton)findViewById(R.id.chkBoilZaaBitter);
        chkBoilZaaSour = (RadioButton)findViewById(R.id.chkBoilZaaSour);

        chkThickSoupPork = (RadioButton)findViewById(R.id.chkThickSoupPork);
        chkThickSoupBeef = (RadioButton)findViewById(R.id.chkThickSoupBeef);

        chkPapazaSaladThai = (RadioButton)findViewById(R.id.chkPapazaSaladThai);
        chkPapazaSaladCrab = (RadioButton)findViewById(R.id.chkPapazaSaladCrab);
        chkPapazaSaladCrabPickledFish = (RadioButton)findViewById(R.id.chkPapazaSaladCrabPickledFish);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String currentDateandTime = sdf .format(new Date());
        lbDate.setText(currentDateandTime);
        lbMinced.setText(R.string.minced);
        lbFall.setText(R.string.fall);
        lbKoy.setText(R.string.koy);
        //txt = R.string.boil+" "+R.string.zaa;
        lbBoilZaa.setText(getResources().getString(R.string.boil)+getResources().getString(R.string.zaa));
        lbThickSoup.setText(R.string.thicksoup);
        lbPapazaSalad.setText(R.string.papaya_salad);
        lbGrillPorkNeck.setText(getResources().getString(R.string.neck)+getResources().getString(R.string.pork)+getResources().getString(R.string.gril));
        lbWeepingTiger.setText(R.string.weepingtiger);
        lbGrillRibBeef.setText(getResources().getString(R.string.rib)+getResources().getString(R.string.beef)+getResources().getString(R.string.gril));
        lbStickyRice.setText(R.string.stickyrice);
        lbBambooShootSalad.setText(R.string.bamboo_shoot_salad);
        lbBurnBeef.setText(getResources().getString(R.string.beef)+getResources().getString(R.string.burn));

        chkMincedPork.setText(R.string.pork);
        chkMincedBeef.setText(R.string.beef);
        chkMincedCatFish.setText(R.string.catfish);

        chkFallPork.setText(R.string.pork);
        chkFallBeef.setText(R.string.beef);
        chkFallBitter.setText(R.string.bitter);
        chkFallSour.setText(R.string.sour);

        chkKoy.setText(R.string.koy);
        chkKoyKoo.setText(R.string.koo);
        chkKoyBitter.setText(R.string.bitter);
        chkKoySour.setText(R.string.sour);

        //txt = R.string.bone+" "+R.string.pork;
        chkBoilZaaBonePork.setText(getResources().getString(R.string.bone)+getResources().getString(R.string.pork));
        chkBoilZaaBeef.setText(R.string.beef);
        chkBoilZaaBitter.setText(R.string.bitter);
        chkBoilZaaSour.setText(R.string.sour);

        chkThickSoupPork.setText(getResources().getString(R.string.thicksoup)+getResources().getString(R.string.pork));
        chkThickSoupBeef.setText(getResources().getString(R.string.thicksoup)+getResources().getString(R.string.beef));

        chkPapazaSaladThai.setText(getResources().getString(R.string.thai));
        chkPapazaSaladCrab.setText(getResources().getString(R.string.crab));
        chkPapazaSaladCrabPickledFish.setText(getResources().getString(R.string.crab)+getResources().getString(R.string.pickledfish));

        btnSave.setText(R.string.save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtQtyMinced.getValue();
                saveOrder();
            }
        });

        //setCboTable();
        rs = new RestaurantControl();
        ArrayAdapter<String> adaTable = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,rs.sCboTable);
        ArrayAdapter<String> adaArea = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,rs.sCboArea);
        cboTable.setAdapter(adaTable);
        cboArea.setAdapter(adaArea);
    }
    private void saveOrder(){
        String urlOrder="http://10.0.1.103:80/restaurant/testjson.php";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        String uniqueID = UUID.randomUUID().toString();
        params.add(new BasicNameValuePair("order_id", uniqueID));
        params.add(new BasicNameValuePair("foods_code", "100"));
        params.add(new BasicNameValuePair("foods_name", "555"));
        params.add(new BasicNameValuePair("remark", "666"));
        params.add(new BasicNameValuePair("qty", String.valueOf(txtQtyMinced.getValue())));
        jobj = jsonparser.getJSONFromUrl("http://10.0.1.103:80/restaurant/saveTOrder.php", params);

        // check your log for json response
        Log.d("Login attempt", jobj.toString());

        try {
            ab = jobj.getString("key");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onHorizontalNumberPickerChanged(HorizontalNumberPicker horizontalNumberPicker, int value) {
        switch (horizontalNumberPicker.getId()) {
            case R.id.txtQtyMinced:
                txtRemarkMinced.setText(String.valueOf(value));
                break;

            case R.id.txtQtyFall:
                //DebugLog.d("horizontal_number_picker2 current value: " + value);
                break;

            case R.id.txtQtyKoy:
                //DebugLog.d("horizontal_number_picker3 current value: " + value);
                break;
        }
    }
}

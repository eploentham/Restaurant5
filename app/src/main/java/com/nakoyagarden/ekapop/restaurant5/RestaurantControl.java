package com.nakoyagarden.ekapop.restaurant5;

import android.app.Application;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ekapop on 26/7/2559.
 */
public class RestaurantControl extends Application implements Serializable {
    public ArrayList<String> sCboTable = new ArrayList<String>();
    public ArrayList<String> sCboArea = new ArrayList<String>();
    public ArrayList<String> sCboRes = new ArrayList<String>();
    public RestaurantControl(){
        setCboTable();
    }
    private void setCboTable(){
        //sCboTable.add("โต๊ะ 1");
        //sCboTable.add("โต๊ะ 2");
        //sCboTable.add("โต๊ะ 3");
        //sCboTable.add("โต๊ะ 4");
        //sCboTable.add("โต๊ะ 5");
        //sCboTable.add("โต๊ะ 6");
        //sCboTable.add("โต๊ะ 7");
        //sCboTable.add("โต๊ะ 8");
        //sCboTable.add("โต๊ะ 9");
        //sCboTable.add("โต๊ะ 10");
        //sCboTable.add("โต๊ะ 11");

        //sCboArea.add("ในร้าน");
        //sCboArea.add("ฟุตบาท");
        //sCboArea.add("ในสวน");
    }
}

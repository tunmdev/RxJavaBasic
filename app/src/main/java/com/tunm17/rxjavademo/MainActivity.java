package com.tunm17.rxjavademo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tunm17.rxjavademo.operators.CollectionOperators;
import com.tunm17.rxjavademo.operators.FilterOperatorsDemo;
import com.tunm17.rxjavademo.operators.TransformingOperatorsDemo;
import com.tunm17.rxjavademo.operators.UtilityOperators;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ObservableDemo.runEx1();

        UtilityOperators.runObserveOn();

//        SingleDemo.run();

//        TransformingOperatorsDemo.runMap();
    }
}
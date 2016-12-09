package com.looking.custommenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.looking.custommenu.ui.CustomMenuView;

public class MainActivity extends AppCompatActivity {

    private CustomMenuView menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuView = (CustomMenuView) findViewById(R.id.menu_view);
        initMenuData();
    }

    private void initMenuData() {
        menuView.addItem(R.mipmap.ic_launcher, View.GONE, "first", "", "", "item1")//
                .addItem("title", "", "", "item2")//
                .addItem("", "", "", "item3")//
                .addDivider(true)//
                .addItem(View.GONE, "title", "hello", "", "item4")//
                .addItem("title", Color.GREEN, "heoeo", "item5")//
                .addItem("textsize", "heoeo", 24f, "item6").build();


    }
}

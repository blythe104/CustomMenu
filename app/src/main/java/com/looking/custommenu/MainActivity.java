package com.looking.custommenu;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.looking.custommenu.ui.CustomMenuView;
import com.looking.custommenu.ui.ItemDataBean;


public class MainActivity extends AppCompatActivity {

    private CustomMenuView menuView;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    menuView.updateTitle("item0", "updateTitle");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuView = (CustomMenuView) findViewById(R.id.menu_view);
        initMenuData();
    }

    private void initMenuData() {

        menuView.addItem("first", "", "item0")//
                .addItem("first", "desc", "item1")//
                .addItem("second", View.VISIBLE, "item2")//
                .addItem("third", "desc", View.VISIBLE, "item3")//
                .addItem(R.mipmap.ic_launcher, "four", View.GONE, "item4")//
                .addItem(R.mipmap.ic_launcher, "five", View.VISIBLE, "item5")//
                .addItem(R.mipmap.ic_launcher, "six", "six_desc", View.VISIBLE, "item6")//
                .addItem(R.mipmap.ic_launcher, "six", R.mipmap.ic_launcher, "six_desc", View.VISIBLE, "item7")//
                .addItem("seven", Color.BLUE, "seven", "item8")//
                .addItem("enight", Color.RED, 19, "enight", "item9")//
                .build();

        menuView.setOnMenuListener(new CustomMenuView.OnMenuListener() {
            @Override
            public void onClickItem(ItemDataBean data) {
                switch (data.flag) {
                    case "item1":
                        Toast.makeText(MainActivity.this, "hello this is item1", Toast.LENGTH_SHORT).show();
                        break;
                    case "item4":
                        Toast.makeText(MainActivity.this, "this is item4", Toast.LENGTH_SHORT).show();
                        Message msg = handler.obtainMessage();
                        msg.what = 1;
                        handler.sendMessageDelayed(msg, 1000);
                        break;
                    case "item9":
                        Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }


}

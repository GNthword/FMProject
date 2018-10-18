package com.milog.fm.fmproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        tvShow = findViewById(R.id.tv_show);

        MyBean bean = new MyBean();
        tvShow.setText(bean.toString());
    }
}

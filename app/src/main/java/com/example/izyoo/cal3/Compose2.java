package com.example.izyoo.cal3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Compose2 extends AppCompatActivity {
    TextView tv, tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose2);

        tv = (TextView) findViewById(R.id.textView2);
        tv1 = (TextView) findViewById(R.id.textView3);
        tv2 = (TextView) findViewById(R.id.textView6);

        tv.setText("" +getIntent().getStringExtra("Name"));
        tv1.setText("Name");
        tv2.setText(""+getIntent().getStringExtra("Description"));
//

    }
}

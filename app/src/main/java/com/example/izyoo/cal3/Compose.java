package com.example.izyoo.cal3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Compose extends AppCompatActivity {


    String description = "Android Development Tutorial";
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        editText = (EditText) findViewById(R.id.editText);

        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namevalue = editText.getText().toString();
                Intent intent = new Intent(Compose.this, Compose2.class);
                intent.putExtra("Name", namevalue);
                intent.putExtra("Description", description);
                startActivity(intent);
            }
        });

    }
}

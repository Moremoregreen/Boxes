package com.moremoregreen.boxes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.moremoregreen.boxes.Box.Box1;
import com.moremoregreen.boxes.Box.Box2;
import com.moremoregreen.boxes.Box.Box3;
import com.moremoregreen.boxes.Box.Box4;
import com.moremoregreen.boxes.Box.Box5;

public class MainActivity extends AppCompatActivity {

    private EditText edLength;
    private EditText edWidth;
    private EditText edHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edLength = findViewById(R.id.length);
        edWidth = findViewById(R.id.width);
        edHeight = findViewById(R.id.height);

    }

    public void check(View view) {
        float length = Float.parseFloat(edLength.getText().toString());
        float width = Float.parseFloat(edWidth.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        int price = 999999999;
        Intent toShowBox = new Intent(this, BoxActivity.class);

        if (new Box5().validate(length, width, height)) {
            toShowBox.putExtra("BOX", Box5.TYPE_5);
        } else if (new Box1().validate(length, width, height)) {
            toShowBox.putExtra("BOX", Box1.TYPE_1);
        } else if (new Box2().validate(length, width, height)) {
            toShowBox.putExtra("BOX", Box1.TYPE_2);
        } else if (new Box4().validate(length, width, height)) {
            toShowBox.putExtra("BOX", Box1.TYPE_4);
        } else if (new Box3().validate(length, width, height)) {
            toShowBox.putExtra("BOX", Box1.TYPE_3);
        }else {
            toShowBox.putExtra("BOX", Box1.TYPE_NULL);
        }
        startActivity(toShowBox);
    }

}

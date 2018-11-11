package com.moremoregreen.boxes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.moremoregreen.boxes.Box.Box;
import com.moremoregreen.boxes.Box.Box1;
import com.moremoregreen.boxes.Box.Box2;
import com.moremoregreen.boxes.Box.Box3;
import com.moremoregreen.boxes.Box.Box4;
import com.moremoregreen.boxes.Box.Box5;

public class BoxActivity extends AppCompatActivity {

    private TextView tvBoxType, tvBoxSize, tvBoxPrice;
    private Button btnBoxToMain;
    private ImageView ivBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);
        findViews();
        int type = getIntent().getIntExtra("BOX", Box.TYPE_1);
        Box box = null;
        switch (type) {
            case Box.TYPE_1:
                box = new Box1();
                setResult(box);
                break;
            case Box.TYPE_2:
                box = new Box2();
                setResult(box);
                break;
            case Box.TYPE_3:
                box = new Box3();
                setResult(box);
                break;
            case Box.TYPE_4:
                box = new Box4();
                setResult(box);
                break;
            case Box.TYPE_5:
                box = new Box5();
                setResult(box);
                break;
            case Box.TYPE_NULL:
                tvBoxType.setText("該尺寸並無符合之便利箱");
                ivBox.setVisibility(View.GONE);
                break;
        }

    }

    private void setResult(Box box) {
        tvBoxType.setText(box.getName());
        ivBox.setImageResource(box.getImage());
        tvBoxSize.setText(box.getLength() + "/" + box.getWidth() + "/" + box.getHeight());
        tvBoxPrice.setText(box.getPrice()+"");
    }

    private void findViews() {
        tvBoxType = findViewById(R.id.tvBox);
        tvBoxSize = findViewById(R.id.tvBoxSize);
        tvBoxPrice = findViewById(R.id.tvBoxPrice);
        btnBoxToMain = findViewById(R.id.btnBoxToMain);
        ivBox = findViewById(R.id.ivBox);
    }

    public void backToMain(View view) {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);

    }
}

package com.prototype.joint.findmyseat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class clickonroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickonroom);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView iv = (ImageView) findViewById(R.id.imageView3);
                iv.setVisibility(View.VISIBLE);
                //make opacity 40%
                ImageView img = (ImageView) findViewById(R.id.imageView);
                img.setAlpha(0.4f);
                //highlight room
//                Button button3 =(Button) findViewById(R.id.button3);
//                button3.
                moveToNextScreen();
            }
        });
    }

    public void moveToNextScreen() {
        startActivity(new Intent(clickonroom.this, MainActivity.class));
        clickonroom.this.finish();

    }
}
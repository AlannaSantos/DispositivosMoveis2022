package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editUrl;
    private ImageButton bt_submit;
    private ImageView img_result;
    private ProgressBar pgbProgresso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl = findViewById(R.id.edit_url);
        bt_submit = findViewById(R.id.bt_submit);
        img_result = findViewById(R.id.img_result);
        pgbProgresso = findViewById(R.id.pgbProgresso);

        bt_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String urlLink  = editUrl.getText().toString();
        if (urlLink.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Informe a url!",
                    Toast.LENGTH_SHORT).show();
        } else {
            pgbProgresso.setVisibility(View.VISIBLE);
            carregar();
        }
    }

    public void carregar(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String urlLink  = editUrl.getText().toString();
                        pgbProgresso.setVisibility(View.INVISIBLE);
                        LoadImage loadImage = new LoadImage(img_result);
                        loadImage.execute(urlLink);
                    }
                });
            }
        }).start();
    }
}
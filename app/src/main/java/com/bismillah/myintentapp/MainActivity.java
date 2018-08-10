package com.bismillah.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity;
    private Button btnMoveWithDataActivity;
    private Button btnDialPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button) findViewById(R.id.btnMoveActivity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity = (Button) findViewById(R.id.btnMoveData);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnDialPhone = (Button) findViewById(R.id.btnDialNumber);
        btnDialPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMoveActivity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btnMoveData:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_ALAMAT, "Cirebon Jawa Barat");
                startActivity(moveWithDataIntent);
                break;
            case R.id.btnDialNumber:
                String phoneNumber = "081220902177";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}

package com.abc.app.hiapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText et_id, et_pw;
    Button bt_login, bt_join;
    MemberService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = new MemberServiceImpl(this.getApplicationContext());
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_join:
                startActivity(new Intent(this, JoinActivity.class));

                break;
            case R.id.bt_login:
                Toast.makeText(MainActivity.this,
                        "ID:" + et_id.getText().toString()
                                + "PW:" + et_pw.getText().toString(),
                        Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,HomeActivity.class));

                break;



        }
    }


}

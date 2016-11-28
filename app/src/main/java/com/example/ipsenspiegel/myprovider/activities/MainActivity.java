package com.example.ipsenspiegel.myprovider.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ipsenspiegel.myprovider.R;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnQueryDb = (Button) findViewById(R.id.btn_query_db);
        btnQueryDb.setOnClickListener(this);
        final Button btnAddDb = (Button)findViewById(R.id.btn_add_db);
        btnQueryDb.setOnClickListener(this);
        final Button btnDeleteDb = (Button)findViewById(R.id.btn_delete_db);
        btnQueryDb.setOnClickListener(this);

    }

    @Override
    public void onClick(View whichView) {

        if (whichView.getId()== R.id.btn_query_db){

        }else if (whichView.getId()== R.id.btn_add_db){

        }else if (whichView.getId()== R.id.btn_delete_db){

        }

    }
}

package com.example.ipsenspiegel.myprovider.activities;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ipsenspiegel.myprovider.R;
import com.example.ipsenspiegel.myprovider.data.MyContentProvider;
import com.example.ipsenspiegel.myprovider.data.MyDatabaseHelper;
import com.example.ipsenspiegel.myprovider.data.paramsDb;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText edtName;
    private EditText edtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.edtName = (EditText) findViewById(R.id.et_name);
        this.edtAge = (EditText) findViewById(R.id.et_age);

        final Button btnQueryDb = (Button) findViewById(R.id.btn_query_db);
        btnQueryDb.setOnClickListener(this);
        final Button btnAddDb = (Button) findViewById(R.id.btn_add_db);
        btnQueryDb.setOnClickListener(this);
        final Button btnDeleteDb = (Button) findViewById(R.id.btn_delete_db);
        btnQueryDb.setOnClickListener(this);

    }

    @Override
    public void onClick(View whichView) {

        if (whichView.getId() == R.id.btn_query_db) {

        } else if (whichView.getId() == R.id.btn_add_db) {

            ContentValues insertValues = new ContentValues();
            insertValues.put(paramsDb.STUDENT_NAME, this.edtName.getText().toString());
            insertValues.put(paramsDb.STUDENT_AGE, this.edtAge.getText().toString());
            //como usamos nuestro content provider?
            Uri insertUri = getContentResolver().insert(MyContentProvider.CONTEXT_URI, insertValues);

        } else if (whichView.getId() == R.id.btn_delete_db) {


        } else {

        }
    }
}

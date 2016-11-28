package com.example.ipsenspiegel.myprovider.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        btnAddDb.setOnClickListener(this);
        final Button btnDeleteDb = (Button) findViewById(R.id.btn_delete_db);
        btnDeleteDb.setOnClickListener(this);

    }

    @Override
    public void onClick(View whichView) {

        ContentValues insertValues = new ContentValues();
        insertValues.put(paramsDb.STUDENT_NAME, this.edtName.getText().toString());
        insertValues.put(paramsDb.STUDENT_AGE, this.edtAge.getText().toString());

        if (whichView.getId() == R.id.btn_query_db) {

            Cursor queryCursor = getContentResolver().query(MyContentProvider.CONTEXT_URI, null, null, null, null);

            StringBuilder dbContent = new StringBuilder("");

            //como el foreach

            while (queryCursor.moveToNext()) {
                dbContent.append("\n"
                        + queryCursor.getInt(queryCursor.getColumnIndex(paramsDb._ID))
                        + " " + queryCursor.getString(queryCursor.getColumnIndex(paramsDb.STUDENT_NAME))
                        + " " + queryCursor.getInt(queryCursor.getColumnIndex(paramsDb.STUDENT_AGE))
                        + "\n");

            }

            queryCursor.close();
            Toast.makeText(this, dbContent.toString(), Toast.LENGTH_LONG).show();

        } else if (whichView.getId() == R.id.btn_add_db) {

            Uri insertUri = getContentResolver().insert(MyContentProvider.CONTEXT_URI, insertValues);

        } else if (whichView.getId() == R.id.btn_delete_db) {
        // =? igual al mismo elemento en posicion
            String whereCond = paramsDb.STUDENT_NAME + "=? AND " + paramsDb.STUDENT_AGE + "=?";
            String [] whereCondArgs = {this.edtName.getText().toString(), this.edtAge.getText().toString()};

            int deletedRows = this.getContentResolver().delete(MyContentProvider.CONTEXT_URI, whereCond, whereCondArgs);

            // Clean the 'EditText' to improve UX
            this.edtName.setText("");
            this.edtAge.setText("");

            Toast.makeText(this, "Deleted rows: " + String.valueOf(deletedRows), Toast.LENGTH_SHORT).show();


        } else {
        }
    }
}

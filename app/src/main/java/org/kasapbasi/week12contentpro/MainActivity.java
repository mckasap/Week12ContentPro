package org.kasapbasi.week12contentpro;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void theClick(View v){
        // Retrieve student records
        String URL = "content://org.kasapbasi.mycontentprovider.StudentsProvider";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(0) +
                                ", " +  c.getString(1) +
                                ", " + c.getString(2),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
        Toast.makeText(this, "onClickRetrive Button Pressed", Toast.LENGTH_LONG).show();
    }


}
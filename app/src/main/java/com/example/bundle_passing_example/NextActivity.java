package com.example.bundle_passing_example;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_next);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtStuInfo;
        txtStuInfo = findViewById(R.id.txtStuInfo);

        // we can also get/fetch the data on the run time of application through the getIntent() method
        Intent fromAct = getIntent(); // this method get the Intent from any Activity

        String title = fromAct.getStringExtra("title");
        String stuName = fromAct.getStringExtra("StudentName");
        int rollNo = fromAct.getIntExtra("RollNo",0);

        txtStuInfo.setText("Roll No : "+rollNo+"\nName : "+stuName);

        // we can set the title bar name on the run time by the below method
        getSupportActionBar().setTitle(title);
    }
}
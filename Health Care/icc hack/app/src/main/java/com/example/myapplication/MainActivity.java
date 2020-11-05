package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Bitmap bitmap;
    Button buttoncamera,submitButton;
    ImageView imageView;
    EditText editText1,editText2,editText3;


    public  static final int CAMERA_REQUEST=9999;
    @Override

    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
            bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            //pass(bitmap);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttoncamera=findViewById(R.id.takepicture);
        imageView=(ImageView) findViewById(R.id.imageView);
        submitButton=findViewById(R.id.getdetails);
        editText1=findViewById(R.id.patientname);
        editText2=findViewById(R.id.patientdis);
        editText3=findViewById(R.id.location);

        buttoncamera = findViewById(R.id.takepicture);
        imageView = (ImageView) findViewById(R.id.imageView);
        submitButton = findViewById(R.id.getdetails);
        editText1 = findViewById(R.id.patientname);
        editText2 = findViewById(R.id.patientdis);
        editText3 = findViewById(R.id.location);


        buttoncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                intent1.putExtra("accidentImage", bitmap);
                intent1.putExtra("Location", editText3.getText().toString());
                intent1.putExtra("discription", editText2.getText().toString());
                intent1.putExtra("patientName", editText1.getText().toString());
                startActivity(intent1);
            }
        });
    }

}

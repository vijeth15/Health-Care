package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    WebView webView;
    Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        final String place=getIntent().getStringExtra("Location").toString();
        button=findViewById(R.id.button);
        webView=findViewById(R.id.webview);
        button2=findViewById(R.id.button2);
        Log.d("place is ","place value ois "+place);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //webView.loadUrl("https://www.google.com/maps/search/?api=1&query=hospital");
                webView.loadUrl("https://www.google.com/maps/search/?api=1&query=hospital+"+place);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webView.getSettings().setAppCacheEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webSettings.setDomStorageEnabled(true);
                webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                webSettings.setUseWideViewPort(true);
                webSettings.setSavePassword(true);
                webSettings.setSaveFormData(true);
                webSettings.setEnableSmoothTransition(true);


             //l1   Uri uri=Uri.parse("geo:0,0?q=Hospital");

//        /* 1 */        Uri uri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Hospital&travelmode=driving");
//                Uri uri=Uri.parse("https://www.google.com/maps/search/?api=1&query=hospital+"+place);

//                Uri uri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Hospital&travelmode=driving");
              //2  Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                //3intent.setPackage("com.google.android.apps.maps");
                //4startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent5);
            }
        });



    }




}


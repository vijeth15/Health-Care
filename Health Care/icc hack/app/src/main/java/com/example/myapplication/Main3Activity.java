package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    WebView webView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        webView=findViewById(R.id.webView11);
        button=findViewById(R.id.button3);
        webView.loadUrl("https://www.google.com/maps/dir/?api=1&destination=Hospital&travelmode=driving");
//        Uri uri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Hospital&travelmode=driving");
//        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
//        intent.setPackage("com.google.android.apps.maps");
//        startActivity(intent);
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent01=new Intent(Main3Activity.this,Main4Activity.class);
                //startActivity(intent01);
                Uri uri=Uri.parse("smsto:"+"9110400647");

                Intent i=new Intent(Intent.ACTION_SENDTO,uri);

                i.setPackage("com.whatsapp");
                i.putExtra(Intent.EXTRA_TEXT, "The text you wanted to share");
                startActivity(i);
            }
        });

    }
}

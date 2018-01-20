package com.android.lab.mylightbrowser.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

import com.android.lab.mylightbrowser.R;
import com.android.lab.mylightbrowser.utility.CustomWebViewClient;

/**
 * Created by USER on 20/1/18.
 */

public class BrowserActivity extends AppCompatActivity {

    private WebView myWebView;
    private EditText editText;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myWebView = (WebView) findViewById(R.id.activity_main_webview);
        editText = (EditText) findViewById(R.id.editText);



        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://www.google.com");
//        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new CustomWebViewClient());


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    myWebView.loadUrl(editText.getText().toString());
                    handled = true;
                }
                return handled;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
package com.prostofm.app;

/**
 * Created by timonsk on 14.05.14.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings.ZoomDensity;

public class PageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        AssetManager mgr = getAssets();
        try {
            InputStream in = mgr.open("text.txt", AssetManager.ACCESS_BUFFER);

            String sHTML = streamToString(in);
            in.close();

            WebView w = (WebView) findViewById(R.id.webView);
            w.getSettings().setDefaultZoom(ZoomDensity.MEDIUM);
            w.loadDataWithBaseURL("file:///android_asset/", sHTML, "text/html",
                    "utf-8", null);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String streamToString(InputStream in) throws IOException {
        if (in == null) {
            return "";
        }

        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(in,
                    "UTF-8"));

            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

        } finally {

        }

        return writer.toString();
    }

}


package com.streampakistan.allsports;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    private WebView webView;
    private ProgressBar progress;

    private static final String APP_URL =
        "https://stream-pakistan-api.azalikhan83.workers.dev/live";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.rgb(5, 13, 30));
        getWindow().setNavigationBarColor(Color.rgb(5, 13, 30));

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.rgb(5, 13, 30));

        TextView header = new TextView(this);
        header.setText("▶ STREAM PAKISTAN ALL SPORTS");
        header.setTextColor(Color.WHITE);
        header.setTextSize(18);
        header.setPadding(20, 30, 20, 25);
        header.setBackgroundColor(Color.rgb(13, 29, 55));
        root.addView(header);

        progress = new ProgressBar(this, null,
            android.R.attr.progressBarStyleHorizontal);
        root.addView(progress);

        webView = new WebView(this);
        root.addView(webView, new LinearLayout.LayoutParams(
            -1, 0, 1
        ));

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(true);

        webView.setWebChromeClient(new WebChromeClient());

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progress.setVisibility(View.GONE);
            }
        });

        setContentView(root);
        webView.loadUrl(APP_URL);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroy();
    }
}

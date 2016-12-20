package browser.build.com.urlopener;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button search_btn;
    EditText url_text;
    WebView url_web;


      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_btn = (Button) findViewById(R.id.search_button);
        url_text = (EditText) findViewById(R.id.editText);

        url_web = (WebView)findViewById(R.id.web_view);

        WebSettings webSettings = url_web.getSettings();
        webSettings.setJavaScriptEnabled(true);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                }
                String urlText = url_text.getText().toString();
                url_web.setWebViewClient(new WebViewClient());
                if (!urlText.startsWith("http://") && !urlText.startsWith("https://")) {
                    urlText = "http://" + urlText;
                    url_web.loadUrl(urlText);
                }
                else{
                    urlText = "http://google.com";
                    url_web.loadUrl(urlText);
                    url_text.clearFocus();

                }
                url_web.setVisibility(View.VISIBLE);
            }


        });

        url_text.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                boolean result = false;
                if (keyCode == KeyEvent.KEYCODE_ENTER) { //Whenever you got user click enter. Get text in edittext and check it equal test1. If it's true do your code in listenerevent of button3
                    if (url_text.getText().toString() != null && !url_text.getText().toString().isEmpty()) {

                        if (v != null) {
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                        }
                        String urlText = url_text.getText().toString();
                        url_web.setWebViewClient(new WebViewClient());
                        if (!urlText.startsWith("http://") && !urlText.startsWith("https://")) {
                            urlText = "http://" + urlText;
                            url_web.loadUrl(urlText);
                        }
                        else{
                            urlText = "http://google.com";
                            url_web.loadUrl(urlText);
                            url_text.clearFocus();
                        }
                        url_web.setVisibility(View.VISIBLE);
                    }
                     result = true;

                    }

                return  result;
            }
        });


        }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (url_web.canGoBack()) {
                        url_web.goBack();
                    } {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


}

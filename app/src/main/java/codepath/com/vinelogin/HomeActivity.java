package codepath.com.vinelogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static codepath.com.vinelogin.LoginActivity.ITEM_TEXT;

public class HomeActivity extends AppCompatActivity {

    TextView tvWelcome;
    EditText et;
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvWelcome = findViewById(R.id.tvWelcomeScreen);
        et = findViewById(R.id.editText);
        im = findViewById(R.id.imageView);
        tvWelcome.setText("Hello, " + getIntent().getStringExtra(ITEM_TEXT));
    }

    public void onClick(View v) {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(this.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        String url = et.getText().toString();

        GlideApp.with(this).load(url).into(im);

    }
}

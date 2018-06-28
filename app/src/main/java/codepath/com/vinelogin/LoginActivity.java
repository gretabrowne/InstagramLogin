package codepath.com.vinelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUser;
    EditText password;
    public static final int EDIT_REQUEST_CODE = 20;
    public static final String ITEM_TEXT = "name";
    public static final String PASSWORD = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUser = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
    }

    public void onClick(View v) {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(this.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        i.putExtra(ITEM_TEXT, etUser.getText().toString());
        Log.i("tag", etUser.getText().toString());
        if (PASSWORD.equals(password.getText().toString())) {
            startActivityForResult(i, EDIT_REQUEST_CODE);
        }
        else {
            Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
        }
    }
}

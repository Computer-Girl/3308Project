package dachman.lucas.letsgoapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author jasmine
 * Created by Jasmine 3/20/17
 * function SplashActivity extends AppCompatActivity
 * designed to show user logo while
 * app and database load
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

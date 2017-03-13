package dachman.lucas.letsgoapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by lucas on 3/12/17.
 */

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //TODO: Add real login activity

    }

    public void onClickLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), TabbedEventListActivity.class);
        startActivity(intent);

    }
}

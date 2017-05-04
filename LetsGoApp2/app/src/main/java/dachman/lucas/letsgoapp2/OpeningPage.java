package dachman.lucas.letsgoapp2;
/**
 * @author jasmine
 * Created by Jasmine on 3/19/17.
 * function Openingpage extends AppCompatActivity
 * opening page for app once db and app loads and starts
 * not used for final product
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import dachman.lucas.letsgoapp2.R;
import dachman.lucas.letsgoapp2.LoginActivity;

public class OpeningPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_page);
    }
    public void onClickLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}


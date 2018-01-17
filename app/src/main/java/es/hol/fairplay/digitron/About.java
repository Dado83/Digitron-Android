package es.hol.fairplay.digitron;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setIcon(R.drawable.icon);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME);
    }
}

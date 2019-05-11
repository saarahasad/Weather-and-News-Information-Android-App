package com.example.apple.project2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 29/04/17.
 */

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.setting)
    TextView SettingTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);
        ButterKnife.bind(this);
        SettingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager()
                        .beginTransaction()
                        .replace(android.R.id.content, new SettingsFragment())
                        .commit();

            }
        });

    }

}

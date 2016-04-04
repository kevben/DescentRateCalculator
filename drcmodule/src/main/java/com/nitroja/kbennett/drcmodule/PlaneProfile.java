package com.nitroja.kbennett.drcmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nitroja.kbennett.CreateProfile;

public class PlaneProfile extends AppCompatActivity {

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane_profile);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


        final EditText na = (EditText) findViewById(R.id.planename);
        final Button proceed = (Button) findViewById(R.id.button);

        proceed.setVisibility(View.INVISIBLE);

        na.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                if (na.getText().length() == 0) {

                    proceed.setVisibility(View.INVISIBLE);
                }

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                    proceed.setEnabled(true);
                    proceed.setAlpha(1f);

                proceed.setVisibility(View.VISIBLE);

                result = na.getText().toString();


                proceed.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {

                        Intent intent = new Intent(PlaneProfile.this, CreateProfile.class);
                        intent.putExtra("name", result);
                        startActivity(intent);

                    }
                });
            }
        });


    }
}

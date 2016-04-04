package com.nitroja.kbennett;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nitroja.kbennett.drcmodule.R;

public class CreateProfile extends AppCompatActivity {

    double spdto = 0.00, calc1 = 0.00, knot = 0.539957, km = 1.852, distto = 0.00, calc2 = 0.00, calc3 = 0.00, mins = 0;
    int calc1test = 0, calc2test = 0, time = 60, minsint = 0, desc_alt = 0, descent_rate = 0;
    String calc1fin, calc2fin, calc3fin, calc4fin, calc5fin;

    /*private SharedPreferences preferenceSettings;
    private SharedPreferences.Editor preferenceEditor;

    private static final int PREFERENCE_MODE_PRIVATE = 0;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); */

        /*preferenceSettings = getPreferences(PREFERENCE_MODE_PRIVATE);
        preferenceEditor = preferenceSettings.edit();*/


        final EditText alt = (EditText) findViewById(R.id.altitude);
        final EditText spd = (EditText) findViewById(R.id.speed);
        final EditText dist = (EditText) findViewById(R.id.distance);
        final TextView kntext = (TextView) findViewById(R.id.textView2);
        final TextView kmhtext = (TextView) findViewById(R.id.textView3);
        final TextView nmtext = (TextView) findViewById(R.id.textView4);
        final TextView kmtext = (TextView) findViewById(R.id.textView5);
        final EditText speedconvert = (EditText) findViewById(R.id.editText3);
        final EditText distconvert = (EditText) findViewById(R.id.editText5);
        final EditText num1 = (EditText) findViewById(R.id.ans1);
        final EditText num2 = (EditText) findViewById(R.id.ans2);
        final EditText num3 = (EditText) findViewById(R.id.ans3);

        /*final TextView nam = (TextView) findViewById(R.id.textView16);
        title = getIntent().getStringExtra("name");*/


        final Button con1 = (Button) findViewById(R.id.convert1);
        final Button con2 = (Button) findViewById(R.id.convert2);
        final Button con3 = (Button) findViewById(R.id.convert3);
        final Button save = (Button) findViewById(R.id.button4);

        final TextView fin = (TextView) findViewById(R.id.textView14);



        spd.setVisibility(View.INVISIBLE);
        kntext.setVisibility(View.INVISIBLE);
        con1.setVisibility(View.INVISIBLE);
        speedconvert.setVisibility(View.INVISIBLE);
        kmhtext.setVisibility(View.INVISIBLE);


        dist.setVisibility(View.INVISIBLE);
        nmtext.setVisibility(View.INVISIBLE);
        con2.setVisibility(View.INVISIBLE);
        distconvert.setVisibility(View.INVISIBLE);
        kmtext.setVisibility(View.INVISIBLE);

        fin.setVisibility(View.INVISIBLE);


       save.setEnabled(false);
        save.setAlpha(.3f);

        con1.setEnabled(false);
        con1.setAlpha(.7f);

        con2.setEnabled(false);
        con2.setAlpha(.7f);

        con3.setEnabled(false);
        con3.setAlpha(.7f);

        //save.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);

        speedconvert.setInputType(InputType.TYPE_NULL);
        distconvert.setInputType(InputType.TYPE_NULL);
        num1.setInputType(InputType.TYPE_NULL);
        num2.setInputType(InputType.TYPE_NULL);
        num3.setInputType(InputType.TYPE_NULL);


        alt.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                if (alt.getText().length() == 0) {

                    spd.setVisibility(View.INVISIBLE);
                    kntext.setVisibility(View.INVISIBLE);
                    con1.setVisibility(View.INVISIBLE);
                    speedconvert.setVisibility(View.INVISIBLE);
                    kmhtext.setVisibility(View.INVISIBLE);

                    if (con2.getVisibility() == View.VISIBLE) {

                        dist.setVisibility(View.INVISIBLE);
                        nmtext.setVisibility(View.INVISIBLE);
                        con2.setVisibility(View.INVISIBLE);
                        distconvert.setVisibility(View.INVISIBLE);
                        kmtext.setVisibility(View.INVISIBLE);

                    }

                    if (con3.isEnabled()){

                        con3.setEnabled(false);
                        con3.setAlpha(.7f);
                    }

                    num1.setText("");
                    num2.setText("");
                    num3.setText("");
                    spd.setText("");
                    speedconvert.setText("");
                    dist.setText("");
                    distconvert.setText("");

                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if (alt.getText().toString().equals(".") ||  alt.getText().toString().equals("0")) {
                    spd.setVisibility(View.INVISIBLE);
                    kntext.setVisibility(View.INVISIBLE);
                    con1.setVisibility(View.INVISIBLE);
                    speedconvert.setVisibility(View.INVISIBLE);
                    kmhtext.setVisibility(View.INVISIBLE);
                } else {
                    spd.setVisibility(View.VISIBLE);
                    kntext.setVisibility(View.VISIBLE);
                    con1.setVisibility(View.VISIBLE);
                    speedconvert.setVisibility(View.VISIBLE);
                    kmhtext.setVisibility(View.VISIBLE);
                }

            }
        });


        spd.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                if (spd.getText().length() == 0) {

                    con1.setEnabled(false);
                    con1.setAlpha(.7f);

                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

               if (spd.getText().toString().equals(".") || spd.getText().toString().equals("0")) {
                   con1.setEnabled(false);
                   con1.setAlpha(.7f);
                } else {
                   con1.setEnabled(true);
                   con1.setAlpha(1f);
                }


                con1.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {

                        spdto = Double.parseDouble(spd.getText().toString());
                        calc1 = spdto / knot;
                        calc1test = (int) Math.round(calc1);
                        calc1fin = String.valueOf(calc1test);
                        speedconvert.setText(calc1fin);

                        dist.setVisibility(View.VISIBLE);
                        nmtext.setVisibility(View.VISIBLE);
                        con2.setVisibility(View.VISIBLE);
                        distconvert.setVisibility(View.VISIBLE);
                        kmtext.setVisibility(View.VISIBLE);

                    }
                });

            }
        });


        dist.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {


                if (dist.getText().length() == 0) {

                    con2.setEnabled(false);
                    con2.setAlpha(.7f);
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (dist.getText().toString().equals(".") || dist.getText().toString().equals("0")) {
                    con2.setEnabled(false);
                    con2.setAlpha(.7f);
                } else {
                    con2.setEnabled(true);
                    con2.setAlpha(1f);
                }


                con2.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {

                        distto = Double.parseDouble(dist.getText().toString());
                        calc2 = distto * km;
                        calc2test = (int) Math.round(calc2);
                        calc2fin = String.valueOf(calc2test);
                        distconvert.setText(calc2fin);

                        if (speedconvert.getText().length() > 0 && distconvert.getText().length() > 0) {

                            con3.setEnabled(true);
                            con3.setAlpha(1f);

                        }

                    }
                });
            }
        });



        con3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                calc3 = distto / spdto;
                calc3fin = String.valueOf(calc3);
                num1.setText(calc3fin);

                mins = calc3 * time;
                minsint = (int) Math.round(mins);
                calc4fin = String.valueOf(minsint);
                num2.setText(calc4fin);

                desc_alt = Integer.parseInt(alt.getText().toString());
                descent_rate = desc_alt / minsint;
                calc5fin = String.valueOf(descent_rate);
                num3.setText("-" + calc5fin);

                /*save.setEnabled(true);
                save.setAlpha(1f);*/

            }
        });

        /*save.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                preferenceEditor.putString("altitude", alt.getText().toString());
                preferenceEditor.putString("speedKnots", spd.getText().toString());
                preferenceEditor.putString("speedKM/H", speedconvert.getText().toString());
                preferenceEditor.putString("distanceNM", dist.getText().toString());
                preferenceEditor.putString("distanceKM", distconvert.getText().toString());
                preferenceEditor.putInt("timeMins", minsint);
                preferenceEditor.putInt("descentRate", descent_rate);
                preferenceEditor.apply();

                new CountDownTimer(3000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        fin.setVisibility(View.VISIBLE);
                    }

                    public void onFinish() {

                        fin.setVisibility(View.INVISIBLE);

                    }
                }.start();

            }
        });
*/
    }
}
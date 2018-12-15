package com.angfly.anos.ask.app.app_0001_led_demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.angfly.anos.ask.app.hard_library.HardControl;
//import android.os.ILedAngflyService;
//import android.os.ServiceManager;

public class MainActivity extends Activity {

    private boolean led_status = false;

    private Button all_led_switch_button = null;

    private CheckBox ck_led_1_switch = null;

    private CheckBox ck_led_2_switch = null;

    private CheckBox ck_led_3_switch = null;

    private CheckBox ck_led_4_switch = null;

    private Context mContext = null;

    //private ILedAngflyService iLedAngflySerice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        all_led_switch_button = findViewById(R.id.all_button);
        ck_led_1_switch = findViewById(R.id.ck_led_1_liner_layout);
        ck_led_2_switch = findViewById(R.id.ck_led_2_liner_layout);
        ck_led_3_switch = findViewById(R.id.ck_led_3_liner_layout);
        ck_led_4_switch = findViewById(R.id.ck_led_4_liner_layout);

        all_led_switch_button.setOnClickListener(new MyButtonOnClickListener());

        HardControl.ledOpen();
        //iLedAngflySerice = ILedAngflyService.Stub.asInterface(ServiceManager.getService("ledAngfly"));

        /*
        all_led_switch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                led_status = !led_status;
                if (led_status) {
                    all_led_switch_button.setText("Led All On");
                } else {
                    all_led_switch_button.setText("Led All Off");
                }
            }
        });
        */
    }

    class MyButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            led_status = !led_status;
            //HardControl hd = new HardControl();

            if (led_status) {
                all_led_switch_button.setText("Led All On");
                ck_led_1_switch.setChecked(true);
                ck_led_2_switch.setChecked(true);
                ck_led_3_switch.setChecked(true);
                ck_led_4_switch.setChecked(true);


                    for (int i = 0; i < 4; i ++) {
                        HardControl.ledCtrl(i, 1);
                        //iLedAngflySerice.ledCtrl_aidl(i, 1);
                    }


            } else {
                all_led_switch_button.setText("Led All Off");
                ck_led_1_switch.setChecked(false);
                ck_led_2_switch.setChecked(false);
                ck_led_3_switch.setChecked(false);
                ck_led_4_switch.setChecked(false);

                    for (int i = 0; i < 4; i ++) {
                        HardControl.ledCtrl(i, 0);
                        //iLedAngflySerice.ledCtrl_aidl(i, 0);
                    }

            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();


            // Check which checkbox was clicked
            switch(view.getId()) {
                case R.id.ck_led_1_liner_layout:
                    if (checked) {
                        // Put some meat on the sandwich
                        HardControl.ledCtrl(0, 1);
                        //iLedAngflySerice.ledCtrl_aidl(0, 1);
                        Toast.makeText(mContext, "Led_1 On", Toast.LENGTH_LONG).show();
                    } else {
                        // Remove the meat
                        HardControl.ledCtrl(0, 0);
                        //iLedAngflySerice.ledCtrl_aidl(0, 0);
                        Toast.makeText(mContext, "Led_1 Off", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.ck_led_2_liner_layout:
                    if (checked) {
                        // Put some meat on the sandwich
                        HardControl.ledCtrl(1, 1);
                        //iLedAngflySerice.ledCtrl_aidl(1, 1);
                        Toast.makeText(mContext, "Led_2 On", Toast.LENGTH_LONG).show();
                    } else {
                        // Remove the meat
                        HardControl.ledCtrl(1, 0);
                        //iLedAngflySerice.ledCtrl_aidl(1, 0);
                        Toast.makeText(mContext, "Led_2 Off", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.ck_led_3_liner_layout:
                    if (checked) {
                        // Put some meat on the sandwich
                        HardControl.ledCtrl(2, 1);
                        //iLedAngflySerice.ledCtrl_aidl(2, 1);
                        Toast.makeText(mContext, "Led_3 On", Toast.LENGTH_LONG).show();
                    } else {
                        // Remove the meat
                        HardControl.ledCtrl(2, 0);
                        //iLedAngflySerice.ledCtrl_aidl(2, 0);
                        Toast.makeText(mContext, "Led_3 Off", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.ck_led_4_liner_layout:
                    if (checked) {
                        // Put some meat on the sandwich
                        HardControl.ledCtrl(3, 1);
                        //iLedAngflySerice.ledCtrl_aidl(3, 1);
                        Toast.makeText(mContext, "Led_4 On", Toast.LENGTH_LONG).show();
                    } else {
                        // Remove the meat
                        HardControl.ledCtrl(3, 0);
                        //iLedAngflySerice.ledCtrl_aidl(3, 0);
                        Toast.makeText(mContext, "Led_4 Off", Toast.LENGTH_LONG).show();
                    }
                    break;

                // TODO: Veggie sandwich
            }

    }
}

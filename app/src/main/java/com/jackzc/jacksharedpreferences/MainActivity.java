package com.jackzc.jacksharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView lb_username;
    TextView lb_password;
    TextView lb_showinfo;

    EditText txt_username;
    EditText txt_password;

    Button btn_saveinfo;
    Button btn_displayinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lb_username = (TextView) findViewById(R.id.lb_username);
        lb_password = (TextView) findViewById(R.id.lb_password);
        lb_showinfo = (TextView) findViewById(R.id.lb_showinfo);

        txt_username = (EditText) findViewById(R.id.txt_username);
        txt_password = (EditText) findViewById(R.id.txt_password);

        btn_saveinfo = (Button) findViewById(R.id.btn_saveinfo);
        btn_displayinfo = (Button) findViewById(R.id.btn_displayinfo);

    }


    // Save user info
    public void doSaveInfo(View view) {

        String user_name = txt_username.getText().toString();
        String user_password = txt_password.getText().toString();

        SharedPreferences sp = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("UserName", user_name);
        editor.putString("UserPassword", user_password);
        editor.apply();

        Toast.makeText(this, "User information saved!", Toast.LENGTH_LONG).show();

    }


    // Display user info from saved data
    public void doDisplayInfo(View view) {

        SharedPreferences sp = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        String user_name = sp.getString("UserName", "None");
        String user_password = sp.getString("UserPassword", "None");
        lb_showinfo.setText(user_name + " " + user_password);

    }
}

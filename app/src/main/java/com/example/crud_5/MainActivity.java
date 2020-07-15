package com.example.crud_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText pas,usr;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usr = (EditText) findViewById( R.id.usuario);
        pas = (EditText) findViewById(R.id.contrasena);

        btn = (Button) findViewById(R.id.boton);

        btn.setOnClickListener( new View.OnClickListener() {
// https://stackoverflow.com/questions/14782901/android-how-to-handle-button-click
            @Override
            public void onClick(View v) {
                loginBtn(v);
            }
        });

    }


    public void loginBtn(View view) {
        String user = usr.getText().toString();
        String pass = pas.getText().toString();

        background bg = new background();
        bg.execute(user,pass);

        // https://developer.android.com/training/snackbar/showing#java
        if(bg.doInBackground(user, pass).contains(usr.getText())){
            Snackbar mySnackbar = Snackbar.make(view, "login fracaso", Snackbar.LENGTH_LONG);

            mySnackbar.show();

        }
        else{
            Snackbar mySnackbar = Snackbar.make(view, "login exitoso. bienvenido, usuario "+usr.getText(), Snackbar.LENGTH_LONG);

            mySnackbar.show();
        }
    }
}
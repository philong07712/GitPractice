package com.example.mvplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvplogin.Presenter.ILoginPresenter;
import com.example.mvplogin.Presenter.LoginPresenter;
import com.example.mvplogin.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    EditText edt_email, edt_pass;
    Button btn;
    ILoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // init view
        edt_email = (EditText) findViewById(R.id.edit_email);
        edt_pass = (EditText) findViewById(R.id.edit_pass);
        btn = (Button) findViewById(R.id.button);

        presenter = new LoginPresenter(this);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                presenter.onLogin(edt_email.getText().toString(), edt_pass.getText().toString());
            }
        });
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

package com.example.broadcastforcedoffline;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText mEditTextAdmin, mEditTextPwd;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mEditTextAdmin = findViewById(R.id.editAdmin);
        mEditTextPwd = findViewById(R.id.editPwd);
        mButtonLogin = findViewById(R.id.loginBtn);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextAdmin.getText().toString().equals("123456")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(mActivity, "用户不存在!请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

package com.example.broadcastforcedoffline;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText mEditTextAdmin, mEditTextPwd;
    private Button mButtonLogin;
    private CheckBox mCheckBox;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        if (mSharedPreferences.getBoolean("adminSave", false)) {
            mEditTextAdmin.setText(mSharedPreferences.getString("admin", null));
            mEditTextPwd.setText(mSharedPreferences.getString("pwd", null));
        }
    }

    private void initView() {
        mEditTextAdmin = findViewById(R.id.editAdmin);
        mEditTextPwd = findViewById(R.id.editPwd);
        mButtonLogin = findViewById(R.id.loginBtn);
        mCheckBox = findViewById(R.id.checkedBtn);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextAdmin.getText().toString().equals("123456")) {
                    if (mCheckBox.isChecked()) {
                        mEditor.putBoolean("adminSave", true);
                        mEditor.putString("admin", mEditTextAdmin.getText().toString().trim());
                        mEditor.putString("pwd", mEditTextPwd.getText().toString().trim());
                    } else {
                        mEditor.clear();
                    }
                    mEditor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(mActivity, "用户不存在!请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

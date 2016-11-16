package com.zoobiedo.org.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zoobiedo.org.R;
import com.zoobiedo.org.model.LoginData;
import com.zoobiedo.org.model.User;
import com.zoobiedo.org.model.UserData;
import com.zoobiedo.org.model.UserResponse;
import com.zoobiedo.org.services.ApiClient;
import com.zoobiedo.org.services.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileDetailsActivity extends AppCompatActivity {

    Button btnSave,btnContinue,btnSend;
    LinearLayout layoutProfile,layoutActivation,layoutFPWD;
    private EditText inputName, inputEmail, inputPassword, inputMobile,inputLastName,
            inputMiddleName,inputAddr1,inputAddr2,inputAddr3,inputDOb,inputCity,inputState,inputPincode;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword,inputLayoutMobile,inputLayoutLastName,inputLayoutMiddlename,inputLayoutDob,inputLayoutaddr1,inputLayoutaddr2,
            inputLayoutaddr3,inputLayoutcity,inputLayoutState,inputLayoutPincode;
    User mUser = new User();
    TextView timerText;
    UserData mRegisterObject = new UserData();
    LoginData mLoginData = new LoginData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);

        layoutProfile = (LinearLayout)findViewById(R.id.layoutProfile);
        layoutActivation = (LinearLayout)findViewById(R.id.layoutActivation);
        layoutFPWD = (LinearLayout)findViewById(R.id.layoutForgetPwd);
        btnSave = (Button)findViewById(R.id.btn_save);
        btnContinue = (Button)findViewById(R.id.btn_Continue);
        btnSend = (Button)findViewById(R.id.btnSend);
        timerText = (TextView)findViewById(R.id.txtTimer);

        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputLayoutMobile = (TextInputLayout) findViewById(R.id.input_layout_mobile);
        inputLayoutLastName = (TextInputLayout) findViewById(R.id.input_layout_last_name);
        inputLayoutMiddlename = (TextInputLayout) findViewById(R.id.input_layout_middle_name);
        inputLayoutDob = (TextInputLayout) findViewById(R.id.input_layout_dob);
        inputLayoutaddr1 = (TextInputLayout) findViewById(R.id.input_layout_address1);
        inputLayoutaddr2 = (TextInputLayout) findViewById(R.id.input_layout_address2);
        inputLayoutaddr3 = (TextInputLayout) findViewById(R.id.input_layout_address3);
        inputLayoutcity = (TextInputLayout) findViewById(R.id.input_layout_city);
        inputLayoutState = (TextInputLayout) findViewById(R.id.input_layout_state);
        inputLayoutPincode = (TextInputLayout) findViewById(R.id.input_layout_pincode);

        inputName = (EditText) findViewById(R.id.input_name);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        inputMobile = (EditText) findViewById(R.id.input_mobile);
        inputLastName = (EditText) findViewById(R.id.input_last_name);
        inputMiddleName = (EditText) findViewById(R.id.input_middle_name);

        inputAddr1 = (EditText) findViewById(R.id.input_addr1);
        inputAddr2 = (EditText) findViewById(R.id.input_addr2);
        inputAddr3 = (EditText) findViewById(R.id.input_addr3);
        inputDOb = (EditText) findViewById(R.id.input_dob);
        inputCity = (EditText) findViewById(R.id.input_city);
        inputState = (EditText) findViewById(R.id.input_state);
        inputPincode = (EditText) findViewById(R.id.input_pincode);

        if(getIntent().getExtras().getString(getString(R.string.extras_forgetPwd))!= null)
        {
            layoutFPWD.setVisibility(View.VISIBLE);
            layoutProfile.setVisibility(View.GONE);
            layoutActivation.setVisibility(View.GONE);
        }
        else
        {
            if(getIntent().getExtras().get(getString(R.string.extras_user_normal))!=null)
            {
                mRegisterObject = getIntent().getExtras().getParcelable(getString(R.string.extras_user_normal_data));
                inputName.setText(mRegisterObject.getFirstName());
                inputMiddleName.setText(mRegisterObject.getMiddleName());
                inputLastName.setText(mRegisterObject.getLastName());
                inputEmail.setText(mRegisterObject.getUserName());
                inputAddr1.setText(mRegisterObject.getAddressLine1());
                inputAddr2.setText(mRegisterObject.getAddressLine2());
                inputAddr3.setText(mRegisterObject.getAddressLine3());
                inputMobile.setText(mRegisterObject.getMobile());
                inputCity.setText(mRegisterObject.getCity());
                inputDOb.setText(mRegisterObject.getDateOfBirth());
                inputState.setText(mRegisterObject.getState());
                inputPincode.setText(mRegisterObject.getPincode());
            }
            else if(getIntent().getExtras().get(getString(R.string.extras_user_social_data))!=null)
            {
                mLoginData = getIntent().getExtras().getParcelable(getString(R.string.extras_user_social_data));
                inputName.setText(mLoginData.getUserName());
                inputMiddleName.setText(mLoginData.getMiddleName());
                inputLastName.setText(mLoginData.getLastName());
                inputEmail.setText(mLoginData.getUserName());

            }
            layoutFPWD.setVisibility(View.GONE);
            layoutProfile.setVisibility(View.VISIBLE);
            layoutActivation.setVisibility(View.GONE);
        }

    }

    public void onClicView(View view)
    {
        switch (view.getId())
        {
            case R.id.layoutProfile:
                break;
            case R.id.layoutActivation:
                break;
            case R.id.layoutForgetPwd:
                break;

            case R.id.btnSend:
                finish();
                break;
            case R.id.btn_save:
                submitDetails();

                break;
            case R.id.btn_Continue:

                startActivity(new Intent(ProfileDetailsActivity.this,MainActivity.class));
                break;
        }
    }

    private void submitDetails() {

        layoutProfile.setVisibility(View.GONE);
        layoutFPWD.setVisibility(View.GONE);
        layoutActivation.setVisibility(View.VISIBLE);

       /* mRegisterObject.setUserName(inputEmail.getText().toString());
        mRegisterObject.setFirstName(inputName.getText().toString());
        mRegisterObject.setLastName(inputLastName.getText().toString());
        mRegisterObject.setPassword(inputPassword.getText().toString());
        mRegisterObject.setMobile(inputMobile.getText().toString());
        mRegisterObject.setAddressLine1(inputAddr1.getText().toString());
        mRegisterObject.setDateOfBirth("/Date(" + inputDOb.getText().toString() + ")/");
        mRegisterObject.setAddressLine2(inputAddr2.getText().toString());
        mRegisterObject.setAddressLine3(inputAddr3.getText().toString());
        mRegisterObject.setCity(inputCity.getText().toString());
        mRegisterObject.setState(inputState.getText().toString());
        mRegisterObject.setPincode(inputPincode.getText().toString());
        mRegisterObject.setMiddleName(inputMiddleName.getText().toString());

        mRegisterObject.setDevice(1);
        mRegisterObject.setDeviceActivationCode("");
        mRegisterObject.setFacebookUserId("");
        mRegisterObject.setGoogleUserId("");
        mRegisterObject.setIsFacebookLogin(false);
        mRegisterObject.setIsGoogleLogin(false);
        mRegisterObject.setIsMobileVerified(false);
        mRegisterObject.setIsRegistered(false);
        mRegisterObject.setMobileActivationCode("");
        mRegisterObject.setBookingUserId(0);

        Log.d("debug", "user date" + new Gson().toJson(mRegisterObject));
        Call<UserResponse> responseCall = ApiClient.getRetrofitClient().create(ApiInterface.class).postRegisterUser(mRegisterObject);

        responseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                if (response.body().getmRegisterDetails() != null) {
                    layoutActivation.setVisibility(View.VISIBLE);
                    new CountDownTimer(60 * 2 * 1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            timerText.setText("We will call you with in : " + String.format("%02d:%02d", ((millisUntilFinished / 1000) / 60), ((millisUntilFinished / 1000)) % 60));
                        }

                        public void onFinish() {
                            // timerText.setText("done!");
                        }
                    }.start();
                    layoutProfile.setVisibility(View.GONE);
                    layoutFPWD.setVisibility(View.GONE);
                } else {
                    Toast.makeText(ProfileDetailsActivity.this, response.body().getErrorCode(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

                Log.d("debug", "error" + t.toString());

            }
        });*/

    }
}

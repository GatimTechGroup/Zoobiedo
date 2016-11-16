package com.zoobiedo.org.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.zoobiedo.org.R;
import com.zoobiedo.org.model.LoginData;
import com.zoobiedo.org.model.RegisterObject;
import com.zoobiedo.org.model.User;
import com.zoobiedo.org.model.UserData;
import com.zoobiedo.org.model.UserResponse;
import com.zoobiedo.org.services.ApiClient;
import com.zoobiedo.org.services.ApiInterface;
import com.zoobiedo.org.utils.AppUtils;
import com.zoobiedo.org.utils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{


    private Toolbar toolbar;
    private EditText inputName, inputEmail, inputPassword, inputMobile,inputLastName,
                     inputMiddleName,inputAddr1,inputAddr2,inputAddr3,inputDOb,inputCity,inputState,inputPincode;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword,inputLayoutMobile,inputLayoutLastName,inputLayoutMiddlename,inputLayoutDob,inputLayoutaddr1,inputLayoutaddr2,
            inputLayoutaddr3,inputLayoutcity,inputLayoutState,inputLayoutPincode;
    private Button btnLogin;

    private LoginButton loginButton;
    private LinearLayout signIn,register;
    CallbackManager callbackManager;
    GoogleApiClient mGoogleApiClient;

    Button signInButton,fbLogin;
    String profilePicUrl = "";
    String profileName ="";

    TextView lineLogin,lineSingUp,txtForgetPwd;

    LinearLayout layoutOr,layoutFb,layoutGoogle,layoutLogin,layoutSingUp;
    EditText loginUN,loginPwd;
    ImageView imgEye;
    User mUser = new User();
    UserData mRegisterObject = new UserData();
    LoginData mLoginData = new LoginData();
     ProgressDialog mProgress;
    String loginType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);


        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        signInButton = (Button) findViewById(R.id.sign_in_button);
        fbLogin = (Button)findViewById(R.id.fb);

        mProgress = new ProgressDialog(this);
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

        loginUN = (EditText) findViewById(R.id.editTextUsername);
        loginPwd = (EditText) findViewById(R.id.editTextPwd);

        lineLogin = (TextView) findViewById(R.id.loginLine);
        lineSingUp = (TextView) findViewById(R.id.signUpLine);
        txtForgetPwd = (TextView) findViewById(R.id.txtForgetPwd);
        imgEye = (ImageView) findViewById(R.id.iconeye);

        imgEye.setTag("active");

        loginUN.setText("venky@gmail.com");
        loginPwd.setText("123");


        signIn = (LinearLayout)findViewById(R.id.signIn);
        register = (LinearLayout)findViewById(R.id.register);

        layoutOr = (LinearLayout)findViewById(R.id.layoutOR);
        layoutLogin = (LinearLayout)findViewById(R.id.layoutLogin);
        layoutSingUp = (LinearLayout)findViewById(R.id.layoutsignUp);
        layoutFb = (LinearLayout)findViewById(R.id.layoutFbLogin);
        layoutGoogle = (LinearLayout)findViewById(R.id.layoutGoogleLogin);

        btnLogin = (Button) findViewById(R.id.btn_login);

        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
        signIn.setTag("active");
        lineSingUp.setBackgroundColor(Color.parseColor("#ffffbb"));
        lineLogin.setBackgroundColor(Color.parseColor("#ffffbb33"));
        btnLogin.setText(getResources().getString(R.string.text_sign_In));

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

        // If using in a fragment
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code

                Bundle params = new Bundle();
                params.putString("fields", "id,name,email,gender,birthday,cover,picture.type(large)");
                new GraphRequest(AccessToken.getCurrentAccessToken(), "me", params, HttpMethod.GET,
                        new GraphRequest.Callback() {
                            @Override
                            public void onCompleted(GraphResponse response) {

                                if (response != null) {
                                    try {
                                        JSONObject data = response.getJSONObject();
                                        if (data.has("picture")) {
                                            loginType = Constants.LOGIN_TYPE_SOCIAL;
                                             profilePicUrl = data.getJSONObject("picture").getJSONObject("data").getString("url");
                                             profileName = data.getString("name");
                                            // set profile image to imageview using Picasso or Native methods
                                            Log.d("debug", "response" + profilePicUrl);
                                            mUser.setName(profileName);
                                            mUser.setProfURL(profilePicUrl);
                                            mUser.setEmail(data.getString("email"));
                                           // mUser.setDob(data.getString("birthday"));
                                            mLoginData.setGoogleUserId("");
                                            mLoginData.setDevice(1);
                                            mLoginData.setDeviceActivationCode("");
                                            mLoginData.setEmailAddress(data.getString("email"));
                                            mLoginData.setFirstName(profileName);
                                            mLoginData.setFacebookUserId(data.getString("id"));
                                            mLoginData.setLastName("");
                                            mLoginData.setLoginMode(1);
                                            mLoginData.setPassword("");
                                            mLoginData.setMiddleName("");
                                            startActivtySocial();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                               startActivtySocial();
                            }
                        }).executeAsync();
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, 425);
            }
        });
    }

    public void visibleSignUp()
    {
        layoutOr.setVisibility(View.GONE);
        layoutFb.setVisibility(View.GONE);
        layoutGoogle.setVisibility(View.GONE);
        txtForgetPwd.setVisibility(View.GONE);
        layoutLogin.setVisibility(View.GONE);
        layoutSingUp.setVisibility(View.VISIBLE);
    }
    public void goneSignUp()
    {
        layoutOr.setVisibility(View.VISIBLE);
        layoutFb.setVisibility(View.VISIBLE);
        layoutGoogle.setVisibility(View.VISIBLE);
        txtForgetPwd.setVisibility(View.VISIBLE);
        layoutLogin.setVisibility(View.VISIBLE);
        layoutSingUp.setVisibility(View.GONE);
    }

    public void onClicView(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.signIn:
                goneSignUp();
                signIn.setTag("active");
                lineLogin.setBackgroundColor(Color.parseColor("#ffffbb33"));
                lineSingUp.setBackgroundColor(Color.parseColor("#ffffbb"));
                btnLogin.setText(getResources().getString(R.string.text_sign_In));
                break;
            case R.id.register:
               visibleSignUp();
                signIn.setTag("inactive");
                lineLogin.setBackgroundColor(Color.parseColor("#ffffbb"));
                lineSingUp.setBackgroundColor(Color.parseColor("#ffffbb33"));
                btnLogin.setText(getResources().getString(R.string.btn_sign_up));
                break;
            case R.id.btn_login:
                if(signIn.getTag().toString().equalsIgnoreCase("active")) {
                    submitFormSignIn();
                }
                else
                {
                    submitFormRegister();
                }
                break;
            case R.id.sign_in_button:

                break;
            case R.id.fb:
                loginButton.performClick();
                break;
            case R.id.iconeye:
                if(imgEye.getTag().toString().equalsIgnoreCase("inactive") && loginPwd.getText().toString().length() !=0)
                {
                    loginPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imgEye.setBackgroundResource(R.drawable.eyeicon);
                    imgEye.setTag("active");
                }else if(imgEye.getTag().toString().equalsIgnoreCase("active") && loginPwd.getText().toString().length() !=0)
                {
                    imgEye.setBackgroundResource(R.drawable.eyeselected);
                    loginPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imgEye.setTag("inactive");

                }

                break;
            case R.id.txtForgetPwd:
                Intent intent = new Intent(LoginActivity.this,ProfileDetailsActivity.class);
                intent.putExtra(getString(R.string.extras_forgetPwd),"fpwd");
                startActivity(intent);
                break;
        }
    }
    /**
     * Validating form
     */
    private void submitFormSignIn() {

        if (!validateUserName()) {
            return;
        }

        if (!validateLoginPassword()) {
            return;
        }
        loginType = Constants.LOGIN_TYPE_NORMAL;
        startActivtySocial();
    }
    private void submitFormRegister() {
        if(!validateMobile()) {
            return;
        }
        if (!validateEmail()) {
            return;
        }
        if (!validatePassword()) {
            return;
        }
        if (!validateFirstName()) {
            return;
        }
        if (!validateLastName()) {
            return;
        }

        startActivityNormal();
    }

    private boolean validateFirstName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateMobile() {
        if (inputMobile.getText().toString().trim().length() < 10) {
            inputLayoutMobile.setError(getString(R.string.err_msg_mobile_numberLimit));
            requestFocus(inputMobile);
            return false;
        } else {
            inputLayoutMobile.setErrorEnabled(false);
        }

        return true;
    }


    private boolean validateLastName()
    {
        if(inputLastName.getText().toString().trim().isEmpty())
        {
            inputLayoutLastName.setError(getString(R.string.err_msg_lastName));
            requestFocus(inputLastName);
            return false;
        }
        else {

            inputLayoutLastName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateUserName() {
        String email = loginUN.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            loginUN.setError(getString(R.string.err_msg_email));
            requestFocus(loginUN);
            return false;
        } else {
            loginUN.setError(null);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateLoginPassword() {
        if (loginPwd.getText().toString().trim().isEmpty()) {
            loginPwd.setError(getString(R.string.err_msg_password));
            requestFocus(loginPwd);
            return false;
        } else {
            loginPwd.setError(null);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateFirstName();
                    break;
                case R.id.input_email:
                    validateEmail();
                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
                case R.id.input_last_name:
                    validateLastName();
                    break;
                case R.id.input_mobile:
                    break;
                case R.id.input_addr1:

            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 425) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d("debug", "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();

            profilePicUrl = acct.getPhotoUrl().toString();
            profileName = acct.getDisplayName();
            mUser.setName(profileName);
            mUser.setProfURL(profilePicUrl);
            mUser.setEmail(acct.getEmail());
            mLoginData.setGoogleUserId(getString(R.string.google_app_id));
            mLoginData.setDevice(1);
            mLoginData.setDeviceActivationCode("");
            mLoginData.setEmailAddress(acct.getEmail());
            mLoginData.setFirstName(profileName);
            mLoginData.setFacebookUserId("");
            mLoginData.setLastName("");
            mLoginData.setLoginMode(1);
            mLoginData.setPassword("");
            mLoginData.setMiddleName("");
            mLoginData.setUserName(acct.getEmail());
            startActivtySocial();

        } else {
            // Signed out, show unauthenticated UI.

        }
    }

    public void startActivtySocial()
    {

        if(loginType.equalsIgnoreCase(Constants.LOGIN_TYPE_NORMAL)) {
            mLoginData.setUserName(loginUN.getText().toString());
            mLoginData.setPassword(loginPwd.getText().toString());
            mLoginData.setGoogleUserId("");
            mLoginData.setDevice(1);
            mLoginData.setDeviceActivationCode("");
            mLoginData.setEmailAddress(loginUN.getText().toString());
            mLoginData.setFirstName("");
            mLoginData.setFacebookUserId("");
            mLoginData.setLastName("");
            mLoginData.setLoginMode(1);
            mLoginData.setMiddleName("");
        }
        AppUtils.createProgressBar(mProgress);
        Call<UserResponse> response = ApiClient.getRetrofitClientManagement().create(ApiInterface.class).postRegisterUserSocial(mLoginData);
        response.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                mProgress.dismiss();
                Log.d("debug", "user date" + new Gson().toJson(mLoginData));
                if (response.body().getmRegisterDetails() != null) {
                    Log.d("debug", "user response" + new Gson().toJson(response.body().getmRegisterDetails()));
                    Bundle b = new Bundle();
                    Intent intent = new Intent(LoginActivity.this, ProfileDetailsActivity.class);
                    intent.putExtra(getString(R.string.extras_user_social_data), mLoginData);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getErrorCode(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

                mProgress.dismiss();
                Toast.makeText(LoginActivity.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void startActivityNormal()
    {

        mRegisterObject.setUserName(inputEmail.getText().toString());
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
        AppUtils.createProgressBar(mProgress);
        Call<UserResponse> responseCall = ApiClient.getRetrofitClientManagement().create(ApiInterface.class).postRegisterUser(mRegisterObject);

        responseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                mProgress.dismiss();
                if(response.body().getmRegisterDetails() != null) {
                    Log.d("debug", "user response" + new Gson().toJson(response.body().getmRegisterDetails()));
                    Bundle b = new Bundle();
                    Intent intent = new Intent(LoginActivity.this, ProfileDetailsActivity.class);
                    intent.putExtra(getString(R.string.extras_user_normal_data), mRegisterObject);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, response.body().getErrorCode(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

                mProgress.dismiss();
                Toast.makeText(LoginActivity.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}

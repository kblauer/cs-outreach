/* Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the sign up function
   This java file will control the backend for creating accounts for the new user.
*/

package com.example.ajeyadav.cstutorialapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebBackForwardList;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

// Main class for the Sign up activity
public class SignupActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks,
        View.OnClickListener {

    // Importing database helper class
    DatabaseHelper helper = new DatabaseHelper(this);

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    private UserSignupTask mAuthTask1 = null;

    // UI references.
    private EditText mFullnameView;
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mSignupFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Set up the sign up form.
        mFullnameView = (EditText) findViewById(R.id.userinputname);
        mEmailView = (EditText) findViewById(R.id.userinputemail2);
        mPasswordView = (EditText) findViewById(R.id.userinputpassword2);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if ((id == R.id.buttonsignup2) || (id == EditorInfo.IME_NULL)) {
                    attemptSignup();
                    return true;
                }
                return false;
            }
        });


        // Declaring the buttons on the sign up page
        Button button9,button10;
        button9 = (Button) findViewById(R.id.buttonsignup2);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSignup();
            }
        });

        button10 = (Button) findViewById(R.id.buttoncancel);
        button10.setOnClickListener(this);

        mSignupFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

    }

    private void attemptSignup() {
        if (mAuthTask1 != null) {
            return;
        }

        // Reset errors.
        mFullnameView.setError(null);
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the signup attempt.
        String fullname = mFullnameView.getText().toString();
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid full name.
        if (TextUtils.isEmpty(fullname)) {
            mFullnameView.setError(getString(R.string.error_field_required));
            focusView = mFullnameView;
            cancel = true;
        } else if (!isFullnameValid(fullname)) {
//            mFullnameView.setError(getString(R.string.error_invalid_fullname));
            focusView = mFullnameView;
            cancel = true;
        }

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }


        if (cancel) {
            // There was an error; don't attempt signup and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask1 = new UserSignupTask(fullname, email, password);
            mAuthTask1.execute((Void) null);
        }
    }

    private boolean isFullnameValid(String fullname) {
        if ((fullname.length() < 5) || (fullname.length() > 16)){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
            return password.length() > 6;
    }

    public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
        if ((id == R.id.buttonlogin1) || (id == EditorInfo.IME_NULL)) {
            attemptSignup();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {

        EditText fullname = (EditText) findViewById(R.id.userinputname);
        EditText email = (EditText) findViewById(R.id.userinputemail2);
        EditText password1 = (EditText) findViewById(R.id.userinputpassword2);
        EditText password2 = (EditText) findViewById(R.id.userinputpassword3);

        String full_name = fullname.getText().toString();
        String e_mail = email.getText().toString();
        String pass1 = password1.getText().toString();
        String pass2 = password2.getText().toString();

        if (!pass1.equals(pass2)) {
            Toast.makeText(SignupActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
        } else {

            if (v.getId() == R.id.buttoncancel) {
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }

            if (v.getId() == R.id.buttonsignup2) {
                Intent i = new Intent(this, WelcomeActivity.class);
                startActivity(i);
            }

            {
                Contact c = new Contact();
                c.setFullname(full_name);
                c.setEmail(e_mail);
                c.setPassword(pass1);
                helper.insertContact(c);
            }
        }
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {

    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    public class UserSignupTask extends AsyncTask<Void, Void, Boolean> {

        private final String mFullname;
        private final String mEmail;
        private final String mPassword;

        UserSignupTask(String fullname, String email, String password) {
            mFullname = fullname;
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mSignupFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mSignupFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mSignupFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mSignupFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}
package com.ase.ionescuradu.carexpress.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ase.ionescuradu.carexpress.R;
import com.ase.ionescuradu.carexpress.utilities.DatabaseTask;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

import static com.facebook.AccessTokenManager.TAG;

//  Created by Ionescu Radu Stefan  //

public class LoginActivity extends Activity
{
    private Button bGoogle;
    private Button bFacebook;
    private LoginButton bFBLogin;
    private FirebaseAuth firebaseAuth;
    private CallbackManager fbCallbackManager;
    private GoogleSignInClient gClient;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //<editor-fold desc="Initialization">
        bGoogle = findViewById(R.id.bGoogle);
        bFacebook = findViewById(R.id.bFacebook);
        bFBLogin = findViewById(R.id.bFBLogin);
        firebaseAuth = FirebaseAuth.getInstance();
        fbCallbackManager = CallbackManager.Factory.create();
        gClient = GoogleSignIn.getClient(this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getResources().getString(R.string.oauth)).requestEmail().build());
        //</editor-fold>

        //<editor-fold desc="Button Listeners: Login/Facebook/Google">
        findViewById(R.id.bLogin).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String email = String.valueOf(((EditText) findViewById(R.id.etUsername)).getText());
                String password = String.valueOf(((EditText) findViewById(R.id.etPassword)).getText());

                if (!String.valueOf(((EditText) findViewById(R.id.etUsername)).getText()).matches("") && !String.valueOf(((EditText) findViewById(R.id.etPassword)).getText()).matches(""))
                {
                    loginWithEmail(email, password);
                }
            }
        });

        findViewById(R.id.bRegister).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        bFacebook.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                bFBLogin.performClick();
            }
        });
        bFacebook.setOnTouchListener(new View.OnTouchListener()
        {
            @SuppressLint("ClickableViewAccessibility")
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                    {
                        v.getBackground().setColorFilter(0xe0324b81, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

        bFBLogin.setReadPermissions("email", "public_profile", "user_birthday");
        bFBLogin.registerCallback(fbCallbackManager, new FacebookCallback<LoginResult>()
        {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                Log.d(TAG, "facebook:onSuccess:");
                loginWithFacebook(loginResult.getAccessToken());
            }

            @Override
            public void onCancel()
            {
                Log.d(TAG, "facebook:onCancel");
            }

            @Override
            public void onError(FacebookException error)
            {
                Log.d(TAG, "facebook:onError", error);
            }
        });

        bGoogle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent signInIntent = gClient.getSignInIntent();
                startActivityForResult(signInIntent, 9001);
            }
        });
        bGoogle.setOnTouchListener(new View.OnTouchListener()
        {
            @SuppressLint("ClickableViewAccessibility")
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                    {
                        v.getBackground().setColorFilter(0xe0eaeaea, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
        //</editor-fold>
    }

    //<editor-fold desc="Logged in user check + Landscape">
    @Override
    public void onStart()
    {
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null)
        {
            updateUI(currentUser);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 9001)
        {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try
            {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                loginWithGoogle(account);
            }
            catch (Exception e)
            {
                Log.w(TAG, "google:signInFail");
            }
        }
        else
        {
            fbCallbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            bFacebook.setPadding(5000, 0, 0, 0);
            bGoogle.setPadding(4950, 0, 0, 0);
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            bFacebook.setPadding(295, 0, 0, 0);
            bGoogle.setPadding(290, 0, 0, 0);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Login: email/facebook/google">
    private void loginWithEmail(String email, String password)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    new DatabaseTask(getApplicationContext(), getIntent()).execute("insert_client");
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    updateUI(user);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.loginFail), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginWithFacebook(@NonNull AccessToken token)
    {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    new DatabaseTask(getApplicationContext(), getIntent()).execute("insert_client");
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    Profile profile = Profile.getCurrentProfile();
                    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
                    ImageLoader im = ImageLoader.getInstance();
                    im.init(config);
                    im.loadImage(profile.getProfilePictureUri(200, 200).toString(), new SimpleImageLoadingListener()
                    {
                        @Override
                        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)
                        {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            FirebaseStorage storage = FirebaseStorage.getInstance();
                            assert user != null;
                            StorageReference p = storage.getReference().child("ProfilePictures/" + user.getUid());
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            loadedImage.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                            byte[] data = byteArrayOutputStream.toByteArray();
                            p.putBytes(data);
                        }
                    });
                    updateUI(user);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, getResources().getString(R.string.loginFail), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginWithGoogle(@NonNull GoogleSignInAccount acct)
    {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    new DatabaseTask(getApplicationContext(), getIntent()).execute("insert_client");
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
                    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
                    ImageLoader im = ImageLoader.getInstance();
                    im.init(config);
                    assert acct != null;
                    im.loadImage(Objects.requireNonNull(acct.getPhotoUrl()).toString(), new SimpleImageLoadingListener()
                    {
                        @Override
                        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)
                        {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            FirebaseStorage storage = FirebaseStorage.getInstance();
                            assert user != null;
                            StorageReference p = storage.getReference().child("ProfilePictures/" + user.getUid());
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            loadedImage.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                            byte[] data = byteArrayOutputStream.toByteArray();
                            p.putBytes(data);
                        }
                    });
                    updateUI(user);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.loginFail), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //</editor-fold>

    //<editor-fold desc="Start Menu activity">
    private void updateUI(FirebaseUser user)
    {
        if (user != null)
        {
            Toast.makeText(LoginActivity.this, getResources().getString(R.string.tLogSuccess) + " " + user.getDisplayName(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(intent);
        }
    }
    //</editor-fold>
}
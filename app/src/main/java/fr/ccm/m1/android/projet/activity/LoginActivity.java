package fr.ccm.m1.android.projet.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import fr.ccm.m1.android.projet.R;
import fr.ccm.m1.android.projet.databinding.ActivityLoginBinding;
import fr.ccm.m1.android.projet.model.Login;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "INFO";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setActivity(this);
        binding.setUserLogin(new Login());
    }

    @Override
    public void onStart() {
        super.onStart();
        goToMenu(mAuth.getCurrentUser());
    }

    private void goToMenu(FirebaseUser user) {
        if(user != null){
            Intent menuActivity = new Intent(LoginActivity.this, MenuActivity.class);
            menuActivity.putExtra("utilisateurId",user.getUid());
            startActivity(menuActivity);
        }
    }

    public void connection(String email,String password){
        if(email == null || password == null || email.isEmpty() || password.isEmpty()){
            Log.d(TAG, "createUserWithEmail:failure");
            Toast.makeText(LoginActivity.this,"email ou mot de passe vide",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(Objects.requireNonNull(email), password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            goToMenu(mAuth.getCurrentUser());
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Email ou mot de passe incorrect",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void enregistrement(String email,String password){
        if(email == null || password == null || email.isEmpty() || password.isEmpty()){
            Log.d(TAG, "createUserWithEmail:failure");
            Toast.makeText(LoginActivity.this,"email ou mot de passe vide",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            goToMenu(mAuth.getCurrentUser());
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "syntaxe email incorrect email déjà utilisée ou mot de passe inférieur à 6 caractères",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
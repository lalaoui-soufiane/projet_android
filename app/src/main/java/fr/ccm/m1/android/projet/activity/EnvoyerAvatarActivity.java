package fr.ccm.m1.android.projet.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.firebase.auth.FirebaseAuth;

import fr.ccm.m1.android.projet.R;
import fr.ccm.m1.android.projet.databinding.ActivityEnvoyerAvatarBinding;

public class EnvoyerAvatarActivity extends AppCompatActivity {
    private String uid, email = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoyer_avatar);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("utilisateurId") && intent.hasExtra("email")) { // vérifie qu'une valeur est associée à la clé “edittext”
                uid = intent.getStringExtra("utilisateurId"); // on récupère la valeur associée à la clé
                email = intent.getStringExtra("email"); // on récupère la valeur associée à la clé
            } else {
                goToLogin();
            }
        }
        ActivityEnvoyerAvatarBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_envoyer_avatar);
        binding.setActivity(this);
        binding.setUsername(email);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goToMenu();
    }

    public void goToMenu() {
        Intent menuActivity = new Intent(EnvoyerAvatarActivity.this, MenuActivity.class);
        menuActivity.putExtra("utilisateurId", uid);
        menuActivity.putExtra("email", email);
        startActivity(menuActivity);
        finish();
    }

    public void goToLogin() {
        FirebaseAuth.getInstance().signOut();
        Intent loginActivity = new Intent(EnvoyerAvatarActivity.this, LoginActivity.class);
        startActivity(loginActivity);
        finish();
    }
}
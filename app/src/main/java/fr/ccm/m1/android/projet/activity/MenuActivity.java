package fr.ccm.m1.android.projet.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import fr.ccm.m1.android.projet.R;
import fr.ccm.m1.android.projet.databinding.ActivityMenuBinding;


public class MenuActivity extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    String uid, email = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("utilisateurId") && intent.hasExtra("email")) { // vérifie qu'une valeur est associée à la clé “edittext”
                uid = intent.getStringExtra("utilisateurId"); // on récupère la valeur associée à la clé
                email = intent.getStringExtra("email"); // on récupère la valeur associée à la clé
            } else {
                goToLogin();
            }
        }
        ActivityMenuBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        binding.setActivity(this);
        binding.setUsername(email);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    public void goToLocalisationAvatar(){
        Intent menuActivity = new Intent(MenuActivity.this, AvatarLocalisationActivity.class);
        menuActivity.putExtra("utilisateurId",uid);
        menuActivity.putExtra("email",email);
        startActivity(menuActivity);
        finish();
    }

    public void goToAvatarSurMonTel(){
        Intent menuActivity = new Intent(MenuActivity.this, AvatarsSurMonTelActivity.class);
        menuActivity.putExtra("utilisateurId",uid);
        menuActivity.putExtra("email",email);
        startActivity(menuActivity);
        finish();
    }

    public void goToConfigAvatar(){
        Intent menuActivity = new Intent(MenuActivity.this, ConfigAvatarActivity.class);
        menuActivity.putExtra("utilisateurId",uid);
        menuActivity.putExtra("email",email);
        startActivity(menuActivity);
        finish();
    }

    public void goToHistoriqueVoyages(){
        Intent menuActivity = new Intent(MenuActivity.this, HistoriqueVoyagesActivity.class);
        menuActivity.putExtra("utilisateurId",uid);
        menuActivity.putExtra("email",email);
        startActivity(menuActivity);
        finish();
    }

    public void goToRamenerAvatar(){
        Intent menuActivity = new Intent(MenuActivity.this, RamenerAvatarActivity.class);
        menuActivity.putExtra("utilisateurId",uid);
        menuActivity.putExtra("email",email);
        startActivity(menuActivity);
        finish();
    }

    public void goToEnvoyerAvatar(){
        Intent menuActivity = new Intent(MenuActivity.this, EnvoyerAvatarActivity.class);
        menuActivity.putExtra("utilisateurId",uid);
        menuActivity.putExtra("email",email);
        startActivity(menuActivity);
        finish();
    }

    public void goToLogin() {
        FirebaseAuth.getInstance().signOut();
        Intent loginActivity = new Intent(MenuActivity.this, LoginActivity.class);
        startActivity(loginActivity);
        finish(); //Stops the current activity
    }
}


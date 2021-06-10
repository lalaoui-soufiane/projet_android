package fr.ccm.m1.android.projet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import fr.ccm.m1.android.projet.R;
import fr.ccm.m1.android.projet.databinding.ActivityAvatarsSurMonTelBinding;

public class AvatarsSurMonTelActivity extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatars_sur_mon_tel);
        if(mAuth.getCurrentUser() == null){
            goToLogin();
        }else {


            ActivityAvatarsSurMonTelBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_avatars_sur_mon_tel);
            binding.setActivity(this);
            binding.setUsername(mAuth.getCurrentUser().getEmail());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goToMenu();
    }

    public void goToMenu() {
        Intent menuActivity = new Intent(AvatarsSurMonTelActivity.this, MenuActivity.class);
        startActivity(menuActivity);
        finish();
    }

    public void goToLogin() {
        FirebaseAuth.getInstance().signOut();
        Intent loginActivity = new Intent(AvatarsSurMonTelActivity.this, LoginActivity.class);
        startActivity(loginActivity);
        finish();
    }
}
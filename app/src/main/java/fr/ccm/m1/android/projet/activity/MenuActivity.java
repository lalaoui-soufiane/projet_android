package fr.ccm.m1.android.projet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;

import fr.ccm.m1.android.projet.R;
import fr.ccm.m1.android.projet.firebaseService.AvatarService;
import fr.ccm.m1.android.projet.firebaseService.UtilisateurService;


public class MenuActivity extends AppCompatActivity {
    private AvatarService avatarService;
    private UtilisateurService utilisateurService;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }
}
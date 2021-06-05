package fr.ccm.m1.android.projet.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

import fr.ccm.m1.android.projet.R;
import fr.ccm.m1.android.projet.databinding.ActivityLoginBinding;
import fr.ccm.m1.android.projet.firebaseService.AvatarService;
import fr.ccm.m1.android.projet.firebaseService.LocalisationService;
import fr.ccm.m1.android.projet.firebaseService.UtilisateurService;
import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Localisation;
import fr.ccm.m1.android.projet.model.Login;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "INFO";
    private FirebaseAuth mAuth;
    private AvatarService avatarService;
    private LocalisationService localisationService;
    private UtilisateurService utilisateurService;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FusedLocationProviderClient fusedLocationProviderClient;
    private static final int PERMS_CALL_ID = 200;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setActivity(this);
        binding.setUserLogin(new Login());
        utilisateurService = new UtilisateurService(db);
        avatarService = new AvatarService(db);
        localisationService = new LocalisationService(db);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        checkPermission();
    }
    private void checkPermission(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            },PERMS_CALL_ID);
        }else {
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                setLocation(location);
                                Toast.makeText(LoginActivity.this,"longitude: "+location.getLongitude()+", latitude: "+ location.getLatitude(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        checkPermission();
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        if(mAuth.getCurrentUser() != null){
//            goToMenu(mAuth.getCurrentUser());
//        }
//    }

    private void goToMenu(FirebaseUser user) {
        if(user != null){
            Intent menuActivity = new Intent(LoginActivity.this, MenuActivity.class);
            menuActivity.putExtra("utilisateurId",user.getUid());
            menuActivity.putExtra("email",user.getEmail());
            startActivity(menuActivity);
        }
    }

    public void connection(String email,String password){
        if(email == null || password == null || email.isEmpty() || password.isEmpty()){
            Log.d(TAG, "createUserWithEmail:failure");
            Toast.makeText(LoginActivity.this,"email ou mot de passe vide",Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(Objects.requireNonNull(email), password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "signInWithEmail:success");
                        goToMenu(mAuth.getCurrentUser());
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(LoginActivity.this, "Email ou mot de passe incorrect",
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void enregistrement(String email, String password){
        if(getLocation() == null){
            Toast.makeText(LoginActivity.this,"Veuillez activer vos données de localisation",Toast.LENGTH_LONG).show();
        }
        if(email == null || password == null || email.isEmpty() || password.isEmpty()){
            Log.d(TAG, "createUserWithEmail:failure");
            Toast.makeText(LoginActivity.this,"email ou mot de passe vide",Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        if (mAuth.getCurrentUser() != null) {
                            Localisation localisation = localisationService.createLocalisation(mAuth.getCurrentUser(),getLocation());
                            Avatar avatar = avatarService.createAvatar(mAuth.getCurrentUser(),localisation);
                            utilisateurService.createUser(mAuth.getCurrentUser(),localisation,avatar);
                        }
                        goToMenu(mAuth.getCurrentUser());
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(LoginActivity.this, "syntaxe email incorrect email déjà utilisée ou mot de passe inférieur à 6 caractères",
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
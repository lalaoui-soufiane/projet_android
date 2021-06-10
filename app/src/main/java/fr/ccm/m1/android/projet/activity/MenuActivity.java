package fr.ccm.m1.android.projet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import fr.ccm.m1.android.projet.R;
import fr.ccm.m1.android.projet.databinding.ActivityMenuBinding;
import fr.ccm.m1.android.projet.firebaseService.AvatarService;
import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Localisation;


public class MenuActivity extends AppCompatActivity {
    private static final String TAG = "MENU ACTIVITY";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private AvatarService avatarService = AvatarService.getInstance();
    private Avatar avatar = new Avatar();
    private Localisation localisation= new Localisation();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        if(mAuth.getCurrentUser() == null){
            goToLogin();
        }else {
            ActivityMenuBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
            binding.setActivity(this);
            binding.setUsername(mAuth.getCurrentUser().getEmail());
            createAvatarListener();
        }

    }
    public void createAvatarListener(){
        final DocumentReference docRef = db.collection("avatars").document(mAuth.getCurrentUser().getUid());
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w( "Listen failed.", e);
                    return;
                }
                if (snapshot != null && snapshot.exists()) {
                    setAvatar(snapshot.toObject(Avatar.class));
                    recupereAvatarLoCalisation(avatar.getDerniereLocalisationId());
                }
            }
        });
    }
    public void recupereAvatarLoCalisation(String localisationId){
        DocumentReference docRef = db.collection("localisation").document(localisationId);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        setLocalisation(document.toObject(Localisation.class));
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() == null){
            goToLogin();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    public void createAvatarLocationListener(){
        //todo
    }

    public void goToAvatarSurMonTel(){
        Intent menuActivity = new Intent(MenuActivity.this, AvatarsSurMonTelActivity.class);
        startActivity(menuActivity);
        finish();
    }

    public void goToConfigAvatar(){
        Intent menuActivity = new Intent(MenuActivity.this, ConfigAvatarActivity.class);
        startActivity(menuActivity);
        finish();
    }

    public void goToHistoriqueVoyages(){
        Intent menuActivity = new Intent(MenuActivity.this, HistoriqueVoyagesActivity.class);
        startActivity(menuActivity);
        finish();
    }

    public void goToLogin() {
        FirebaseAuth.getInstance().signOut();
        Intent loginActivity = new Intent(MenuActivity.this, LoginActivity.class);
        startActivity(loginActivity);
        finish(); //Stops the current activity
    }

    public void envoyerAvatar(){
        //todo
    }
    public void ramenerAvatar(){
        //todo
    }

    //region getters and setters

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }


    //endregion

}


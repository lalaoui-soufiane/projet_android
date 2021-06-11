package fr.ccm.m1.android.projet.activity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.List;

import fr.ccm.m1.android.projet.R;
import fr.ccm.m1.android.projet.databinding.ActivityMenuBinding;
import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Localisation;


public class MenuActivity extends AppCompatActivity {
    private static final String TAG = "MENU ACTIVITY";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private Avatar avatar = new Avatar();
    public final ObservableField<String>  localisationAdresse = new ObservableField<>();
    public final ObservableField<String>  enVoyage = new ObservableField<>();

    public MenuActivity() {
    }


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
                    enVoyage.set(getAvatar().isEnVoyage() ? "Oui" : "Non");
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
                        Localisation localisation = document.toObject(Localisation.class);
                        localisationAdresse.set(localisation.getAdresseDetail());
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
        }else{
            createAvatarListener();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
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





    //endregion

}


package fr.ccm.m1.android.projet.firebaseService;

import android.location.Location;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.LocalDateTime;

import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Localisation;

public class LocalisationService {

    FirebaseFirestore db;
    public LocalisationService(FirebaseFirestore db) {
        this.db=db;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Localisation createLocalisation(FirebaseUser user, Location location) {
        Localisation localisation = new Localisation();
        localisation.setDate(LocalDateTime.now());
        localisation.setReferenceUtilisateurId(user.getUid());
        localisation.setLongitude(location.getLongitude());
        localisation.setLatitude(location.getLatitude());
        DocumentReference newLocalisationRef = db.collection("localisation").document();
        localisation.setLocalisationId(newLocalisationRef.getId());
        newLocalisationRef.set(localisation.toDocumentMap());
        return localisation;
    }
}

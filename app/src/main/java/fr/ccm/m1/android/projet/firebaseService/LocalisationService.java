package fr.ccm.m1.android.projet.firebaseService;

import android.location.Geocoder;
import android.location.Location;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Localisation;

public class LocalisationService {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public LocalisationService(){}

    private static LocalisationService INSTANCE = new LocalisationService();
    public static LocalisationService getInstance()
    {
        return INSTANCE;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Localisation createLocalisation(FirebaseUser user, Location location) {
        Localisation localisation = new Localisation();
        localisation.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd")));
        localisation.setReferenceUtilisateurId(user.getUid());
        if (location != null){
            localisation.setLatitude(location.getLatitude());
            localisation.setLongitude(location.getLatitude());
        }
        DocumentReference newLocalisationRef = db.collection("localisation").document();
        localisation.setLocalisationId(newLocalisationRef.getId());
        newLocalisationRef.set(localisation);
        return localisation;
    }
}

package fr.ccm.m1.android.projet.firebaseService;

import com.google.firebase.firestore.FirebaseFirestore;

public class
LocalisationService {
    private FirebaseFirestore db;

    public LocalisationService(FirebaseFirestore db) {
        this.db = db;
    }
}

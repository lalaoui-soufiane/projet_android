package fr.ccm.m1.android.projet.firebaseService;

import com.google.firebase.firestore.FirebaseFirestore;

public class VoyageService {

    private FirebaseFirestore db;

    public VoyageService(FirebaseFirestore db) {
        this.db = db;
    }
}

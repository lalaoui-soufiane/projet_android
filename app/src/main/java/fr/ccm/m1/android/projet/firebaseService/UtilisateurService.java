package fr.ccm.m1.android.projet.firebaseService;

import com.google.firebase.firestore.FirebaseFirestore;

public class UtilisateurService {

    private FirebaseFirestore db;

    public UtilisateurService(FirebaseFirestore db) {
        this.db = db;
    }
}

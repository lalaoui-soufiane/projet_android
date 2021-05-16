package fr.ccm.m1.android.projet.firebaseService;

import com.google.firebase.firestore.FirebaseFirestore;

public class AvatarService {

    private FirebaseFirestore db;

    public AvatarService(FirebaseFirestore db) {
        this.db = db;
    }
}

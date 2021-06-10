package fr.ccm.m1.android.projet.firebaseService;

import com.google.firebase.firestore.FirebaseFirestore;

public class VoyageService {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    public VoyageService() {}
    private static VoyageService INSTANCE = new VoyageService();
    public static VoyageService getInstance()
    {
        return INSTANCE;
    }
}

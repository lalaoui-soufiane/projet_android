package fr.ccm.m1.android.projet.firebaseService;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Localisation;

public class AvatarService {

    private FirebaseFirestore db;

    public AvatarService(FirebaseFirestore db) {
        this.db = db;
    }
    public Avatar createAvatar(FirebaseUser user, Localisation localisation) {
        Avatar avatar = new Avatar();
        avatar.setEnVoyage(false);
        avatar.setDerniereLocalisation(localisation);
        db.collection("avatars").document(user.getUid()).set(avatar.toDocumentMap());
        return avatar;
    }
}

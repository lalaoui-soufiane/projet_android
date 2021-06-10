package fr.ccm.m1.android.projet.firebaseService;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.firestore.FirebaseFirestore;

import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Localisation;

public class AvatarService {

    private static final String TAG = "Avatar service :";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private static AvatarService INSTANCE = new AvatarService();
    public static AvatarService getInstance()
    {   return INSTANCE;
    }
    public AvatarService() {}
    public Avatar createAvatar(FirebaseUser user, Localisation localisation) {
        Avatar avatar = new Avatar();
        avatar.setEnVoyage(false);
        avatar.setDerniereLocalisationId(localisation.getLocalisationId());
        db.collection("avatars").document(user.getUid()).set(avatar);
        return avatar;
    }
}

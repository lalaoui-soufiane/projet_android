package fr.ccm.m1.android.projet.firebaseService;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fr.ccm.m1.android.projet.model.Avatar;

public class AvatarService {

    private DatabaseReference db;

    public AvatarService(FirebaseDatabase db) {
        this.db = db.getReference("avatars");
    }
    public Avatar createAvatar(FirebaseUser user) {
        Avatar avatar = new Avatar();
        avatar.setEnVoyage(false);
        db.child(user.getUid()).setValue(avatar);
        return avatar;
    }
}

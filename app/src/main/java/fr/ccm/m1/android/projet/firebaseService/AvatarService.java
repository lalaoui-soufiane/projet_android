package fr.ccm.m1.android.projet.firebaseService;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import fr.ccm.m1.android.projet.model.Avatar;

public class AvatarService {

    private DatabaseReference db;

    public AvatarService(DatabaseReference db) {
        this.db = db;
    }
    public Avatar creatAvatar(FirebaseUser user) {
        Avatar avatar = new Avatar();
        db.child("avatar").child(user.getUid()).setValue(avatar);
        return avatar;
    }
}

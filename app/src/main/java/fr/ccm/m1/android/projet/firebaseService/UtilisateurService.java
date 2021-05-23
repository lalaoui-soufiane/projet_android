package fr.ccm.m1.android.projet.firebaseService;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Utilisateur;

public class UtilisateurService {

    private DatabaseReference db ;

    public UtilisateurService(DatabaseReference db) {
        this.db = db;
    }
    public Utilisateur createUser(FirebaseUser user, Avatar avatar) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(user.getEmail());
        utilisateur.setAvatarUtilisateur(avatar);
        db.child("users").child(user.getUid()).setValue(utilisateur);
        return utilisateur;
    }
}

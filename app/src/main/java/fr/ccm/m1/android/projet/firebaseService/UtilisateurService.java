package fr.ccm.m1.android.projet.firebaseService;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Utilisateur;

public class UtilisateurService {

    private DatabaseReference db ;

    public UtilisateurService(FirebaseDatabase db) {
        this.db = db.getReference("users");
    }
    public Utilisateur createUser(FirebaseUser user) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(user.getEmail());
        //utilisateur.setDerniereLocalisation();
        db.child(user.getUid()).setValue(utilisateur);
        return utilisateur;
    }
}

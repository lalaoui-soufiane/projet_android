package fr.ccm.m1.android.projet.firebaseService;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Localisation;
import fr.ccm.m1.android.projet.model.Utilisateur;


public class UtilisateurService {

    private FirebaseFirestore db ;

    public UtilisateurService(FirebaseFirestore db) {
        this.db = db;
    }


    public Utilisateur createUser(FirebaseUser user, Localisation localisation, Avatar avatar) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(user.getEmail());
        utilisateur.setDerniereLocalisation(localisation);
        utilisateur.setAvatarUtilisateur(avatar);
        db.collection("utilisateurs").document(user.getUid()).set(utilisateur.toDocumentMap());
        return utilisateur;
    }
}

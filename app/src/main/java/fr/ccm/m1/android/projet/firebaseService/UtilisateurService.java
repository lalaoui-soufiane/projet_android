package fr.ccm.m1.android.projet.firebaseService;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import fr.ccm.m1.android.projet.model.Avatar;
import fr.ccm.m1.android.projet.model.Localisation;
import fr.ccm.m1.android.projet.model.Utilisateur;


public class UtilisateurService {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    public UtilisateurService() {}
    private static UtilisateurService INSTANCE = new UtilisateurService();
    public static UtilisateurService getInstance()
    {
        return INSTANCE;
    }


    public Utilisateur createUser(FirebaseUser user, Localisation localisation, Avatar avatar) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(user.getEmail());
        utilisateur.setDerniereLocalisationId(localisation.getLocalisationId());
        db.collection("utilisateurs").document(user.getUid()).set(utilisateur);
        return utilisateur;
    }
}

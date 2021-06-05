package fr.ccm.m1.android.projet.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utilisateur {

    // region attributs
    private String id;
    private String nom;
    private Localisation derniereLocalisation;
    private Avatar avatarUtilisateur;
    private List<Avatar> avatarInviteListe;
    private int minimumFrequenceCollecteLocalisation;
    // endregion

    //region methodes
    public Map<String, Object> toDocumentMap(){
        Map<String,Object> document = new HashMap<>();
        document.put("nom",nom);
        document.put("minimumFrequenceCollecteLocalisation",minimumFrequenceCollecteLocalisation);
        if(derniereLocalisation != null){
            document.put("derniereLocalisationId",derniereLocalisation.getLocalisationId());
        }else{
            document.put("derniereLocalisationId",0);
        }
        if(avatarInviteListe != null){
            document.put("avatarInviteListe", avatarInviteListe.stream().map(Avatar::getId).collect(Collectors.toList()));
        }
        document.put("minimumFrequenceCollecteLocalisation", minimumFrequenceCollecteLocalisation);
        return document;
    }
    //endregion


    //region getters and setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Localisation getDerniereLocalisation() {
        return derniereLocalisation;
    }

    public void setDerniereLocalisation(Localisation derniereLocalisation) {
        this.derniereLocalisation = derniereLocalisation;
    }

    public Avatar getAvatarUtilisateur() {
        return avatarUtilisateur;
    }

    public void setAvatarUtilisateur(Avatar avatarUtilisateur) {
        this.avatarUtilisateur = avatarUtilisateur;
    }

    public List<Avatar> getAvatarInviteListe() {
        return avatarInviteListe;
    }

    public void setAvatarInviteListe(List<Avatar> avatarInviteListe) {
        this.avatarInviteListe = avatarInviteListe;
    }

    public int getMinimumFrequenceCollecteLocalisation() {
        return minimumFrequenceCollecteLocalisation;
    }

    public void setMinimumFrequenceCollecteLocalisation(int minimumFrequenceCollecteLocalisation) {
        this.minimumFrequenceCollecteLocalisation = minimumFrequenceCollecteLocalisation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    //endregion



}

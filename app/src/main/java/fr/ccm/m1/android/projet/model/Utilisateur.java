package fr.ccm.m1.android.projet.model;

import java.util.List;

public class Utilisateur {

    // region attributs

    private String nom;
    private Localisation derniereLocalisation;
    private Avatar avatarUtilisateur;
    private List<Avatar> avatarInviteListe;
    private int minimumFrequenceCollecteLocalisation;

    // endregion


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

    //endregion



}

package fr.ccm.m1.android.projet.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utilisateur {

    // region attributs
    private String nom;
    private String derniereLocalisationId;
    private List<Avatar> avatarInviteListe;
    private int minimumFrequenceCollecteLocalisation;
    // endregion

    //region methodes

    //endregion


    //region getters and setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDerniereLocalisationId() {
        return derniereLocalisationId;
    }

    public void setDerniereLocalisationId(String derniereLocalisationId) {
        this.derniereLocalisationId = derniereLocalisationId;
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

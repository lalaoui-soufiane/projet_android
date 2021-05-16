package fr.ccm.m1.android.projet.model;

import java.time.LocalDateTime;

public class Localisation {

    //region attribut

    private int localisationId;
    private Utilisateur referenceUtilisateur;
    private LocalDateTime date;
    private float longitude;
    private float latitude;
    //endregion

    //region getters and setters

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getLocalisationId() {
        return localisationId;
    }

    public void setLocalisationId(int localisationId) {
        this.localisationId = localisationId;
    }

    public Utilisateur getReferenceUtilisateur() {
        return referenceUtilisateur;
    }

    public void setReferenceUtilisateur(Utilisateur referenceUtilisateur) {
        this.referenceUtilisateur = referenceUtilisateur;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    //endregion
}

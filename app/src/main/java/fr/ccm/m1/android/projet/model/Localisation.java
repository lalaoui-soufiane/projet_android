package fr.ccm.m1.android.projet.model;

import android.location.Location;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Localisation {

    //region attribut

    private String localisationId;
    private String referenceUtilisateurId;
    private String date;
    private double longitude;
    private double latitude;
    private String adresse;
    //endregion

    //region getters and setters


    public String getLocalisationId() {
        return localisationId;
    }

    public void setLocalisationId(String localisationId) {
        this.localisationId = localisationId;
    }

    public String getReferenceUtilisateurId() {
        return referenceUtilisateurId;
    }

    public void setReferenceUtilisateurId(String referenceUtilisateurId) {
        this.referenceUtilisateurId = referenceUtilisateurId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    //endregion


}

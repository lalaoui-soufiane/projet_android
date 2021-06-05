package fr.ccm.m1.android.projet.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Localisation {

    //region attribut

    private String localisationId;
    private String referenceUtilisateurId;
    private LocalDateTime date;
    private double longitude;
    private double latitude;
    //endregion

    //region getters and setters

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    //endregion

    //region methodes
    public Map<String, Object> toDocumentMap(){
        Map<String,Object> document = new HashMap<>();
        document.put("referenceUtilisateurId",referenceUtilisateurId);
        document.put("date",date);
        document.put("longitude",longitude);
        document.put("latitude",latitude);
        return document;
    }
    //endregion
}

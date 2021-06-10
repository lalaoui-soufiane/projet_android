package fr.ccm.m1.android.projet.model;

import androidx.databinding.BaseObservable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avatar extends BaseObservable {


    public Avatar() {}

    //region attribut
    private String utilisateurDuTelephoneId;
    private String derniereLocalisationId;
    private boolean enVoyage;
    private Voyage voyageEnCours;
    private List<Voyage> historiqueDesVoyages;
    private int tempsDuVoyage; // en minutes
    private int tempsSurUnTelephone; // en minutes
    private int distanceDuVoyage; //en mètres
    private int distanceSurUnTelephone; //en mètres
    private int frequenceCollecteLocalisation; //en minutes
    //endregion


    //region getters and setters


    public String getUtilisateurDuTelephoneId() {
        return utilisateurDuTelephoneId;
    }

    public void setUtilisateurDuTelephoneId(String utilisateurDuTelephoneId) {
        this.utilisateurDuTelephoneId = utilisateurDuTelephoneId;
    }

    public boolean isEnVoyage() {
        return enVoyage;
    }

    public void setEnVoyage(boolean enVoyage) {
        this.enVoyage = enVoyage;
    }

    public Voyage getVoyageEnCours() {
        return voyageEnCours;
    }

    public void setVoyageEnCours(Voyage voyageEnCours) {
        this.voyageEnCours = voyageEnCours;
    }

    public List<Voyage> getHistoriqueDesVoyages() {
        return historiqueDesVoyages;
    }

    public void setHistoriqueDesVoyages(List<Voyage> historiqueDesVoyages) {
        this.historiqueDesVoyages = historiqueDesVoyages;
    }

    public int getTempsDuVoyage() {
        return tempsDuVoyage;
    }

    public void setTempsDuVoyage(int tempsDuVoyage) {
        this.tempsDuVoyage = tempsDuVoyage;
    }

    public int getTempsSurUnTelephone() {
        return tempsSurUnTelephone;
    }

    public void setTempsSurUnTelephone(int tempsSurUnTelephone) {
        this.tempsSurUnTelephone = tempsSurUnTelephone;
    }

    public int getDistanceDuVoyage() {
        return distanceDuVoyage;
    }

    public void setDistanceDuVoyage(int distanceDuVoyage) {
        this.distanceDuVoyage = distanceDuVoyage;
    }

    public int getDistanceSurUnTelephone() {
        return distanceSurUnTelephone;
    }

    public void setDistanceSurUnTelephone(int distanceSurUnTelephone) {
        this.distanceSurUnTelephone = distanceSurUnTelephone;
    }

    public int getFrequenceCollecteLocalisation() {
        return frequenceCollecteLocalisation;
    }

    public void setFrequenceCollecteLocalisation(int frequenceCollecteLocalisation) {
        this.frequenceCollecteLocalisation = frequenceCollecteLocalisation;
    }

    public String getDerniereLocalisationId() {
        return derniereLocalisationId;
    }

    public void setDerniereLocalisationId(String derniereLocalisationId) {
        this.derniereLocalisationId = derniereLocalisationId;
    }

    //endregion
}

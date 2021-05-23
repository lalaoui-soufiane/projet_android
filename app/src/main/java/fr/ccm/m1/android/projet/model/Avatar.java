package fr.ccm.m1.android.projet.model;

import androidx.databinding.BaseObservable;

import java.util.List;

public class Avatar extends BaseObservable {

    //region attribut

    private Utilisateur telephoneUtilisateur;
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

    public Utilisateur getTelephoneUtilisateur() {
        return telephoneUtilisateur;
    }

    public void setTelephoneUtilisateur(Utilisateur telephoneUtilisateur) {
        this.telephoneUtilisateur = telephoneUtilisateur;
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


    //endregion
}

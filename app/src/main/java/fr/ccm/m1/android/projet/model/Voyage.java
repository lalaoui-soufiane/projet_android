package fr.ccm.m1.android.projet.model;

import java.util.List;

public class Voyage{

    //region attribut

    private int idVoyage;
    private List<Localisation> trajet;

    //endregion

    //region getters and setters

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }


    public List<Localisation> getTrajet() {
        return trajet;
    }

    public void setTrajet(List<Localisation> trajet) {
        this.trajet = trajet;
    }


    //endregion
}

package fr.ccm.m1.android.projet.model;

import java.util.List;

public class Voyage{

    //region attribut

    private int voyageId;
    private List<Localisation> trajet;

    //endregion

    //region getters and setters


    public int getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(int voyageId) {
        this.voyageId = voyageId;
    }

    public List<Localisation> getTrajet() {
        return trajet;
    }

    public void setTrajet(List<Localisation> trajet) {
        this.trajet = trajet;
    }


    //endregion
}

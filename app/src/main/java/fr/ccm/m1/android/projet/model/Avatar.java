package fr.ccm.m1.android.projet.model;

import androidx.databinding.BaseObservable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avatar extends BaseObservable {

    //region attribut
    private String id; // id de son proprietaire
    private Utilisateur utilisateurDuTelephone;
    private Localisation derniereLocalisation;
    private boolean enVoyage;
    private Voyage voyageEnCours;
    private List<Voyage> historiqueDesVoyages;
    private int tempsDuVoyage; // en minutes
    private int tempsSurUnTelephone; // en minutes
    private int distanceDuVoyage; //en mètres
    private int distanceSurUnTelephone; //en mètres
    private int frequenceCollecteLocalisation; //en minutes
    //endregion

    //region methodes
    public Map<String, Object> toDocumentMap(){
        Map<String,Object> document = new HashMap<>();
        if(utilisateurDuTelephone != null){
            document.put("utilisateurDuTelephoneId",utilisateurDuTelephone.getId());
        }else{
            document.put("utilisateurDuTelephoneId",null);
        }
        if(derniereLocalisation != null){
            document.put("derniereLocalisationId",derniereLocalisation.getLocalisationId());
        }else {
            document.put("derniereLocalisationId",null);
        }
        document.put("enVoyage",enVoyage);
        document.put("tempsDuVoyage",tempsDuVoyage);
        document.put("tempsSurUnTelephone",tempsSurUnTelephone);
        document.put("distanceDuVoyage",distanceDuVoyage);
        document.put("distanceSurUnTelephone",distanceSurUnTelephone);
        document.put("frequenceCollecteLocalisation",frequenceCollecteLocalisation);
        return document;
    }
    //endregion

    //region getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Utilisateur getUtilisateurDuTelephone() {
        return utilisateurDuTelephone;
    }

    public void setUtilisateurDuTelephone(Utilisateur utilisateurDuTelephone) {
        this.utilisateurDuTelephone = utilisateurDuTelephone;
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

    public Localisation getDerniereLocalisation() {
        return derniereLocalisation;
    }

    public void setDerniereLocalisation(Localisation derniereLocalisation) {
        this.derniereLocalisation = derniereLocalisation;
    }
//endregion
}

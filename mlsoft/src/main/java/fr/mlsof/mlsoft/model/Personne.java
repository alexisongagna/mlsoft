package fr.mlsof.mlsoft.model;

public class Personne {


    private long id ;


    private String nom ;


    private String prenom ;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return this.getId() + ", " + this.getNom() + ", " + this.getPrenom();
    }
}

package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes;

/**
 * Created by Daisu_000 on 03.07.2017.
 */

public class Material {



    private int bauid;
    private int matid;
    private String materialname;
    private int anzahl;
    private double einzelpreis;
    private double gesamtpreis;

    public int getBauid() {
        return bauid;
    }

    public void setBauid(int bauid) {
        this.bauid = bauid;
    }

    public int getMatid() {
        return matid;
    }

    public void setMatid(int matid) {
        this.matid = matid;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public double getEinzelpreis() {
        return einzelpreis;
    }

    public void setEinzelpreis(double einzelpreis) {
        this.einzelpreis = einzelpreis;
    }

    public double getGesamtpreis() {
        gesamtpreis = getAnzahl() * getEinzelpreis();
        return gesamtpreis;
    }

}

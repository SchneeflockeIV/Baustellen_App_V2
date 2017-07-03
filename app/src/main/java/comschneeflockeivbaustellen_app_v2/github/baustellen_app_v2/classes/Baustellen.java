package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes;

/**
 * Created by Daisu_000 on 03.07.2017.
 */

public class Baustellen {

    private int bauid;
    private String baustellenname;
    private String strasse;
    private String ort;
    private String plz;
    private String bauherr;
    private int baustellenbild;

    public int getBaustellenbild() {
        return baustellenbild;
    }

    public void setBaustellenbild(int baustellenbild) {
        this.baustellenbild = baustellenbild;
    }

    public int getBauId() {
        return bauid;
    }

    public void setBauId(int id) {
        this.bauid = id;
    }

    public String getBaustellenname() {
        return baustellenname;
    }

    public void setBaustellenname(String baustellenname) {
        this.baustellenname = baustellenname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getBauherr() {
        return bauherr;
    }

    public void setBauherr(String bauherr) {
        this.bauherr = bauherr;
    }


}

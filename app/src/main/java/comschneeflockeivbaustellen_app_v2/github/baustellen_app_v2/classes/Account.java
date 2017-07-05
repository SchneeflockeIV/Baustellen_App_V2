package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes;


// Account Klasse um Accounts anlegen zu können
public class Account {

    // Variablen anlegen
    private int id;
    private String benutzerName;
    private String Vorname;
    private String Password;
    private String Telenummer;
    private String Grad;
    private String Anrede;
    private String Nachname;

    // Getter, Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBenutzerName() {
        return benutzerName;
    }

    public void setBenutzerName(String benutzerName) {
        this.benutzerName = benutzerName;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTelenummer() {
        return Telenummer;
    }

    public void setTelenummer(String telenummer) {
        Telenummer = telenummer;
    }

    public String getGrad() {
        return Grad;
    }

    public void setGrad(String grad) {
        Grad = grad;
    }

    public String getAnrede() {
        return Anrede;
    }

    public void setAnrede(String anrede) {
        Anrede = anrede;
    }






}

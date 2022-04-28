package oslomet.webprog.ukeoppgaver.model;

public class Bruker {

    private String brukernavn;
    private String passord;
    private int admin;

    public Bruker(String brukernavn, String passord, int admin) {
        this.brukernavn = brukernavn;
        this.passord = passord;
        this.admin = admin;
    }

    public Bruker() {
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}

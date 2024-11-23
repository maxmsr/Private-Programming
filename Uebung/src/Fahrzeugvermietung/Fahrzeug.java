package Fahrzeugvermietung;

public class Fahrzeug {
    private int kennzeichen;
    private String modell;
    private int mietpreis;

    public Fahrzeug(int kennzeichen, String modell, int mietpreis) {
        this.kennzeichen = kennzeichen;
        this.modell = modell;
        mietpreis = mietpreis;
    }

    public int getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(int kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getMietpreis() {
        return mietpreis;
    }

    public void setMietpreis(int mietpreis) {
        mietpreis = mietpreis;
    }
}

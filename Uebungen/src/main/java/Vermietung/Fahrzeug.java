package Vermietung;

public class Fahrzeug {
    private String kennzeichen;
    private String modell;
    private int baujahr;
    private double tagespreis;
    private int kilometerstand;
    private boolean verfügbar;

    public Fahrzeug(String kennzeichen, String modell, int baujahr, double tagespreis, int kilometerstand, boolean verfügbar) {
        this.kennzeichen = kennzeichen;
        this.modell = modell;
        this.baujahr = baujahr;
        this.tagespreis = tagespreis;
        this.kilometerstand = kilometerstand;
        this.verfügbar = verfügbar;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public double getTagespreis() {
        return tagespreis;
    }

    public void setTagespreis(double tagespreis) {
        this.tagespreis = tagespreis;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }

    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
    }

    public boolean isVerfügbar() {
        return verfügbar;
    }

    public void setVerfügbar(boolean verfügbar) {
        this.verfügbar = verfügbar;
    }

    @Override
    public String toString() {
        return "Fahrzeug{" +
                "kennzeichen='" + kennzeichen + '\'' +
                ", modell='" + modell + '\'' +
                ", baujahr=" + baujahr +
                ", tagespreis=" + tagespreis +
                ", kilometerstand=" + kilometerstand +
                ", verfügbar=" + verfügbar +
                '}';
    }
}

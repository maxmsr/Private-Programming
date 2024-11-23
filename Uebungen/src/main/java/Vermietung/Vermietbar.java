package Vermietung;

public interface Vermietbar {
    void vermieten(int von, int bis, Kunde kunde);
    void zurückgeben(int neuerKilometer);
    void prüfeVerfügbarkeit(int von, int bis);
    void berechePreis(int tage, int kilometer);
}

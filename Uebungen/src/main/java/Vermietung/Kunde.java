package Vermietung;

public class Kunde {
    private String name;
    private int führerscheinummer;

    public Kunde(String name, int führerscheinummer) {
        this.name = name;
        this.führerscheinummer = führerscheinummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFührerscheinummer() {
        return führerscheinummer;
    }

    public void setFührerscheinummer(int führerscheinummer) {
        this.führerscheinummer = führerscheinummer;
    }

    @Override
    public String toString() {
        return "Kunde: " +
                "name='" + name + '\'' +
                ", führerscheinummer=" + führerscheinummer;
    }
}

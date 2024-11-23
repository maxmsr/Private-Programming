package Vermietung;

import Prog1tools.IOTools;

public class Main {
    public static void main(String[] args){


        String art = IOTools.readString("Hallo ,was möchtest du ausleihen? ");

        if (art.equals("LKW") || art.equals("lkw")){
            LKW lkw = new LKW(IOTools.readString("Wie lautet das Kennzeichen: "), IOTools.readString("Welches Modell? "), IOTools.readInt("Zu welchem mitpreis: "),);
        } else if (art.equals("PKW") || art.equals("pkw")) {
            PKW pkw = new PKW(IOTools.readString("Wie lautet das Kennzeichen: "), IOTools.readString("Welches Modell? "), IOTools.readInt("Zu welchem mitpreis: "));
        } else if (art.equals("Motorrad") || art.equals(",otorrad")) {
        Motorrad mot = new Motorrad(IOTools.readString("Wie lautet das Kennzeichen: "), IOTools.readString("Welches Modell? "), IOTools.readInt("Zu welchem mitpreis: "));
        }



    }
}
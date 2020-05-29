import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {

    public static void main(String arg[])
    {
        ArrayList<Stap> alleNodes = new ArrayList<>();

        // maak de nodes, en leg basis connecties.
        //nederland is vrij bereikbaar door heel europa heen, en mijn meeste destinations zullen in europa zijn.
        Stap schipholAirport = new Vlucht("schipholAirport"); // is het mogenlijk de naam schiphol airport door middel van reflection misschien aan te roepen? Continue een variable "naam" maken vind ik erg onhandig...
        Stap schipholTreinstation = new Treinrit("schipholTreinstation");
        Stap schipholParking = new Rit("schipholParking");

        //duitsland vrij bereikbaar
        Vlucht berlinAirport = new Vlucht("berlinAirport");
        Treinrit berlinTreinstation = new Treinrit("berlinTreinstation");
        Rit berlinParking = new Rit("berlinParking");

        //zwitserland vrij bereikbaar, maar helaas zijn de airport en het treinstation gesloten ivm corona.
        Rit geneveParking = new Rit("geneveParking");

        //italie is redelijk bereikbaar, maar helaas is de airport gesloten ivm corona.
        Treinrit romeTreinstation = new Treinrit("romeTreinstation");
        Rit romeParking = new Rit("romeParking");

        //engeland is redelijk bereikbaar, maar helaas niet echt te bereiken met de trein.
        Rit londenParking = new Rit("londenParking");
        Vlucht londenAirport = new Vlucht("londenAirport");

        //belgie is vrij bereikbaar, maar helaas niet met de auto ( de boot van engeland telt niet ;) ), want de belgen hadden de weg afgesneden. Ook is de airport dicht ivm corona
        Treinrit brusselTreinstation = new Treinrit("brusselTreinstation");
        Rit brusselParking = new Rit("brusselParking");

        //japan is vrij ver, maar niet te bereiken met de trein of auto.
        Vlucht hanedaAirport = new Vlucht("HanedaAirport");

        // alle "binnenlandse reizen ( overstappen )"
        addWederzijdseConnectie(schipholAirport,schipholTreinstation,0);
        addWederzijdseConnectie(schipholAirport,schipholParking,0);
        addWederzijdseConnectie(schipholParking,schipholTreinstation,0);

        addWederzijdseConnectie(berlinAirport,berlinTreinstation,0);
        addWederzijdseConnectie(berlinAirport,berlinParking,0);
        addWederzijdseConnectie(berlinTreinstation,berlinParking,0);

        addWederzijdseConnectie(romeParking,romeTreinstation,0);

        addWederzijdseConnectie(londenParking,londenAirport,0);

        // alle vlucht connecties
        // nu moet je verplicht overstappen, maar voor een proof of concept is dit prima.
        addWederzijdseConnectie(londenAirport,schipholAirport,90);
        addWederzijdseConnectie(schipholAirport,berlinAirport, 200);
        addWederzijdseConnectie(berlinAirport,hanedaAirport,1000);
        // alle trein ritten
        addWederzijdseConnectie(schipholTreinstation,berlinTreinstation,200);
        addWederzijdseConnectie(schipholTreinstation,brusselTreinstation,100);
        addWederzijdseConnectie(brusselTreinstation,berlinTreinstation,160);
        addWederzijdseConnectie(brusselTreinstation,romeTreinstation,400);
        // alle auto ritten
        addWederzijdseConnectie(schipholParking,berlinParking,200);
        addWederzijdseConnectie(berlinParking,geneveParking,150);
        addWederzijdseConnectie(brusselParking,romeParking,400);
        addWederzijdseConnectie(londenParking,brusselParking,150);
        // voeg alle nodes toe aan een list, zodat ik dit makkelijk aan de graaf kan geven. ( per stad voor overzicht, had ook allemaal tegelijk gekunt maar maak ik sneller fouten!)
        //schiphol
        alleNodes.addAll(Arrays.asList(schipholAirport,schipholParking,schipholTreinstation));

        //berlin
        alleNodes.addAll(Arrays.asList(berlinAirport,berlinParking,berlinTreinstation));

        //brussel
        alleNodes.addAll(Arrays.asList(brusselParking,brusselTreinstation));

        //london
        alleNodes.addAll(Arrays.asList(londenAirport,londenParking));

        //geneve
        alleNodes.addAll(Arrays.asList(geneveParking));

        //rome
        alleNodes.addAll(Arrays.asList(romeParking,romeTreinstation));

        //haneda
        alleNodes.addAll(Arrays.asList(hanedaAirport));


        // ---- Maak een graaf aan die deze nodes bevat, en defineer en beginpunt en eind punt.
        //Drie verschillende reis routes, die ook gelijk berekend worden.
        Graaf coronaReisRoute1 = new Graaf(alleNodes,londenAirport,geneveParking);
        coronaReisRoute1.PrintRoute();
        Graaf coronaReisRoute2 = new Graaf(alleNodes,londenAirport,hanedaAirport);
        coronaReisRoute2.PrintRoute();
        Graaf coronaReisRoute3 = new Graaf(alleNodes,schipholParking,romeTreinstation);
        coronaReisRoute3.PrintRoute();
    }
    public static void addWederzijdseConnectie(Stap a, Stap b,int distance){
        //makkelijke manier om 2 connecties aan elkaar te leggen zonder al teveel duplicate code. ( minder menselijke fouten. )
        //in pricipe is het mogenlijk om een airport aan een station te linken, wat in het echt logisch zou zijn.(overstappen(lopen) kost tijd) In de code houden we alleen hier geen rekening mee.
        // de distance met overstappen is altijd 0, aangezien ik hier geen rekening mee houd.
        a.addConnectie(b,distance);
        b.addConnectie(a,distance);
    }
}

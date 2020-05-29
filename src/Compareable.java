import java.util.ArrayList;
import java.util.Comparator;

public interface Compareable {
    int vliegtuigBias = 1;
    int treinBias = 3; // ik raad aan de getallen in de bias tussen de 0 en +5 te houden, omdat je anders de kans loopt dat je bijvoorbeeld ALLEENMAAR de trein wil nemen, terwijl dit niet altijd kan ( omdat treinreizen bijvoorbeeld je geld kan geven met minder dan -5 bijvoorbeeld.... DUs heen en weer reizen en je reis word HEEL goedkoop...
    int ritBias = 2;
    Comparator<Stap> nodeCompareator = (a, b) -> {
        //aangezien dit redelijk appels met peren vergelijken is, kun je hier onder zelf de ratio's aanpassen, ik zelf heb een heuristiek toegepast die alles terug kan rekenen naar euro's.
        ArrayList<Stap> node= new ArrayList<>();
        node.add(a);
        node.add(b);
                if (a.getConnecties().keySet().contains(b)){
                    if (a.getClass().getName()=="Vlucht") {
                        return (int) (a.getDistance(b)+vliegtuigBias);
                    }
                    if (a.getClass().getName()=="Treinrit") {
                        return (int) (a.getDistance(b)+treinBias);
                    };
                    }
                    if (a.getClass().getName()=="Rit") {
                        return (int) (a.getDistance(b)+ritBias);
                    }

        return 0;};
    }


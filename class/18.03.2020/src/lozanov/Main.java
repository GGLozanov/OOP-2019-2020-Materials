package lozanov;

import lozanov.consts.Notes;
import lozanov.consts.Symptom;
import lozanov.facilities.Cabinet;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        Cabinet doctorCabinet = new Cabinet();
        doctorCabinet.sortByName();

        HashSet<Symptom> symptoms = new HashSet<>(){{
            add(Symptom.TEMPERATURE);
            add(Symptom.COUGH);
            add(Symptom.VOMITING);
        }};  // bad practice: don't often use double-brace initializers due to creation of many anonymous classes and general lack of thread safety

        Notes note = doctorCabinet.getNoted(symptoms);
        System.out.println("Noted for: " + note.name() + " for having " + doctorCabinet.getDoctor().diagnose(symptoms));
    }
}

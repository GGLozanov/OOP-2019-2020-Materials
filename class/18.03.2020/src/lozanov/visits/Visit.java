package lozanov.visits;

import lozanov.consts.Illnesses;
import lozanov.consts.Symptom;

import java.util.HashSet;
import java.util.Set;

public class Visit {
    String name;
    Set<Symptom> symptoms;
    Illnesses note;

    public Visit() {
        Set<Symptom> defaultSymptoms = new HashSet<>();
        defaultSymptoms.add(Symptom.HEADACHE);
        new Visit("Check-up", defaultSymptoms, Illnesses.COMMONDCOLD);
    }

    public Visit(String name, Set<Symptom> symptoms, Illnesses note) {
        this.name = name;
        this.symptoms = symptoms;
        this.note = note;
    }
}

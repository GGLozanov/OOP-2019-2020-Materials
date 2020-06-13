package lozanov.staff;

import lozanov.consts.Illnesses;
import lozanov.consts.Notes;
import lozanov.consts.Symptom;

import java.util.HashSet;
import java.util.Set;

public class Doctor extends MedicalEmployee implements IWriteNoteable {

    final private Set<Symptom> covid19Symptoms = new HashSet<Symptom>();
    final private Set<Symptom> commonColdSymptoms = new HashSet<Symptom>();
    final private Set<Symptom> exhaustionSymptoms = new HashSet<Symptom>();

    private void initCommonColdSymptoms() {
        commonColdSymptoms.add(Symptom.TEMPERATURE);
        commonColdSymptoms.add(Symptom.COUGH);
        commonColdSymptoms.add(Symptom.VOMITING);
    }

    private void initCOVID19Symptoms() {
        covid19Symptoms.add(Symptom.TEMPERATURE);
        covid19Symptoms.add(Symptom.COUGH);
        covid19Symptoms.add(Symptom.HEAVYBREATHING);
    }

    private void initExhaustionSymptoms() {
        exhaustionSymptoms.add(Symptom.HEADACHE);
    }

    public Doctor() {
        super();
        initCommonColdSymptoms();
        initCOVID19Symptoms();
        initExhaustionSymptoms();
    }

    public Doctor(String firstName, String lastName, long workExperience) {
        super(firstName, lastName, workExperience);
        initCommonColdSymptoms();
        initCOVID19Symptoms();
        initExhaustionSymptoms();
    }

    public Illnesses diagnose(Set<Symptom> symptoms) throws Exception {
        if(symptoms.containsAll(covid19Symptoms)) {
            return Illnesses.COVID_19;
        }
        if(symptoms.containsAll(commonColdSymptoms)) {
            return Illnesses.COMMONDCOLD;
        }
        if(symptoms.containsAll(exhaustionSymptoms)) {
            return Illnesses.EXHAUSTION;
        }
        throw new Exception();
    }

    @Override
    public Notes writeNote(Set<Symptom> symptoms) throws Exception {
        Illnesses illness = diagnose(symptoms);
        switch(illness) {
            case COVID_19:
                return Notes.QUARANTINE;
            case COMMONDCOLD:
                return Notes.COLDREX;
            case EXHAUSTION:
                return Notes.SICKLEAVE;
            default: throw new Exception();
        }
    }
}

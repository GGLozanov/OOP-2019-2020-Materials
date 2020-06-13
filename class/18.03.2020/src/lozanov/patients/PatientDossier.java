package lozanov.patients;

import lozanov.visits.Visit;

import java.util.ArrayList;
import java.util.List;

public class PatientDossier {
    Patient patient;
    List<Visit> visits;

    public PatientDossier() {
        this.patient = new Patient();
        List<Visit> visits = new ArrayList<>(1);
        visits.add(new Visit());
        this.visits = visits;
    }

    public PatientDossier(Patient patient, List<Visit> visits) {
        this.patient = patient;
        this.visits = visits;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<Visit> getVisits() {
        return visits;
    }
}

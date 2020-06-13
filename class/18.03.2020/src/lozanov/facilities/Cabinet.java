package lozanov.facilities;

import lozanov.consts.Notes;
import lozanov.consts.Symptom;
import lozanov.consts.VaccineableIllnesses;
import lozanov.patients.PatientDossier;
import lozanov.staff.Nurse;
import lozanov.staff.Doctor;

import java.util.*;

public class Cabinet {
    Doctor doctor;
    Nurse nurse;
    List<PatientDossier> patientDossiers;

    public Doctor getDoctor() {
        return doctor;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public List<PatientDossier> getPatientDossiers() {
        return patientDossiers;
    }

    public Cabinet() {
        this.doctor = new Doctor();
        this.nurse = new Nurse();
        this.patientDossiers = new ArrayList<>(){{
            add(new PatientDossier());
        }};
    }

    public Cabinet(Doctor doctor, Nurse nurse, List<PatientDossier> patientDossiers) {
        this.doctor = doctor;
        this.nurse = nurse;
        this.patientDossiers = patientDossiers;
    }

    public Notes getNoted(Set<Symptom> symptoms) throws Exception {
        return doctor.writeNote(symptoms);
    }

    public void getVaccinated(VaccineableIllnesses illness) {
        nurse.applyVaccine(illness);
    }

    public void sortByName() {
        patientDossiers.sort(new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                return ((PatientDossier) o).getPatient().getFullName().compareTo(((PatientDossier) t1).getPatient().getFullName());
            }
        });
    }

    public void sortByEGN() {
        patientDossiers.sort(new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                return ((PatientDossier) o).getPatient().getEGN().compareTo(((PatientDossier) t1).getPatient().getEGN());
            }
        });
    }

    public void sortByVisits() {
        patientDossiers.sort(new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                return Integer.compare(((PatientDossier) o).getVisits().size(), ((PatientDossier) t1).getVisits().size());
            }
        });
    }
}

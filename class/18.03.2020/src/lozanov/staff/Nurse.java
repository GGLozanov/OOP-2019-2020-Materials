package lozanov.staff;

import lozanov.consts.VaccineableIllnesses;

public class Nurse extends MedicalEmployee implements IVaccineApplicable {

    public Nurse() {
        super();
    }

    public Nurse(String firstName, String lastName, long workExperience) {
        super(firstName, lastName, workExperience);
    }

    @Override
    public void applyVaccine(VaccineableIllnesses vaccineableIllness) {
        vaccineableIllness.applyVaccine();
    }
}

package lozanov.consts;

public enum VaccineableIllnesses {
    FLU, TETANUS;

    public void applyVaccine() {
        System.out.println("Vaccinating for " + name());
    }
}

package lozanov.staff;

import lozanov.consts.Notes;
import lozanov.consts.Symptom;

import java.util.Set;

public interface IWriteNoteable {
    Notes writeNote(Set<Symptom> symptoms) throws Exception;
}

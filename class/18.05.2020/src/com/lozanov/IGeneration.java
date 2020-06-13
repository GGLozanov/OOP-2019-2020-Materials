package com.lozanov;

import java.util.List;

public interface IGeneration<T> {
    void nextGeneration(List<T> generationState);
}

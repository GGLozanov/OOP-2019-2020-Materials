package com.lozanov;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CellularAutomation<T> {
    List<T> generation;
    IRule<T> rule;

    public CellularAutomation() {
        this(new ArrayList<>(), (IRule<T>) new IRule<Boolean>() {
            @Override
            public Boolean rule(Boolean leftElement, Boolean element, Boolean rightElement) {
                return element;
            }
        });
    }

    public CellularAutomation(List<T> generation, IRule<T> rule) {
        this.generation = generation;
        this.rule = rule;
    }

    void run(int iterations, IGeneration<T> afterExecution) {
        System.out.println("Starting field: ");
        generation.forEach(System.out::println);
        for(int i = 0; i< iterations; ++i) {
            generation = generation.stream()
                .map(element -> {
                    final int elementIdx = generation.indexOf(element);
                    final T rightElement = elementIdx == generation.size() ? generation.get(0) : generation.get(elementIdx + 1);
                    final T leftElement = elementIdx == 0 ? generation.get(generation.size() - 1) : generation.get(elementIdx - 1);
                    return rule.rule(leftElement, element, rightElement);
                })
                .collect(Collectors.toList());
            afterExecution.nextGeneration(generation);

            System.out.println("Generation " + i);
            generation.forEach(System.out::println);
        }
    }
}

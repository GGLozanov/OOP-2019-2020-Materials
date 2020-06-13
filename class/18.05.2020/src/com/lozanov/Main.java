package com.lozanov;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Boolean> generationPrime = new ArrayList<>() {{
            add(true);
            add(true);
            add(false);
        }};

        CellularAutomation<Boolean> automation = new CellularAutomation<>(
            generationPrime,
            (Boolean left, Boolean center, Boolean right) -> { // rule 30
                if(!left && right) {
                    return true;
                }
                if(left && !right) {
                    return false;
                }

                return center;
            }
        );

        automation.run(2, (state) -> {
            state.add(true);
            state.remove(state.size() - 1);
        });
    }
}

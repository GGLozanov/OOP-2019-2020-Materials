package com.company;

import java.util.List;

public class Market {
    void sell(List<ISellable> sellables) {

        for(ISellable sellable : sellables) {
            sellable.sell();
        }
    }

    public Market() {

    }
}

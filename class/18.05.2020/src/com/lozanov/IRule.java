package com.lozanov;

import java.util.List;
import java.util.Set;

public interface IRule<T> {
    T rule(T leftElement, T element, T rightElement);
}

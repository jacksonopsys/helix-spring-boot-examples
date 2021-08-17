package com.hlx.posterm.service;

import java.util.function.Function;

public interface ValidationService<U, V> {
    V validate(U candidateIn);
}

package com.cybertek;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestingImplTest {

    @Test
    void calculateSum() {
        UnitTestingImpl unitTesting = new UnitTestingImpl();
        int actual = unitTesting.calculateSum(new int[]{10, 20});
        assertEquals(30, actual);
    }
}
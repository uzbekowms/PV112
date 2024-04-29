package edu.itstep.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.time.Duration;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class CalculatorTest {

    @Test
    @DisplayName("Test if 0.1 + 0.2 is equal to 0.3")
    @Tag("DEV")
    @RepeatedTest(5)
    @Disabled("Deprecated")
    void add() {
        // AAA 3A
        // arrange (підготовка)
        // act (дія)
        // assert (перевірка)
        assertEquals(0.3, Calculator.add(0.1, 0.2), 0.00001, "Nenene");
    }

    @Test
    @Tag("PROD")
    void sub() {
        assertEquals(-0.1, Calculator.sub(0.1, 0.2), 0.00001, "Nenene");
    }

    @Test
    void div() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> Calculator.div(5, 0));
//        assertEquals("Cannot divide with zero", illegalArgumentException.getMessage());
    }

    @Test
    void testAll() {
        assertEquals(4, Calculator.add(2, 3));
        assertEquals(4, Calculator.sub(8, 3));
    }

    @Test
    void testAssertAll() {
        assertAll("calculations",
                () -> assertEquals(4, Calculator.add(2, 3)),
                () -> assertEquals(4, Calculator.sub(8, 3)
                ));
    }

    @Test
    void testTimeout() {
        Assumptions.assumeFalse(System.getProperty("os.name").contains("Linux"));

        Double result = assertTimeoutPreemptively(Duration.ofSeconds(1), () -> Calculator.add(5, 5));
        assertEquals(10, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "asd"})
    void palindrome(String candidate) {
        assertTrue(StringUtil.isPalindrome(candidate));
        Mockito.only();
    }
    // Object Mother // Test Data builder
//    void test(){
//        //Arrange
//        Store store = new Store();
//        store.addInventory(Product.Shampoo, 10);
//
//        Customer customer = new Customer();
//
//        // Act
//        boolean success = customer.Purchase(store, Shampoo, 5);
//        store.removeInventory(Shampoo, 5);
//
//        // Assert
//        assertTrue(success);
//        assertEquals(5, store.getInventorySize(Shampoo));
//    }
}
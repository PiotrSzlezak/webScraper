package pl.ideopolis.webScraperTge.utils;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BigDecimalConvertionTest {

    @Test
    public void testStringToBigDecimal() {

        String testCase1 = "1";
        String testCase2 = "10";
        String testCase3 = "1,1";
        String testCase4 = "1,0";
        String testCase5 = "1,01";
        String testCase6 = "1,010";
        String testCase7 = "1,00100100";
        String testCase8 = "100,00100100";
        String testCase9 = "001";

        final BigDecimal bigDecimal1 = BigDecimalConvertion.stringToBigDecimal(testCase1).get();
        final BigDecimal bigDecimal2 = BigDecimalConvertion.stringToBigDecimal(testCase2).get();
        final BigDecimal bigDecimal3 = BigDecimalConvertion.stringToBigDecimal(testCase3).get();
        final BigDecimal bigDecimal4 = BigDecimalConvertion.stringToBigDecimal(testCase4).get();
        final BigDecimal bigDecimal5 = BigDecimalConvertion.stringToBigDecimal(testCase5).get();
        final BigDecimal bigDecimal6 = BigDecimalConvertion.stringToBigDecimal(testCase6).get();
        final BigDecimal bigDecimal7 = BigDecimalConvertion.stringToBigDecimal(testCase7).get();
        final BigDecimal bigDecimal8 = BigDecimalConvertion.stringToBigDecimal(testCase8).get();
        final BigDecimal bigDecimal9 = BigDecimalConvertion.stringToBigDecimal(testCase9).get();

        System.out.println(testCase1 + "  " + bigDecimal1);
        System.out.println(testCase2 + "  " + bigDecimal2);
        System.out.println(testCase3 + "  " + bigDecimal3);
        System.out.println(testCase4 + "  " + bigDecimal4);
        System.out.println(testCase5 + "  " + bigDecimal5);
        System.out.println(testCase6 + "  " + bigDecimal6);
        System.out.println(testCase7 + "  " + bigDecimal7);
        System.out.println(testCase8 + "  " + bigDecimal8);
        System.out.println(testCase9 + "  " + bigDecimal9);

    }

    @Test
    public void testCheckIfStringContainsAtLeastOneDigit() {

        String testCase1 = "";
        String testCase2 = "123";
        String testCase3 = "testing 123";
        String testCase4 = "123 testing ";
        String testCase5 = " < d a .EMM43tm o,ń€eqr903 ";
        String testCase6 = " < d a .EMMtm o,ń€eqr ";
        String testCase7 = null;
        String testCase8 = "1";

        final boolean test1 = BigDecimalConvertion.checkIfStringContainsAtLeastOneDigit(testCase1);
        final boolean test2 = BigDecimalConvertion.checkIfStringContainsAtLeastOneDigit(testCase2);
        final boolean test3 = BigDecimalConvertion.checkIfStringContainsAtLeastOneDigit(testCase3);
        final boolean test4 = BigDecimalConvertion.checkIfStringContainsAtLeastOneDigit(testCase4);
        final boolean test5 = BigDecimalConvertion.checkIfStringContainsAtLeastOneDigit(testCase5);
        final boolean test6 = BigDecimalConvertion.checkIfStringContainsAtLeastOneDigit(testCase6);
        final boolean test8 = BigDecimalConvertion.checkIfStringContainsAtLeastOneDigit(testCase8);

        assertEquals(false, test1);
        assertEquals(true, test2);
        assertEquals(true, test3);
        assertEquals(true, test4);
        assertEquals(true, test5);
        assertEquals(false, test6);
        assertThrows(NullPointerException.class,
                () -> BigDecimalConvertion.checkIfStringContainsAtLeastOneDigit(testCase7));
        assertEquals(true, test8);
    }

}
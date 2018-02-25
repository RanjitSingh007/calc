package calc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ranjit Singh
 * Date Last Modified: 02/24/18
 */

public class CalTester {
    Cal calculate;      //object for Cal class

    //Cal object is initiated before each test
    @Before public void createObj(){
       calculate = new Cal();
    }

    //Cal object is nullified after each test case
    @After public void nullObj(){
        calculate = null;
    }

    /**
    * Test for the correct number of days in a normal year (not a leap year) = 365
     * In order to get 365 days a year we need to include December 31st day as well.
     * Possible test values: 1/1/2017 to 1/1/2018.
     * Since we can't select different years, we will consider there are 364 days in a year*/
    @Test
    public void calYearTest(){
        //Testing for years 2017, 2018, and 2019 (not leap years)
        assertEquals(364,calculate.cal(01,01,12,31,2017));
        assertEquals(364,calculate.cal(01,01,12,31,2018));
        assertEquals(364,calculate.cal(01,01,12,31,2019));
    }

    /**
     * Test for the correct number of days in a leap year = 366
     * In order to get 366 days a year we need to include December 31st day as well.
     * Possible test values: 1/1/2016 to 1/1/2017.
     * Since we can't select different years, we will consider there are 365 days in a leap year*/
    @Test
    public void calLeapYearTest(){
        //Testing for leap years 2008, 2012, 2016, 2020
        assertEquals(365,calculate.cal(01,01,12,31,2008));
        assertEquals(365,calculate.cal(01,01,12,31,2012));
        assertEquals(365,calculate.cal(01,01,12,31,2016));
        assertEquals(365,calculate.cal(01,01,12,31,2020));
    }

    /**
     * Test for total number of days in a month for months with 31 days
     * Test for January, March, May, July, August, October, December
     * In order to get 31 days for above months we need to include 31st day of each month.
     * Possible test values: 1/1/2018 to 2/1/2018.*/
    @Test
    public void calMonthThirtyOneDaysTest(){
        // Test for January, July, May, and October
        assertEquals(31,calculate.cal(01,01,02,01,2018));
        assertEquals(31,calculate.cal(07,01, 8, 01,2018));
        assertEquals(31,calculate.cal(05,01,06,01,2018));
        assertEquals(31,calculate.cal(10,01,11,01,2018));
    }

    /**
     * Test for total number of days in a month for months with 30 days
     * Test for April, June, September, November
     * In order to get 30 days for above months we need to include 30th day of each month.
     * Possible test values: 4/1/2018 to 5/1/2018.*/
    @Test
    public void calMonthThirtyDaysTest(){
        // Test for April, June, September, November
        assertEquals(30,calculate.cal(04,01,05,01,2018));
        assertEquals(30,calculate.cal(06,01, 07, 01,2018));
        assertEquals(30,calculate.cal(9,01,10,01,2018));
        assertEquals(30,calculate.cal(11,01,12,01,2018));
    }

    /**
     * Test for Happy path
     *  1. Test for days in six months = 180 */
    @Test
    public void calSixMonthsTest(){
        //180 days from first six months in 2018 (excluding the last day i.e. June 30)
        //184 days from last six months in 2018 (including the last day from 06/30/2018 to 12/31/2018)
        // 180 + 184 = 364 ( a non-leap year as described above)
        assertEquals(180,calculate.cal(01,01,06,30,2018));
        assertEquals(184,calculate.cal(06,30,12,31,2018));
    }

    /**
     * Test for Happy path
     *  2. Test for days between two months = 60 */
    @Test
    public void calSixtyDaysTest(){
        //60 days (excluding the last day)
        assertEquals(60,calculate.cal(04,01,05,31,2018));
        assertEquals(60,calculate.cal(06,01,07,31,2017));
        assertEquals(60,calculate.cal(8,01,9,30,2016));
    }

    /**
     * Test for Happy path
     *  3. Test for Random dates */
    @Test
    public void calRandomDaysTest(){
        //10 days (excluding the last day)
        assertEquals(10,calculate.cal(06,01,06,11,2018));
        //25 days (excluding the last day)
        assertEquals(25,calculate.cal(06,01,06,26,2018));
        //45 days (excluding the last day). Also note that July has 31 days
        assertEquals(45,calculate.cal(07,01,8,15,2018));
    }

    /**
     * Test for the February month
     * 1. Test for the leap year with 29 days */
    @Test
    public void calFebLeapYearTest(){
        //Check for leap Year 2016 and not a leap Year 2018 (excluding the last day)
        assertEquals(29,calculate.cal(02,01,03,01,2016));
        assertNotEquals(29,calculate.cal(02,01,03,01,2018));
    }

    /**
     * Test for the February month
     * 2. Test for not a leap year with 28 days */
    @Test
    public void calFebNotLeapYearTest(){
        //Check for not a leap Year 2017 and a leap Year 2012 (excluding the last day)
        assertEquals(28,calculate.cal(02,01,03,01,2017));
        assertNotEquals(28,calculate.cal(02,01,03,01,2012));
    }

    /**
     * Test for NumberFormatException --using Integer.parseInt(String value)--
     *      Test if string is passed as int for:
     *      1. month1
     *      2. day1
     *      3. month2
     *      4. day2
     *      5. year*/

    @Test (expected = NumberFormatException.class)
    public void testNullValues(){
        String val ="no Int Value"; //Test String
        assertEquals(null,calculate.cal(Integer.parseInt(val),01,01,30,2018));
        assertEquals(null,calculate.cal(01,Integer.parseInt(val),01,30,2018));
        assertEquals(null,calculate.cal(01,01,Integer.parseInt(val),30,2018));
        assertEquals(null,calculate.cal(01,01,01,Integer.parseInt(val),2018));
        assertEquals(null,calculate.cal(01,01,01,30,Integer.parseInt(val)));
    }
}

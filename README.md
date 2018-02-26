# Assignment 5
-------------------------------------------------------------
# Problems:
------------------------------------------------------------
# With Main Method
1. Only the first run of month input does check for a valid month number, after that, subsequent prompting does not check for month number. For example, given this input combination:
12
1
1
1
2018
13
14
Would return a date range when 13 and 14 was supposed to be invalid months. However, if the following combination was given:
13
1
14
1
Then the system would say the months are invalid and assuming to be 1 (Janurary)

2. The month of February allows inputted date to be up to 31 when it should have max 29 (for leap year) or 28 (for normal years)

# With Calc
1. Our Test Set checks many different conditions that could arise in real world scenarios. For example, we check the normal conditions or the “happy paths” giving different tests for different intervals of time such as, months having 31 days which is what the calMonthThirtyOneDaysTest() method checks for, those having just 30 days which is what is being tested by the calMonthThirtyDaysTest(), and evening going on to test two months and six months using the calMonthSixtyDaysTest() and calSixMonthsTest() respectively. The Test Set also checks the month of February since we need to ensure the program calculates leap years properly using the calFebLeapYearTest() and calFebNotLeapYearTest(). We also perform a test that checks random dates that fall within the parameters of the applications “happy path”. The final test we perform is to ensure that a integer is entered, this is being tested in all the parameters that may be passed into cal(). All of this is also well documented in the CalTester.java file with brief descriptions as well as a possible test value range for some of the conditions.

One of the Faults we found when looking at the cal() method is that if the user enters a leap year date such as February 31st it will calculate the difference based on 2/31 not 2/29. This also ties into the actual calculation as the total days should be 366 causing the end result to be incorrect.


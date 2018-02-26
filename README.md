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
1. The calc() method does not account for a wrong date in February, where February suppose to only take max 28th (for non-leap year) or 29th (for leap year). However, inputting 31st for the date in February will calculate the days between months based on 2/31, not 2/28 or 2/29. **This was not found by the test case**. If given this input:<br>
<code>int days = Cal.cal(1,31,2,31,2017)</code><br>
should give days as 28 days or invalid input, but instead gives 31 days.
2. 


# Test Case Description
1. Our Test Set checks many different conditions that could arise in real world scenarios. For example, we check the normal conditions or the “happy paths” giving different tests for different intervals of time such as, months having 31 days which is what the <code>calMonthThirtyOneDaysTest()</code> method checks for, those having just 30 days which is what is being tested by the <code>calMonthThirtyDaysTest()</code>, and evening going on to test two months and six months using the <code>calMonthSixtyDaysTest()</code> and <code>calSixMonthsTest()</code> respectively. The Test Set also checks the month of February since we need to ensure the program calculates leap years properly using the <code>calFebLeapYearTest()</code> and <code>calFebNotLeapYearTest()</code>. We also perform a test that checks random dates that fall within the parameters of the applications “happy path”. The final test we perform is to ensure that a integer is entered, this is being tested in all the parameters that may be passed into <code>cal()</code>. All of this is also well documented in the <code>CalTester.java</code> file with brief descriptions as well as a possible test value range for some of the conditions.

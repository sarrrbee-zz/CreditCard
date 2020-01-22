# CreditCard - Class Project Description:

Credit card companies use built-in "checksums" as added security measures when creating the account numbers on credit cards. This means that there are only certain valid credit card numbers, and validity can instantly be detected by using an algorithm that may involve adding up parts of the numbers or performing other checks.  In this problem, you will implement a security algorithm on a credit card number, and your program will indicate whether or not the card number is valid, according to the security check. Note that this algorithm is purely made-up; don't try to use it to detect fake credit card numbers! 

To check that the credit card number is valid, verify that it conforms to the following rules:  

	1.	The first digit must be a 4.  
	2.	The fourth digit must be one greater than the fifth digit  
	3.	The product of the first, fifth, and ninth digits must be 24  
	4.	The sum of all digits must be evenly divisible by 4  
	5.	The sum of the first four digits must be one less than the sum of the last four digits  
	6.	If you treat the first two digits as a two-digit number, and the seventh and eight digits as a two digit number, their sum must be 100.  
	
*Hint: valid card numbers according to this set of rules include 4807-6052-1766 and 4094-3460-2754.*  

You should use these for testing out your program.
Your job is to create a CreditCard class that represents a card number as a String. Hence you will have an instance variable of type String to store this. In addition the CreditCard class must have a mutator method called check( ) that determines if the credit card is valid or not. This information (whether the card is valid or not) should be stored in an instance variable of type boolean. Your class should also have an accessor method called isValid( ) that returns the value of this boolean.  Your class CreditCard should also have an instance variable of type int called errorCode. This variable should be initialized to 0 and changed to an integer between 1 and 6 if the CreditCard object fails one of the tests above. That is, the check( ) method should change errorCode to the number corresponding to the first test the number failed. If the number does not fail any tests then you can leave the errorCode variable at 0. Finally, you should have an accessor method called getErrorCode( ) that returns the value of the variable errorCode. You might find this method useful when you are verifying that your check( ) method works correctly.

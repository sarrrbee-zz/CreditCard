/* Name: Sara Bernstein
 * UNI: sgb2137
 * Assignment: CreditCard - checking for valid card number 
 * / 

/* Method that tests if a credit card number is valid
 *  The credit card is valid under the following 6 conditions:
 * 1.  The first digit must be a 4.  
 * 2.  The fourth digit must be one greater than the fifth digit  
 * 3.  The product of the first, fifth, and ninth digits must be 24  
 * 4.  The sum of all digits must be evenly divisible by 4  
 * 5.  The sum of the first four digits must be one less than the sum of the last four digits  
 * 6.  If you treat the first two digits as a two-digit number, and the seventh and eight digits as a two digit number, their sum must be 100.
 * If does not meet one of the 6 requirements, it is invalid and its errorCode int value is the rule # is didn't follow
 */

public class CreditCard {
    
    private String cardNumber; // credit card number is stored as a String 
    private boolean valid; // boolean indicating valid or not
    private int errorCode; // int indicating which rule is violated first
    
    // constructor to initialize instance variables 
    // accepts String as input/parameter
    // Assumes cardNumber is valid 
    public CreditCard(String number)
    {
        cardNumber = number;
        valid = true; 
        errorCode = 0;
    }
    
    // This method checks rule 1
    // Rule 1: First digit is 4
    private void check1()
    {
       int d1 = Integer.parseInt(cardNumber.substring(0,1)); 
        if (d1 != 4)
        {
            valid = false;
            errorCode = 1;
        }
    }
    
    // This method checks rule 2 
    // Rule 2: Fourth digit is one greater than fifth
    private void check2()
    {
        int d4 = Integer.parseInt(cardNumber.substring(3,4));
        int d5 = Integer.parseInt(cardNumber.substring(4,5));
        if ( d4 != (d5 + 1) )
        {
            valid = false;
            errorCode = 2;
        }    
    }
    
    // This method checks rule 3
    // Rule 3: Product of first, fifth and ninth digits is 24 
    private void check3()
    {
        int d1 = Integer.parseInt(cardNumber.substring(0,1));
        int d5 = Integer.parseInt(cardNumber.substring(4,5));
        int d9 = Integer.parseInt(cardNumber.substring(8,9));
        if ( (d1 * d5 * d9) != 24 )
        {
            valid = false;
            errorCode = 3;
        }
    }
    
    // This method checks rule 4
    // Rule 4: Sum of all digits is evenly divisible by 4 
    private void check4()
    {
        int sumAllDigits = 0;
        for (int i = 0; i < 12; i++)
        {
            int digit = Integer.parseInt(cardNumber.substring(i, i+1));
            sumAllDigits += digit; 
        }
        
        if ((sumAllDigits % 4) != 0 )
        {
            valid = false;
            errorCode = 4;
        }
    }
    
    // This method checks rule 5
    // Rule 5: Sum of first four is one less than sum of last four
    private void check5()
    {
        int sumFirstFour = 0;
        int sumLastFour = 0;
        for (int i = 0; i < 12; i++)
        {
            int digit = Integer.parseInt(cardNumber.substring(i,i+1));
            if ( i < 4)
            {
                sumFirstFour += digit;
            }
            else if ( i >= 8)
            {
                sumLastFour += digit;
            }
        }

        if ( sumFirstFour != (sumLastFour - 1) )
        {
            valid = false;
            errorCode = 5;
        }
    }
    
    // This method checks rule 6
    // Rule 6: first two digits as one number and
    // seventh and eigth digits as one number must add up to 100
    private void check6()
    {
        int oneAndTwo = Integer.parseInt(cardNumber.substring(0, 2));
        int sevenAndEight = Integer.parseInt(cardNumber.substring(6, 8));
        
        if ( (oneAndTwo + sevenAndEight) != 100 ) 
        {
            valid = false;
            errorCode = 6;
        }
    }
    
    // This method checks overall credit card to see if it's valid 
    // Calls on the other check methods specific to the rules only if 
    // one has not been violated yet 
    public void check() 
    {
        check1();
        
        if ( valid == true )
        {
            check2();  
        }
        
        if ( valid == true)
        {
            check3();
        }
        
        if ( valid == true)
        {
            check4();
        }
        
        if ( valid == true)
        {
            check5();
        }
        
        if ( valid == true)
        {
            check6();
        }
    }
    
    // accessor method to get info about if card is valid
    public boolean isValid()
    {
        return valid; 
    }
    
    // accessor method to know which test the card failed if it's not valid 
    public int getErrorCode()
    {
        return errorCode;
    }

}
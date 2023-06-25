package rios.NeweggAutomation;

import javax.swing.JOptionPane;

public class Automate {
    public static String link(String url)
    {
        boolean condition = true;
        
        while (condition)
        {
            url = JOptionPane.showInputDialog("Enter the Newegg Url of the electronic/pc component you wish to Monitor (Ex: https://www.newegg.com/corsair-rmx-series-rm650x-2018-cp-9020178-na-650w/p/N82E16817139232?Description=power%20supply&cm_re=power_supply-_-17-139-232-_-Product): ");
            
            if (url.matches("https?:\\/\\/(www\\.)?(newegg)\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)")) //accepts only url's that begin with https://newegg.com
            {    
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, url + " is not a valid a link. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return url;
    }
    
    public static String firstName(String fN)
    {
        fN = JOptionPane.showInputDialog("Enter your first name: ");
        return fN;
    }
    
    public static String lastName(String lN)
    {
        lN = JOptionPane.showInputDialog("Enter your last name: ");
        return lN;
    }
    
    public static String Address(String A)
    {
        boolean condition = true;
        
        while (condition) //validating address
        {
            A = JOptionPane.showInputDialog("Enter your address: ");
            
            if (A.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)") == true)
            {
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, A + " is not a valid input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return A;
    }
    
    public static String City(String C)
    {
        boolean condition = true;
        
        while (condition) //validating city
        {
            C = JOptionPane.showInputDialog("Enter your city: ");
            
            if (C.matches("([a-zA-Z]+|[a-zA-Z]+\\\\s[a-zA-Z]+)"))
            {
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, C + " is not a valid input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return C;
    }
    
    public static String State(String S)
    {
        boolean condition = true;
        
        while (condition) //validating state
        {
            S = JOptionPane.showInputDialog("Enter your state (Ex: Texas): ");
            
            if (S.matches("([a-zA-Z]+|[a-zA-Z]+\\\\s[a-zA-Z]+)"))
            {
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, S + " is not a valid input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return S;
    }
    
    public static int zipCode(int zC)
    {
        String zip = null;
        boolean error = true;
        boolean condition = true;
            
        while (error) //validates that zip code is an integer
        {
            error = false;
            zip = JOptionPane.showInputDialog("Enter your zip code (Ex: 77022): ");
                
            try
            {
                zC = Integer.parseInt(zip);
            }
            
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, zip + " is not an integer input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        }   
        
        while (condition) //validating zip code is 5 digits
        {   
            if (zip.matches("\\b\\d{5}\\b")) //checks that zip code is 5 digits
            {
                zC = Integer.parseInt(zip);
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, zip + " is not a valid input, must be 5 digits. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                zip = JOptionPane.showInputDialog("Enter your zip code (Ex: 77022): ");
            }
        }
        return zC;
    }
    
    public static long phoneNumber(long pN)
    {
        String phone = null;
        boolean error = true;
        boolean condition = true;
        
        while (error)
        {
            error = false;
            phone = JOptionPane.showInputDialog("Enter your phone number (Ex: 1234567890): ");
                
            try
            {
                pN = Long.parseLong(phone);
            }
            
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, phone + " is not an integer input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        }  
        
        while (condition) //validating phone number
        {   
            if (phone.matches("^[0-9]{10}$")) //checks that phone number is 10 digits
            {
                pN = Long.parseLong(phone);
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, phone + " is not a valid input, must be 10 digits. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                phone = JOptionPane.showInputDialog("Enter your phone number (Ex: 1234567890): ");
            }
        }
        return pN;
    }
    
    public static String Email(String E)
    {
        boolean condition = true;
        
        while (condition)
        {
            E = JOptionPane.showInputDialog("Enter your email address (Ex: bob23@gmail.com): ");
            
            if (E.matches("^(.+)@(?:[a-zA-Z].+[a-zA-Z])$"))
            {
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, E + " is not a valid input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return E;
    }
    
    public static String cardName(String cN)
    {
        cN = JOptionPane.showInputDialog("Enter cardholder name: ");
        return cN;
    }
    
    public static long cardNumber(long cNum)
    {
        boolean error = true;
        String Num = null;
        boolean condition = true;
        
        while (error)
        {
            error = false;
            Num = JOptionPane.showInputDialog("Enter your Card Number (Ex: 1234567890123456): ");
                
            try
            {
                cNum = Long.parseLong(Num);
            }
            
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, Num + " is not an integer input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        }  
        
        while (condition) //validating card number to have 16 digits
        {   
            if (Num.matches("^[0-9]{16}$")) 
            {
                cNum = Long.parseLong(Num);
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, Num + " is not a valid input, must be 16 digits. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                Num = JOptionPane.showInputDialog("Enter your card number (Ex: 1234567890123456): ");
            }
        }
        return cNum;
    }
    
    public static int expirationMonth(int eM)
    {
        boolean error = true;
        String Month = null;
        boolean condition = true;
        
        while (error)
        {
            error = false;
            Month = JOptionPane.showInputDialog("Enter your expiration month (Ex: 02): ");
                
            try
            {
                eM = Integer.parseInt(Month);
            }
            
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, Month + " is not an integer input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        }  
        
        while (condition) //validating month expiration to have 2 digits
        {   
            if (Month.matches("^[0-1][1-9]$")) 
            {
                eM = Integer.parseInt(Month);
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, Month + " is not a valid input, must be 2 digits. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                Month = JOptionPane.showInputDialog("Enter your expiration month (Ex: 02): ");
            }
        }
        return eM;
    }
    
    public static int expirationYear(int eY)
    {
        boolean error = true;
        String Year = null;
        boolean condition = true;
        
        while (error)
        {
            error = false;
            Year = JOptionPane.showInputDialog("Enter your expiration year (Ex: 2022): ");
                
            try
            {
                eY = Integer.parseInt(Year);
            }
            
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, Year + " is not an integer input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        }  
        
        while (condition) //validating expiration year to have 4 digits
        {   
            if (Year.matches("^[2][0][2][1-9]$")) //if year is 4 digits and greater than or equal to 2021  
            {
                eY = Integer.parseInt(Year);
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, Year + " is not a valid input, must be 4 digits. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                Year = JOptionPane.showInputDialog("Enter your expiration year (Ex: 2022): ");
            }
        }
        return eY;
    }
    
    public static int securityNum(int CVV)
    {
        boolean error = true;
        String cvv_num = null;
        boolean condition = true;
        
        while (error)
        {
            error = false;
            cvv_num = JOptionPane.showInputDialog("Enter your 3 digit security number from the back of your card (Ex: 123): ");
                
            try
            {
                CVV = Integer.parseInt(cvv_num);
            }
            
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, cvv_num + " is not an integer input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        }  
        
        while (condition) //validating cvv number to have 3 digits
        {   
            if (cvv_num.matches("^[0-9][0-9][0-9]$")) //if cvv is 3 digits 
            {
                CVV = Integer.parseInt(cvv_num);
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, cvv_num + " is not a valid input, must be 3 digits. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                cvv_num = JOptionPane.showInputDialog("Enter your 3 digit security number from the back of your card (Ex: 123): ");
            }
        }
        return CVV;
    }
}

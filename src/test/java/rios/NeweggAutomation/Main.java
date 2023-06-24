package rios.NeweggAutomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
/**
 *
 * @author risor
 */

public class Main //1st Class
{
    public static void main(String[] args) throws InterruptedException
    {        
        String fN, lN, A, C, S, E, cN; //initialize first name, last name, address, city, state, email and card name
        fN = lN = A = C = S = E = cN = null;
        int zC, eM, eY, CVV; //initialize zip code, expiration month, expiration year and CVV
        zC = eM = eY = CVV = 0;
        long pN, cNum;
        pN = cNum = 0;
        
        String url = null; //initilize product we want to track
        
        url = Automate.link(url);
        fN = Automate.firstName(fN);
        lN = Automate.lastName(lN);
        A = Automate.Address(A);
        C = Automate.City(C);
        S = Automate.State(S);
        zC = Automate.zipCode(zC);
        pN = Automate.phoneNumber(pN);
        E = Automate.Email(E);
        cN = Automate.cardName(cN);
        cNum = Automate.cardNumber(cNum);
        eM = Automate.expirationMonth(eM);
        eY = Automate.expirationYear(eY);
        CVV = Automate.securityNum(CVV);
        
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize(); 
        //browser.get("https://www.newegg.com/adata-32gb-288-pin-ddr5-sdram/p/N82E16820215420?Item=N82E16820215420&Description=ddr5%20ram&cm_re=ddr5_ram-_-20-215-420-_-Product&quicklink=true"); //Out Of Stock
        //browser.get("https://www.newegg.com/xpg-32gb-288-pin-ddr4-sdram/p/0RN-00KG-00139?Item=9SIAJNUES91045&cm_sp=SP-_-138144-_-Pers_DeactivatedProductAlsoViewElevate-_-4-_-9SIAJNUES91045-_-20-215-420-_--_-4"); //In Stock
        
        browser.get(url);
        autoRefresh e = new autoRefresh();
        e.inStock(browser);
        
        WebElement addToCartBtn;
        addToCartBtn = browser.findElement(By.className("btn-primary")); //locates the add to cart button
        addToCartBtn.click(); //clicks on button
        
        Thread.sleep(1500); //sleep for 1.5 second
       
        WebElement noThanksBtn;
        noThanksBtn = browser.findElement(By.xpath("//*[@id=\"modal-intermediary\"]/div/div/div/div[3]/button[1]")); //locates the no thanks button
        noThanksBtn.click(); //clicks on button
        
        Thread.sleep(1500);
        
        WebElement continueToCheckoutBtn;
        continueToCheckoutBtn = browser.findElement(By.xpath("//*[@id=\"modal-intermediary\"]/div/div/div[2]/div[2]/button[2]")); //locates the continue to checkout button
        continueToCheckoutBtn.click(); //clicks on button
       
        Thread.sleep(2000); //sleep for 1 second
        
        WebElement guestCheckoutBtn;
        guestCheckoutBtn = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/form[2]/div[2]/div/button")); //locates the guest checkout button
        guestCheckoutBtn.click(); //clicks on button
        //old xpath = //*[@id=\"app\"]/div/div[2]/div[2]/div/div/div/form[2]/div[2]/div/button
        
        //WebElement addAddressBtn;
        //addAddressBtn = browser.findElement(By.xpath("//*[@id=\"shippingItemCell\"]/div/div[2]/div[2]/div/div[2]/div[2]/div/div")); //locates the add address button
        //addAddressBtn.click(); //clicks on button
        
        Thread.sleep(1000);

        String fullName = fN + " " + lN;
        
        WebElement textBoxFirstName;
        textBoxFirstName = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/form/div[2]/div[1]/input")); //locates the first name textbox
        textBoxFirstName.sendKeys(fullName); //types first name into the textbox
        
        //WebElement textBoxLastName;
        //textBoxLastName = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/form/div[2]/div[2]/input")); //locates textbox for first name
        //textBoxLastName.sendKeys(lN); //types last name into the textbox
        
        WebElement textBoxAddress;
        textBoxAddress = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/form/div[2]/div[7]/label[2]/input")); //locates textbox for last name
        textBoxAddress.sendKeys(A); //types address into the textbox
        
        WebElement textBoxCity;
        textBoxCity = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/form/div[2]/div[11]/label[2]/input")); //locates textbox for city
        textBoxCity.sendKeys(C); //types the city into textbox
        
        S = S.toUpperCase();
        Select state = new Select(browser.findElement(By.name("State"))); //locates state dropdown menu
        state.selectByVisibleText(S); //selects state
        
        WebElement textBoxZip;
        textBoxZip = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/form/div[2]/div[13]/input")); //locates textbox for zip code
        String zip = String.valueOf(zC);
        textBoxZip.sendKeys(zip); //types the zip code into textbox
        
        WebElement textBoxPhone; 
        textBoxPhone = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/form/div[2]/div[5]/input")); //locates textbox for phone number
        String phone = String.valueOf(pN);
        textBoxPhone.sendKeys(phone); //types phone number into textbox
        //old xpath = //*[@id=\"app\"]/div/div/div/div/div[2]/form/div[2]/div[14]/input
        
        WebElement textBoxEmail; 
        textBoxEmail = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/form/div[2]/div[15]/input")); //locates textbox for email
        textBoxEmail.sendKeys(E); //types email into textbox
        
        WebElement saveBtn;
        saveBtn = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/button[2]")); //locates the save button
        saveBtn.click(); //clicks on button
        
        Thread.sleep(2000);
        
        if (browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/button[1]")).isDisplayed() == true) //if you want to sign in is present, because system recognizes that the email inputted has an account
        {
            Thread.sleep(2000);
            WebElement continueAsGuestBtn;
            continueAsGuestBtn = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/button[2]")); //locates the continue as guest button
            continueAsGuestBtn.click(); //clicks on button
        }
        else;
        
        Thread.sleep(3000);
        
        if (browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/div/h5")).isDisplayed() == true) //if pop up window suggest an address
        {
            Thread.sleep(2000);
            WebElement useSuggestedAddressBtn;
            useSuggestedAddressBtn = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/button[2]")); //locate the use address button
            useSuggestedAddressBtn.click(); //clicks on button
        }    
        else;
        
        Thread.sleep(1000);
        
        WebElement continueToDeliveryBtn;
        continueToDeliveryBtn = browser.findElement(By.xpath("//*[@id=\"shippingItemCell\"]/div/div[3]/button")); //locates the continue to delivery button
        continueToDeliveryBtn.click(); //clicks on button
        
        Thread.sleep(2000);
        
        WebElement continueToPaymentBtn;
        continueToPaymentBtn = browser.findElement(By.xpath("//*[@id=\"deliveryItemCell\"]/div/div[3]/button[2]")); //locates the continue to payment button
        continueToPaymentBtn.click(); //clicks on button
        
        Thread.sleep(2000);
        
        WebElement creditCardBtn;
        creditCardBtn = browser.findElement(By.xpath("//*[@id=\"paymentItemCell\"]/div/div[2]/div/div[2]/div[2]/div[2]/div")); //locates the add new credit card button
        creditCardBtn.click(); //clicks on button
        
        Thread.sleep(3000);
        
      
        browser = browser.switchTo().frame(browser.findElement(By.tagName("iframe"))); //switches browser to focus on iframe, since payment details are encapsulated inside it
        Thread.sleep(1000);
       
        WebElement cardNameTextBox;
        cardNameTextBox = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/input")); //locates textbox for card name
        cardNameTextBox.sendKeys(cN); //types name into textbox
        
        WebElement cardNumTextBox;
        cardNumTextBox = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/input")); //locate textbox for card number
       
        String CardNum = String.valueOf(cNum); //typing card number was tricky, rather than typing a value though send keys, it required to replace the value and then send keys
        char[] digits = CardNum.toCharArray();
        int length = digits.length;
        cardNumTextBox.click();
        String empty_value = cardNumTextBox.getAttribute("value");
       
        for (int i = 0; i < length; i++)
        {
            empty_value = empty_value.replaceFirst("_", String.valueOf(digits[i]));
        }
        cardNumTextBox.sendKeys(empty_value); //types card number into textbox
        
        
        
        Select month = new Select(browser.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[4]/label[2]/select"))); //locates month dropdown 
        if (eM < 10) //when int is 09 and lower and the conversion to string happens, it removes the zero therefore we must add it to match with the value of the dropdown menu
        {
            String ExpirationMonth = "0" + String.valueOf(eM);
            month.selectByValue(ExpirationMonth);
        }
        else
        {
            String ExpirationMonth = String.valueOf(eM); 
            month.selectByValue(ExpirationMonth);
        }
            
        Select year = new Select(browser.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[5]/label/select"))); //locates year dropdown menu
        String ExpirationYear = String.valueOf(eY); 
        year.selectByVisibleText(ExpirationYear); //selects year
        
        WebElement saveBtn2;
        saveBtn2 = browser.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/button[2]")); //locates save payment details button
        saveBtn2.click(); //clicks on button
        
        Thread.sleep(1000);
        
        browser = browser.switchTo().defaultContent(); //switches browser's focus back to the html body/head 
        
        WebElement cvvTextBox;
        cvvTextBox = browser.findElement(By.xpath("//*[@id=\"paymentItemCell\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/label/div[4]/input")); //locates textbox for cvv
        
        String CVV_Number = String.valueOf(CVV);
        char[] cvvDigits = CVV_Number.toCharArray();
        int length2 = cvvDigits.length;
        cvvTextBox.click();
        String empty_value2 = cvvTextBox.getAttribute("value");
        
        for (int i = 0; i < length2; i++)
        {
            empty_value2 = empty_value2.replaceFirst("_", String.valueOf(cvvDigits[i]));
        }
        cvvTextBox.sendKeys(CVV_Number); //types card cvv into textbox
        
        WebElement reviewOrderBtn; 
        reviewOrderBtn = browser.findElement(By.xpath("//*[@id=\"paymentItemCell\"]/div/div[3]/button")); //locates review your order button
        reviewOrderBtn.click(); //clicks on button
        
        //WebElement placeOrderBtn; COMMENT THIS OUT IF YOU WANT IT TO PURCHASE AN ITEM AUTOMATICALLY
        //placeOrderBtn = browser.findElement(By.xpath("//*[@id=\"btnCreditCard\"]")); //locates place order button
        //placeOrderBtn.click(); //clicks on button
       
        System.out.println("Successful Checkout");
        System.exit(0);
    }
}

class autoRefresh //2nd Class
{   
    void inStock(WebDriver browser) throws InterruptedException //RECURSIVE METHOD
    {
        String condition;
        Thread.sleep(1500);
        
        /*if (browser.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div/div/div[1]/div[1]/div[1]/div/div/span")).getText().equals("NEWEGG SHUFFLE ONLY"))
        {
            JOptionPane.showMessageDialog(null, "Try new item, this item is exclusively for the Newegg Shuffle");
            
            System.exit(0);
        }*/
        
        condition = browser.findElement(By.cssSelector("button.btn-wide")).getText();//locates the button of the product page and retrieve the text (ADD TO CART or AUTO NOTIFY)
            
        if (condition.equals("AUTO NOTIFY")) //if Notify Me When In Stock button is located
        {
            System.out.println("Item is Out of Stock");
            browser.navigate().refresh();
            Thread.sleep(10000); //refreshes every 10 seconds, it can be lowered but increases the risk of the site soft banning your IP for excessive refreshs
            inStock(browser);
        }
        else
        {
            System.out.println("Item is In Stock");
        }
    }
}
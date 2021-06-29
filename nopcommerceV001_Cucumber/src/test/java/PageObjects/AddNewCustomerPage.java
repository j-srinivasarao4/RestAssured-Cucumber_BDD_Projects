package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	
public WebDriver ldriver;
     
     public AddNewCustomerPage(WebDriver rdriver)  {
                     
              ldriver = rdriver;
                     
              PageFactory.initElements(rdriver, this);

     }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

	@FindBy(css = "input[value='Mr']")
	WebElement MaleRadio;

	@FindBy(css = "input[value='Mrs']")
	WebElement FemaleRadio;

	@FindBy(css = "input[data-qa='name']")
	WebElement NameInput;

	@FindBy(css = "input[data-qa='email']")
	WebElement EmailInput;

	@FindBy(css = "input[data-qa='password']")
	WebElement PasswordInput;

	@FindBy(css = "select#days")
	WebElement DaysDropDown;

	@FindBy(css = "select#months")
	WebElement MonthsDropDown;

	@FindBy(css = "select#years")
	WebElement YearsDropDown;
	
	@FindBy(css="input[name='newsletter']")
	WebElement NewsLetterCheckBox;
	
	@FindBy(css="input[name='optin']")
	WebElement OffersCheckBox;
	
	@FindBy(css="input[data-qa='first_name']")
	WebElement FirstNameBox;
	
	@FindBy(css="input[data-qa='last_name']")
	WebElement LastNameBox;
	
	@FindBy(css="input[data-qa='company']")
	WebElement CompanyBox;
	
	@FindBy(css="input[data-qa='address']")
	WebElement AddressBox;
	
	@FindBy(css="input[data-qa='address2']")
	WebElement Address2Box;
	
	@FindBy(css="input[data-qa='state']")
	WebElement StateBox;
	
	@FindBy(css="input[data-qa='city']")
	WebElement CityBox;
	
	@FindBy(css="input[data-qa='zipcode']")
	WebElement ZipcodeBox;
	
	@FindBy(css="input[data-qa='mobile_number']")
	WebElement MobileNumBox;
	
	@FindBy(css="button[data-qa='create-account']")
	WebElement CreateAccButton;
	
	@FindBy(css = "select#country")
	WebElement CountryDropDown;
	
	
	

	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void selectMaleTitle() {
		MaleRadio.click();
	}
	
	public void enterName(String name) {
		type(NameInput, name);
	}
	
	public void enterPassword(String password) {
		type(PasswordInput, password);
	}

	public void selectDay(String text) {
		selectFromDropDownByText(DaysDropDown, text);
	}
	
	public void selectMonth(String text) {
		selectFromDropDownByText(MonthsDropDown, text);
	}
	
	public void selectYear(String text) {
		selectFromDropDownByText(YearsDropDown, text);
	}
	
	public void selectNewsletterCheckbox() {
		NewsLetterCheckBox.click();
	}

	public void selectOffersCheckbox() {
		OffersCheckBox.click();
	}
	
	public void enterFirstName(String Fname) {
		type(FirstNameBox, Fname);
	}
	
	public void enterLastName(String Lname) {
		type(LastNameBox, Lname);
	}
	
	public void enterCompanyName(String company) {
		type(CompanyBox, company);
	}
	
	public void enterAddress(String address) {
		type(AddressBox, address);
	}
	
	public void enterAddress2(String address2) {
		type(Address2Box, address2);
	}
	
	public void enterState(String state) {
		type(StateBox, state);
	}	
	
	public void enterCity(String city) {
		type(CityBox, city);
	}	
	
	public void enterZip(String zip) {
		type(ZipcodeBox, zip);
	}
	
	public void enterMobileNum(String mobilenum) {
		type(MobileNumBox, mobilenum);
	}
	
	
	public void selectCountry(String country) {
		selectFromDropDownByText(CountryDropDown,country );
	}
	
	public void createAccButtonClick() {
		click(CreateAccButton);
	}
}

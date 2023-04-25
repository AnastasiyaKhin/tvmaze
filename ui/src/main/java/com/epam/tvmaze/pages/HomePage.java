package com.epam.tvmaze.pages;

import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class HomePage extends AbstractPage {
    @FindBy(xpath = "//div[@id='user-tools']//a[@href='/account/login']")
    private WebElement fieldLogin;
    @FindBy(id = "searchform-q")
    private WebElement inputSearch;
    @FindBy(xpath = "//*[@id='w1']//section//a[contains(@href, 'people')]")
    private WebElement linkPerson;
    @FindBy(xpath = "//div[@id='header-menu']//a[@href='/shows']")
    private WebElement labelShows;
    @FindBy(xpath = "//div[@id='header-menu']//a[@href='/shows']")
    private WebElement labelPeople;

    public HomePage openPage() {
        driver.navigate().to(ConfigReader.getValue(ConfigEnum.BASE_URL));
        return this;
    }

    public LoginPage clickLinkLogin() {
        fieldLogin.click();
        return new LoginPage();
    }

    public HomePage inputSearchRequest(String searchRequest) {
        inputSearch.clear();
        inputSearch.sendKeys(searchRequest, Keys.ENTER);
        log.info(String.format("Entered request - %s", searchRequest));
        return this;
    }

    public PeoplePage clickLinkPerson() {
        linkPerson.click();
        return new PeoplePage();
    }

    public ShowsPage clickLinkShows() {
        labelShows.click();
        return new ShowsPage();
    }

    public PeoplePage clickPeoplePageLink() {
        labelPeople.click();
        return new PeoplePage();
    }
}
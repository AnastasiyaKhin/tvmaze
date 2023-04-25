package com.epam.tvmaze.ui;

import com.epam.tvmaze.data.UIDataRequest;
import com.epam.tvmaze.pages.HomePage;
import com.epam.tvmaze.pages.PeoplePage;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleActionTest extends BaseTest {
    private PeoplePage peoplePage;

    @BeforeClass
    public void beforeTest() {
        homePage = new HomePage().openPage();
        homePage.clickLinkLogin()
                .inputUserName()
                .inputPassword()
                .clickButtonLogin();
    }

    @SneakyThrows
    @Test(description = "UI test actions with people", dataProvider = "People with valid data",
            dataProviderClass = UIDataRequest.class)
    public void peopleActions(String peopleNameAndSurname) {
        peoplePage = homePage.clickPeoplePageLink();
        peoplePage.inputSearchRequest(peopleNameAndSurname).clickLinkPerson();

        assertThat(peoplePage.getNameAndSurname()).isEqualTo(peopleNameAndSurname);

        /**Only this can help, since there is a restriction on sending requests for a registered user **/
        TimeUnit.SECONDS.sleep(8);
    }
}
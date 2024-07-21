package com.tsw.pageobjecttemplate.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tsw.pageobjecttemplate.pages.LoanDetailsPage;
import com.tsw.pageobjecttemplate.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    MainPage mainPage = new MainPage();
    LoanDetailsPage loanDetailsPage = new LoanDetailsPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://loan-app.tallinn-learning.ee/small-loan");
    }

    @Test
    public void checkDefaultMonthlyPayment() {
        mainPage.monthlyPaymentValue.shouldBe(visible);
    }

    @Test
    public void fillIncorrectLoanAmountAndCheckErrorMessage() {
        mainPage.fieldAmount.setValue("100");
        mainPage.errorMessage.shouldBe(visible);
    }

    @Test
    public void checkLoginDetailsWithDefaultParams() {
        mainPage.applyNowButton.click();
        mainPage.usernameField.shouldBe(visible);
        mainPage.passwordField.shouldBe(visible);
        mainPage.continueButton.shouldBe(disabled);
    }

    @Test
    public void whenUserLogInCheckLoadDetailsPageIsVisible() {
        mainPage.applyNowButton.click();
        mainPage.usernameField.setValue("Tata");
        mainPage.passwordField.setValue("12345");
        mainPage.continueButton.click();
        loanDetailsPage.finalAmount.shouldBe(visible);
    }

    @Test
    public void whenUserAddOnlyUsernameCheckContinueButtonIsDisable() {
        mainPage.applyNowButton.click();
        mainPage.usernameField.setValue("Tata");
        mainPage.continueButton.shouldBe(disabled);
    }

    @Test
    public void CheckSuccessDecisionAndOpenNewLoanPage() {
        mainPage.applyNowButton.click();
        mainPage.usernameField.setValue("Tata");
        mainPage.passwordField.setValue("12345");
        mainPage.continueButton.click();
        loanDetailsPage.finaContinueButton.click();
        loanDetailsPage.successMessage.shouldBe(visible);
        loanDetailsPage.successOkButton.click();
        mainPage.applyNowButton.shouldBe(visible);
    }
}
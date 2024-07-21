package com.tsw.pageobjecttemplate.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class MainPage {
    public SelenideElement monthlyPaymentValue = $x("//*[@data-testid='ib-small-loan-calculator-field-monthlyPayment']");
    public SelenideElement fieldAmount = $x("//*[@data-testid='id-small-loan-calculator-field-amount']");
    public SelenideElement applyNowButton = $x("//*[@data-testid='id-small-loan-calculator-field-apply']");
    public SelenideElement errorMessage = $("[data-testid='id-small-loan-calculator-field-error']");
    public SelenideElement usernameField = $x("//*[@data-testid='login-popup-username-input']");
    public SelenideElement passwordField = $x("//*[@data-testid='login-popup-password-input']");
    public SelenideElement continueButton = $x("//*[@data-testid='login-popup-continue-button']");

}

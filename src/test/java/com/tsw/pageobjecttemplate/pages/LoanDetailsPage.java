package com.tsw.pageobjecttemplate.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class LoanDetailsPage {
    public SelenideElement finalAmount = $x("//*[@data-testid='final-page-amount']");
    public SelenideElement finaContinueButton = $x("//*[@data-testid='final-page-continue-button']");
    public SelenideElement successMessage = $(byText("Success!"));
    public SelenideElement successOkButton = $x("//*[@data-testid='final-page-success-ok-button']");
}

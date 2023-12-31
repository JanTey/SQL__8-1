package ru.netology.qamid59.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.qamid59.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
  private SelenideElement codeField = $("[data-test-id=code] input");
  private SelenideElement verifyButton = $("[data-test-id=action-verify]");

  public VerificationPage() {
    codeField.shouldBe(visible);
  }

  public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
    codeField.setValue(verificationCode.getCode());
    verifyButton.click();
    return new DashboardPage();
  }

  public void notValidVerify(DataHelper.VerificationCode verificationCode) {
    codeField.setValue(verificationCode.getCode());
    verifyButton.click();
    $(".notification_visible").shouldBe(visible);
  }
}
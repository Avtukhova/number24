
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.exactText;

import org.junit.jupiter.api.BeforeEach;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class CardDeliveryTest {

    @Test
    public void shouldCardDelivery() {
        open("http://localhost:9999");
        $("[class='input__control'][type='text']").setValue("Воронеж");
        LocalDate today = LocalDate.now();
        LocalDate desiredDate = today.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String appointmentDate = desiredDate.format(formatter);
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(appointmentDate);
        $("[class='input__control'][name='name']").setValue("Елена Иванова");
        $("[class='input__control'][name='phone']").setValue("+79501055555");
        $("[class='checkbox__text'][role='presentation']").click();
        $(Selectors.byText("Забронировать")).click();
        $(Selectors.withText("Успешно")).shouldBe(visible, Duration.ofSeconds(15));
        //$(Selectors.withText("Встреча успешно забронирована")).shouldBe(visible);
        $("[data-test-id='notification'] .notification__content").shouldHave(Condition.exactText("Встреча успешно забронирована на " + appointmentDate));

    }




}

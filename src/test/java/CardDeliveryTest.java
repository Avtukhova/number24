
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


public class CardDeliveryTest {

    @Test
    public void shouldCardDelivery() {
        open("http://localhost:9999");
        $("[class='input__control'][type='text']").setValue("Воронеж");
        LocalDate sourceDate = LocalDate.now();
        LocalDate desiredDate = sourceDate.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = desiredDate.format(formatter);
        $("[class='calendar-input__native-control'][type='date']").setValue("14.10.2021");
        $("[class='input__control'][name='name']").setValue("Елена Иванова");
        $("[class='input__control'][type='tel']").setValue("+79501055555");
        $("[class='checkbox__text'][role='presentation']").click();
        $(Selectors.byText("Забронировать")).click();
        $(Selectors.withText("Успешно")).shouldBe(visible, Duration.ofSeconds(15));

    }

    @Test
    public void shouldCardDelivery2() {
        open("http://localhost:9999");
        $("[data-test-id='city']").setValue("Воронеж");
        $("[data-test-id='date']").setValue("20.10.2021");
        $("[data-test-id='name']").setValue("Елена Иванова");
        $("[data-test-id='phone']").setValue("+79501055555");
        $("[data-test-id='agreement']").click();
        $(Selectors.byText("Забронировать")).click();
        $(Selectors.withText("Успешно")).shouldBe(visible, Duration.ofSeconds(15));

    }


}

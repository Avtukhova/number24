
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.exactText;


public class CardDeliveryTest {

    @Test
    public void shouldCardDelivery() {
        open("http://localhost:9999");
        $("[class='input__control'][type='text']").setValue("Воронеж");
        $("[class='calendar-input__native-control'][type='date']").setValue("20.10.2021");
        $("[class='input__control'][name='name']").setValue("Елена Иванова");
        $("[class='input__control'][type='tel']").setValue("+79501055555");
        $("[class='checkbox__text'][role='presentation']").click();
        $(Selectors.byText("Забронировать")).click();
        $(Selectors.withText("Успешно")).shouldBe (visible, Duration.ofSeconds(20));

    }





}

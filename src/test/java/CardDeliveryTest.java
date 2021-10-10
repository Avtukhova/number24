
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
    private void shouldCardDelivery() {
        open("http://localhost:9999");
        $("[data-test-id=city]").setValue("Воронеж");
        $("[data-test-id=date]").setValue("20.10.2021");
        $("[data-test-id=name]").setValue("Елена Иванова");
        $("[data-test-id=phone]").setValue("+79501055555");
        $("[data-test-id='agreement]").click();
        $(Selectors.byText("Забронировать")).click();
        $(Selectors.withText("Успешно")).shouldBe (visible, Duration.ofSeconds(20));

    }





}

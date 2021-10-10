
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.exactText;


public class CardDeliveryTest {

    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
    }

    @Test
    private void shouldCardDelivery() {
        open("http://localhost:9999");

    }





}

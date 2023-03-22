package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDate;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @Test
    void shouldCheckFormCompletion(){

        Configuration.holdBrowserOpen = true;
        LocalDate date = LocalDate.now();
        String actualDate = String.valueOf(date);

        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Горно-Алтайск");
        $("[data-test-id=date] input").setValue(actualDate);
        $("[data-test-id=name] input").setValue("Олег Петров");
        $("[data-test-id=phone] input").setValue("+79998887755");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $x("//*[contains(text(), 'Успешно!')]").shouldBe(visible, Duration.ofSeconds(13));
    }
}

package ru.netology.cards;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.netology.Generator;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static ru.netology.Generator.generateDate;

public class CardDelivery {

    @Test
    void shouldOrderCardDelivery() {
        Configuration.headless = true;
        String planningDate = generateDate(4);
        open("http://localhost:9999/");
        $("input[placeholder='Город']").setValue("Кострома");
        $("[data-test-id=date] input").sendKeys(Keys.CONTROL + "A" + Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(planningDate);
        $("[data-test-id=name] input").setValue("Маша Рони");
        $("span[data-test-id=phone] input").setValue("+79100101010");
        $("[data-test-id=agreement").click();
        $(byText("Забронировать")).click();
        $x("//div[contains(text(), 'Встреча успеш')]").should(appear, Duration.ofSeconds(11));
        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }
}

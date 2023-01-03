package ru.netology.cards;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CardDelivery {

    @Test
    void shouldOrderCardDelivery() {
        //Configuration.holdBrowserOpen = true;
        //Configuration.browserSize = "900x600";
        Configuration.headless = true;
        open("http://localhost:9999/");
        $("input[placeholder='Город']").setValue("Кострома");
        $("[data-test-id=date] input").sendKeys(Keys.CONTROL + "A" + Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue("07.02.2023");
        $("[data-test-id=name] input").setValue("Маша Рони");
        //$x("//span[contains(text(), 'Мобильный')]").setValue("+79100101010"); НЕ РАБОТАЕТ НИ ОДИН ИНПУТ ЧЕРЕЗ ХPATH - выдаёт ошибку invalid element state
        $("span[data-test-id=phone] input").setValue("+79100101010");
        $("[data-test-id=agreement").click();
        $(byText("Забронировать")).click();
        $x("//div[contains(text(), 'Встреча успеш')]").should(appear, Duration.ofSeconds(11));
    }
}

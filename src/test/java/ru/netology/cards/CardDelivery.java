package ru.netology.cards;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CardDelivery {

    @Test
    void shouldOrderCardDelivery() {
        Configuration.holdBrowserOpen = true;
        //Configuration.browserSize = "900x600";
        open("http://localhost:9999/");
        $("input[placeholder='Город']").setValue("Кострома");
        $("input[value='06.01.2023']").sendKeys(Keys.CONTROL + "A");
        $("input[value='06.01.2023']").sendKeys(Keys.BACK_SPACE);
        $("input[placeholder='Дата встречи']").setValue("07.02.2023");
        $("input[name='name']").setValue("Маша Рони");
        //$x("//span[contains(text(), 'Мобильный')]").setValue("+79100101010"); НЕ РАБОТАЕТ НИ ОДИН ИНПУТ ЧЕРЕЗ ХPATH - выдаёт ошибку invalid element state
        $("span[data-test-id=phone] input").setValue("+79100101010");
        $x("//span[contains(text(), 'Я согл')]").click();
        $x("//span[contains(text(), 'Забр')]").click();
        $x("//div[contains(text(), 'Встреча успешно')]").should(appear, Duration.ofSeconds(11));
    }
}

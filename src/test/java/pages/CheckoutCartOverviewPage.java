package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckoutCartOverviewPage extends BasePage {

    private static final By TOTAL_RAW_PRICE = By.xpath("//div[@class='summary_subtotal_label']");

    public CheckoutCartOverviewPage(WebDriver driver) {
        super(driver);
    }

    public double getActualTotalRawPrice() {
        String totalPriceText = driver.findElement(TOTAL_RAW_PRICE).getText();
        return extractPrice(totalPriceText);
    }

    private static double extractPrice(String text) {
        Pattern pattern = Pattern.compile("([0-9]+(\\.[0-9]{1,2})?)|0(\\.[0-9]{1,2})?");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("Founded: " + Double.parseDouble(matcher.group(1)));
            return Double.parseDouble(matcher.group(1));
        }

        throw new IllegalArgumentException("No price found in the text: " + text);
    }
}

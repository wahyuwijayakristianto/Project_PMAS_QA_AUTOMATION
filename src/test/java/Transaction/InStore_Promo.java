package Transaction;

import StokElement.Transaction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class InStore_Promo extends Transaction {
    WebDriver driver = login();

    public InStore_Promo() throws IOException {
    }


    @Test
    public void inStorePromoSearch() throws InterruptedException, IOException {
        inStorePromo();
        //eksekusi search
        Thread.sleep(1000);
        WebElement no_kontrak = driver.findElement(By.cssSelector("#noKontrak"));
        no_kontrak.click();
        no_kontrak.sendKeys(Keys.F9);
        WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
        int barisTabelNoKontrak;
        ArrayList<String> dataFillSearch = new ArrayList<>();
        dataFillSearch.add("JAN");
        dataFillSearch.add("PT");
        dataFillSearch.add("20");
        dataFillSearch.add("asdasd");
        for (int value = 0; value < dataFillSearch.size(); value++) {
            search.sendKeys(dataFillSearch.get(value));
            barisTabelNoKontrak = driver.findElements(By.xpath("//div//table//tbody//tr//td[@class='sorting_1']")).size();
            if (barisTabelNoKontrak > 0) {
                for (int row = 1; row <= barisTabelNoKontrak; row++) {
                    StringBuilder dataTemp = new StringBuilder();
                    for (int cell = 1; cell <= 9; cell++) {
                        dataTemp.append(driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(" + row + ") > td:nth-child(" + cell + ")")).getText());
                    }
                    if (!dataTemp.toString().toUpperCase().contains(dataFillSearch.get(value))) {
                        System.out.println("baris : " + dataTemp + "error");
                    }
                }
            } else {
                System.out.println("data yang ditampilkan kosong pada value search : " + dataFillSearch.get(value));
            }
            System.out.println("value search " + dataFillSearch.get(value) + " telah di cek");
            search.clear();
            Thread.sleep(1000);
        }
    }

}














package Transaction;

import StokElement.Transaction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class OutStore_Tenant extends Transaction {
    WebDriver driver = login();

    public OutStore_Tenant() throws IOException {
    }

    @Test
    public void OutStorePromoSearch() throws InterruptedException {
        outStoreTenant();
        //eksekusi search
        Thread.sleep(2000);
        WebElement no_kontrak = driver.findElement(By.cssSelector("#noKontrak"));
        no_kontrak.click();
        no_kontrak.sendKeys(Keys.F9);
        WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
        int barisTabelNoKontrak;
        int cellTabelNoKontrak;
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
                    for (int cell = 1; cell <= 5; cell++) {
                        dataTemp.append(driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) " +
                                "> tr:nth-child(" + row + ") " +
                                "> td:nth-child(" + cell + ")")).getText());
                    }
                    if (!dataTemp.toString().toUpperCase().contains(dataFillSearch.get(value))) {
                        System.out.println("baris : " + dataTemp + " Error");
                    }
                }
            } else {
                System.out.println("data yang ditampilkan kosong pada value search : " + dataFillSearch.get(value));
            }
            System.out.println("value search " + dataFillSearch.get(value) + " telah di cek");
            search.clear();
        }
    }

    @Test
    public void outStoreCekData() throws InterruptedException {
        outStoreTenant();
        Thread.sleep(1000);
        WebElement lov = driver.findElement(By.cssSelector("#noKontrak"));
        lov.click();
        lov.sendKeys(Keys.F9);
        WebElement clickData = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1)"));
//        int dataRow = driver.findElements(By.xpath("//div//table//tbody//tr[2]//td")).size();
//        ArrayList<String> data = new ArrayList<>();
//        for (int i = 1; i <= dataRow; i++) {
//            data.add(driver.findElement(By.xpath("//div//table//tbody//tr[2]//td[" + i + "]")).getText());
//            System.out.println(driver.findElement(By.xpath("//div//table//tbody//tr[2]//td[" + i + "]")).getText());
//        }
        clickData.click();
        lov.click();
        lov.sendKeys(Keys.ENTER);
        Thread.sleep(1500);
        //variable perhitungan data
        String nilaiBayar2 = driver.findElement(By.cssSelector("div[class='dataTables_scrollFootInner'] th[class='col footer']")).getText();
        String nilaiSewa = driver.findElement(By.cssSelector("#nilaiSewa")).getText();
        String ppn = driver.findElement(By.cssSelector("#nilaiPPN")).getText();
        String totalBayar = driver.findElement(By.cssSelector("#totalBayar")).getText();

        // eksekusi harga
        if (Objects.equals(totalBayar, nilaiSewa + ppn)) {
            System.out.println("hasil nilai sewa + ppn sudah sesuai");
        } else {
            System.out.println("hasil nilai sewa + ppn BELUM sesuai");
        }

        if (Objects.equals(totalBayar, nilaiBayar2)) {
            System.out.println("total bayar sudah sinkron");
        } else {
            System.out.println("total bayar BELUM sesuai");
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }

}

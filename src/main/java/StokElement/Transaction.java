package StokElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Transaction {

    WebDriver driver;
    By transaction = text("Transaction");
    By saranaPromosi = text("Sarana Promosi");
    By inStorePromo = By.cssSelector("a[href='/inStorePromo']");
    By outStoreTenant = By.cssSelector("a[href='/outStoreTenant']");
    By updateProduct = text("Update Product");
    By tagProduct = text("Tag Product");
    By masterPerubahaanTag = text("Master Perubahaan TAG");
    By updateTag = text("Update TAG");
    By classProduct = text("Class Product");
    By minPKMPerType = text("Min PKM Per Type");
    By minOrder = text("Min Order");
    By minorCustomize = text("Minor Customize");
    By updateMPKM0 = text("Update MPKM 0");
    By minPKM_MinOrder = text("Min PKM & Min Order");
    By minorPerType = text("Minor Per Type");
    By updateTypeToko = text("Update Type Toko");
    By barangCustomize = text("Barang Customize (BCT)");
    By barangTerlarang = text("Barang Terlarang (BTL)");
    By prosesAutoBtl = text("Proses Auto BTL");
    By prosesBTLPerToko = text("Per Toko");
    By prosesBTLPerItem = text("Per Item");
    By updateMindis = text("Update Mindis");
    By autoReviewMPKM = text("Auto Review MPKM");
    By promoTokoGO = text("Promo Toko GO");
    By compareDataPromo = text("Compare Data Promo");
    By compareHargaJual = text("Compare Harga Jual");

    public WebDriver login() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Wahyu\\IdeaProjects\\PMAS\\src\\main\\resources\\data.properties");
        prop.load(fis);
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", dir + "//driver_storage//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://10.231.126.7:7007/login");
        String nik = prop.getProperty("nik");
        String password = prop.getProperty("password");
        driver.findElement(By.cssSelector("#nik")).sendKeys(nik);
        driver.findElement(By.cssSelector("#pin")).sendKeys(password);
        driver.findElement(By.cssSelector("#btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".logo-lg")).click();
        return driver;
    }

    private By text(String elementtext) {
        return By.linkText(elementtext);
    }

    public void inStorePromo() throws IOException, InterruptedException {
        driver.findElement(transaction).click();
        driver.findElement(saranaPromosi).click();
        driver.findElement(inStorePromo).click();

    }

    public void outStoreTenant() {
        driver.findElement(transaction).click();
        driver.findElement(saranaPromosi).click();
        driver.findElement(outStoreTenant).click();
    }

    public void masterPerubahanTag() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(tagProduct).click();
        driver.findElement(masterPerubahaanTag).click();
    }

    public void masterUpdateTag() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(tagProduct).click();
        driver.findElement(updateTag).click();
    }

    public void classProduct() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(classProduct).click();
    }

    public void minPKMPerType() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(minPKMPerType).click();
    }

    public void minOrder() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(minOrder).click();
    }

    public void minorCustomize() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(minorCustomize).click();
    }

    public void updateMPKM0() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(updateMPKM0).click();
    }

    public void minPKM_MinOrder() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(minPKM_MinOrder).click();
    }

    public void minorPerType() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(minorPerType).click();
    }

    public void updateTypeToko() {
        driver.findElement(transaction).click();
        driver.findElement(updateTypeToko).click();
    }

    public void barangCustomize() {
        driver.findElement(transaction).click();
        driver.findElement(barangCustomize).click();
    }

    public void barangTerlarang() {
        driver.findElement(transaction).click();
        driver.findElement(barangTerlarang).click();
    }

    public void prosesAutoBTLItem() {
        driver.findElement(transaction).click();
        driver.findElement(prosesAutoBtl).click();
        driver.findElement(prosesBTLPerItem).click();
    }

    public void prosesAutoBTLToko() {
        driver.findElement(transaction).click();
        driver.findElement(prosesAutoBtl).click();
        driver.findElement(prosesBTLPerToko).click();
    }

    public void updateMindis() {
        driver.findElement(transaction).click();
        driver.findElement(updateMindis).click();
    }

    public void autoreviewMPKM() {
        driver.findElement(transaction).click();
        driver.findElement(autoReviewMPKM).click();
    }

    public void promoTokoGO() {
        driver.findElement(transaction).click();
        driver.findElement(promoTokoGO).click();
    }

    public void compareHargaJual() {
        driver.findElement(transaction).click();
        driver.findElement(compareDataPromo).click();
        driver.findElement(compareHargaJual).click();
    }

}



















package StokElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Transaction  {

    WebDriver driver;
    public WebDriver login() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Wahyu\\IdeaProjects\\PMAS\\src\\main\\resources\\data.properties");
        prop.load(fis);
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",dir +"//driver_storage//chromedriver.exe");
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
    By transaction = text("Transaction");
    By saranaPromosi = text("Sarana Promosi");
    By inStorePromo = By.cssSelector("a[href='/inStorePromo']");
    By outStoreTenant = text("OutStore/Tenant");
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

    private By text(String elementtext) {
        return By.linkText(elementtext);
    }

    public void inStorePromo() throws IOException, InterruptedException {
        driver.findElement(transaction).click();
        driver.findElement(saranaPromosi).click();
        driver.findElement(inStorePromo).click();

    }

    public WebElement outStoreTenant() {
        driver.findElement(transaction).click();
        driver.findElement(saranaPromosi).click();
        return driver.findElement(outStoreTenant);
    }

    public WebElement masterPerubahanTag() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(tagProduct).click();
        return driver.findElement(masterPerubahaanTag);
    }

    public WebElement masterUpdateTag() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        driver.findElement(tagProduct).click();
        return driver.findElement(updateTag);
    }

    public WebElement classProduct() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        return driver.findElement(classProduct);
    }

    public WebElement minPKMPerType() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        return driver.findElement(minPKMPerType);
    }

    public WebElement minOrder() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        return driver.findElement(minOrder);
    }

    public WebElement minorCustomize() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        return driver.findElement(minorCustomize);
    }

    public WebElement updateMPKM0() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        return driver.findElement(updateMPKM0);
    }

    public WebElement minPKM_MinOrder() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        return driver.findElement(minPKM_MinOrder);
    }

    public WebElement minorPerType() {
        driver.findElement(transaction).click();
        driver.findElement(updateProduct).click();
        return driver.findElement(minorPerType);
    }

    public WebElement updateTypeToko() {
        driver.findElement(transaction).click();
        return driver.findElement(updateTypeToko);
    }

    public WebElement barangCustomize() {
        driver.findElement(transaction).click();
        return driver.findElement(barangCustomize);
    }

    public WebElement barangTerlarang() {
        driver.findElement(transaction).click();
        return driver.findElement(barangTerlarang);
    }

    public WebElement prosesAutoBTLItem() {
        driver.findElement(transaction).click();
        driver.findElement(prosesAutoBtl).click();
        return driver.findElement(prosesBTLPerItem);
    }

    public WebElement prosesAutoBTLToko() {
        driver.findElement(transaction).click();
        driver.findElement(prosesAutoBtl).click();
        return driver.findElement(prosesBTLPerToko);
    }

    public WebElement updateMindis() {
        driver.findElement(transaction).click();
        return driver.findElement(updateMindis);
    }

    public WebElement autoreviewMPKM() {
        driver.findElement(transaction).click();
        return driver.findElement(autoReviewMPKM);
    }

    public WebElement promoTokoGO() {
        driver.findElement(transaction).click();
        return driver.findElement(promoTokoGO);
    }

    public WebElement compareHargaJual() {
        driver.findElement(transaction).click();
        driver.findElement(compareDataPromo).click();
        return driver.findElement(compareHargaJual);
    }

}



















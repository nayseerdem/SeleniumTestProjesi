package test.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


/**
 * @author : NerminAyseErdem
 * @projectName : SosyalDokuTesting
 * packageName : test.amazon, time : 19:03, day : Perşembe
 * @since : 11.01.2018
 */
/**
 * -- http://www.amazon.com
 * --giriş yapılacak
 * 1- arama alanına samsung yazacak +
 * 2- gelen sayfada sonuc var mı yok mu kontrol edilecek ve onayalanacak +
 * 3- arama sonucunda 2.sayfaya tıklayacak ve sonuc bulundugunu onaylayacak +
 * 4- üstten 3.ürünün içindeki 'Add To List' linkie tıklayacak
 * 5- Ekranın en üstündeki 'List' linkine tıklayacak ve içerisinden 'Wish List ' i seçecek
 * 6- Açılan sayfada bit önceki sayfada izelemeye alınmış ürün bulundugunu onaylayacak
 * 7- Favaorilere alınan bu ürünün yanındaki 'Delete' butonuna basarak favorilerimden çıkaracak
 * 8- Sayfada bu ürünün artık favorilerer alınmadığını onaylayacak
 */
public class AmazonGirisTesti {
	@Test
	public void test() throws InterruptedException {
    	System.setProperty("webdriver.gecko.driver", "lib\\\\geckodriver-v0.18.0-win64\\\\geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com");
		Thread.sleep(2000);

		System.out.println("GiRiş SAYFASI TESTi");
		driver.findElement(By.id("nav-link-accountList")).click();
		System.out.println("Giriş Sayfasına Yönlendi");
		Thread.sleep(3000);


		driver.findElement(By.className("a-input-text")).clear();
		driver.findElement(By.className("a-input-text")).sendKeys("ayseerdem2012@gmail.com");
		Thread.sleep(1000);
		System.out.println("Kullanıcı adı girildi!");


		driver.findElement(By.id("ap_password")).clear();
		driver.findElement(By.id("ap_password")).sendKeys("5549924881");
		Thread.sleep(1000);
		System.out.println("Şifre girildi!");

		driver.findElement(By.className("a-button-input")).click();
		Thread.sleep(4000);
		System.out.println("Giriş butonuna tıklandı!");

		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung");
		System.out.println("samsung arama yerine yazıldı");

		driver.findElement(By.className("nav-input")).click();
		Thread.sleep(4000);
		System.out.println("samsung araması yapıldı");

		//gelen sayfada sonuc var mı yok mu kontrol edilecek ve onayalanacak
        boolean b = driver.findElement(By.className("s-item-container")) != null;
        System.out.println("Var mı : "+ b);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[text()='2']")).click();
        System.out.println("2. sayfa tıklandı");

        //Add To List  bu aşamada sıkıntı oluştu iç içe taglar olduğu zaman kontrol edilmeli
//        driver.findElement(By.id("result_18"));
//        driver.findElement(By.xpath("//div[@id='result_18']")); //by xpath
//        driver.findElement(By.xpath("//div[contains(@class,'result_18')]/div/div/div/div/a")).click();
////        driver.findElement(By.id("a-link-normal")).click();
//        System.out.println("Üstten üçüncü seçildi");





        System.out.println("Test başarılı!");
	}
}

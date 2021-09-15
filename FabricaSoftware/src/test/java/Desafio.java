import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Desafio {

    private WebDriver driver;

    @Before
    public void main(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

    }

    @Test
    public void fluxoPrincipal(){

        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[1]/td/input")).sendKeys("Edson");
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[2]/td/input")).sendKeys("SenhaQA");

        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[3]/td/textarea"));
        textArea.clear();
        textArea.sendKeys("Comentario no text area");

        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[1]")).click();


        WebElement selectionItem = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[7]/td/select"));
        Select item4 = new Select(selectionItem);
        item4.deselectByValue("ms4");
        Select item1 = new Select(selectionItem);
        item1.selectByValue("ms1");

        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[8]/td/select/option[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[2]")).click();


        //Validações

        Assert.assertEquals("Edson", driver.findElement(By.xpath("//*[@id=\"_valueusername\"]")).getText());
        Assert.assertEquals("SenhaQA", driver.findElement(By.xpath("//*[@id=\"_valuepassword\"]")).getText());
        Assert.assertEquals("Comentario no text area", driver.findElement(By.xpath("//*[@id=\"_valuecomments\"]")).getText());

        Assert.assertEquals("cb1", driver.findElement(By.xpath("//*[@id=\"_valuecheckboxes0\"]")).getText());
        Assert.assertEquals("cb2", driver.findElement(By.xpath("//*[@id=\"_valuecheckboxes1\"]")).getText());
        Assert.assertEquals("cb3", driver.findElement(By.xpath("//*[@id=\"_valuecheckboxes2\"]")).getText());


        Assert.assertEquals("rd1", driver.findElement(By.xpath("//*[@id=\"_valueradioval\"]")).getText());
        Assert.assertEquals("ms1", driver.findElement(By.xpath("//*[@id=\"_valuemultipleselect0\"]")).getText());
        Assert.assertEquals("dd1", driver.findElement(By.xpath("//*[@id=\"_valuedropdown\"]")).getText());



    }
    @Test
    public void fluxoAlternativo(){

        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[3]/td/textarea")).clear();

        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[2]")).click();

        Assert.assertEquals("No Value for username", driver.findElement(By.xpath("/html/body/div[1]/div[3]/p[1]/strong")).getText());

        Assert.assertEquals("No Value for password", driver.findElement(By.xpath("/html/body/div[1]/div[3]/p[2]/strong")).getText());

        Assert.assertEquals("No Value for comments", driver.findElement(By.xpath("/html/body/div[1]/div[3]/p[3]/strong")).getText());
    }

    @After
    public void fim(){
        driver.quit();
    }


}

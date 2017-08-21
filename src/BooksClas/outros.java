/* * Autor: Paulo H A Moreira...
   * github.com/pouleth0
   * Obs: Manter divulgar. (sem restrições-manter gratificações do Developer: não e crime;
   * Omitir créditos para o autor original,  é vergonhoso...=)
   *
   * Created on : Jul 31, 2017, 9:32:04 AM
   * Author     : kn0w */
package BooksClas;

/** * Created by kn0w on 20/08/17. */
import com.itextpdf.text.DocumentException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import static BooksClas.gerarPDF.createPdfFromImages;
import static Principal.MainBookContr.appTitle;
import static Principal.MainBookContr.webDriverSL;
import static com.itextpdf.text.pdf.PdfName.DEST;
/**
 * Created by kn0w on 20/08/17.*/

public class outros {
    public void outros(){
        System.setProperty("webdriver.chrome.driver", new File("driver/chromedriver").getAbsolutePath());
        File resourcesFolder = new File("resources");
        webDriverSL = new ChromeDriver();
        webDriverSL.manage().window().getSize().getHeight();
        webDriverSL.manage().window().getSize().getWidth();

        /*
        driver.manage().window();//.maximize();
        driver.manage().window().setSize(new Dimension(1279, 682));
        driver.navigate().to("http://read.amazon.com");*/
        waitSomeTime();
        appTitle=webDriverSL.getTitle();
        System.out.println("Application title is :: " + appTitle);
        webDriverSL.findElement(By.id("ap_email")).sendKeys("AMAZON_USERNAME");
        webDriverSL.findElement(By.id("ap_password")).sendKeys("AMAZON_PASSWORD");
        webDriverSL.findElement(By.id("signInSubmit-input")).click();

        waitSomeTime();

        File screenshot = ((TakesScreenshot) webDriverSL).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(resourcesFolder, "E-BooksHome.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        webDriverSL.switchTo().frame("KindleLibraryIFrame");

        WebElement element = webDriverSL.findElement(By.cssSelector("span#kindle_dialog_firstRun_button.chrome_btn"));
        element.click();
        waitSomeTime();
        screenshot = ((TakesScreenshot) webDriverSL).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(resourcesFolder, "E-Books-2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<WebElement> books = webDriverSL.findElements(By.cssSelector("img.book_image.book_click_area"));
        /***
         * Iterate over all books on the dashboard/home page
         */
        for (WebElement book : books) {

            String bookTitle = book.getAttribute("title").substring(0, 24);
            book.click();

            File bookFolder = new File(resourcesFolder, "" + bookTitle.replaceAll(" ", ""));
            bookFolder.mkdirs();

            try {
                FileUtils.writeStringToFile(new File(resourcesFolder, "HomePage.html"), webDriverSL.getPageSource(), Charset.defaultCharset());
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            webDriverSL.switchTo();//.parentFrame();
            webDriverSL.switchTo().frame("KindleReaderIFrame");

            // WebElement menuLink =
            // driver.findElement(By.cssSelector("div#kindleReader_button_goto.header_bar_icon"));

            // Actions actions = new Actions(driver);
            // actions.moveToElement(menuLink);

            // menuLink.click();
            waitSomeTime();

            // Goto Cover Page to start capturing
            // WebElement coverLink =
            // driver.findElement(By.cssSelector("div#kindleReader_goToMenuItem_goToCover"));
            // coverLink.click();

            // waitSomeTime();

            screenshot = ((TakesScreenshot) webDriverSL).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(bookFolder, "temp.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            int pageNumber = 0;
            // inicio do while para os print
            while (true) {
                pageNumber = pageNumber + 1;
                try {
                    WebElement nextArrow = webDriverSL.findElement(By.cssSelector("div#kindleReader_pageTurnAreaRight.kindleReader_pageTurnArea.pageArrow"));
                    // o if esta matando a operação quando os elementos mudam.. internamente
                    if (nextArrow == null) {
                        break;
                    }

                    nextArrow.click();
                    //da um tim para tela ser aberta... pesquisando sobre ler elemento de carregamento e apenas setar o click quando elemento estiver 100%
                    waitSomeTime();

                    screenshot = ((TakesScreenshot) webDriverSL).getScreenshotAs(OutputType.FILE);
                    try {
                        FileUtils.copyFile(screenshot, new File(bookFolder, pageNumber + ".jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            } // fim do while com os print.

            try {
                createPdfFromImages(bookFolder.getAbsolutePath(), DEST);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        }

        waitSomeTime(9000);

        screenshot = ((TakesScreenshot) webDriverSL).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(resourcesFolder, "SelectedBook.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        webDriverSL.close();
        //webDriverSL.quit();
    }

    private static void waitSomeTime() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void waitSomeTime(int miliSecons) {
        try {
            Thread.sleep(miliSecons);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/* * Autor: Paulo H A Moreira...
   * github.com/pouleth0
   * Obs: Manter divulgar. (sem restrições-manter gratificações do Developer: não e crime;
   * Omitir créditos para o autor original, é vergonhoso...=)
   *
   * Created on : Jul 31, 2017, 9:32:04 AM
   * Author     : kn0w */
package BooksClas;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/** * Created by kn0w on 20/08/17.*/
public class gerarPDF {
    public static void createPdfFromImages(String sourceFolder, PdfName dest) throws IOException, DocumentException {
        File folder = new File(sourceFolder);

        File[] allFiles = folder.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith("jpg")) {
                    return true;
                }
                return false;
            }});

        Image img = null;
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(dest)));
        document.open();
        for (File fileObj : allFiles) {
            img = Image.getInstance(fileObj.getAbsolutePath());
            document.setPageSize(img);
            document.newPage();
            img.setAbsolutePosition(0, 0);
            document.add(img);
        }
        document.close();
    }
}

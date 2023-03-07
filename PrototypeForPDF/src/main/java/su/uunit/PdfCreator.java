package su.uunit;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
* <b>Класс, отвечающий за генерацию PDF</b>
* 
 */
public class PdfCreator {
    
    /** Буферизированное изображение */
    private static BufferedImage image;
    
    /** изоброжение */
    private static Image image3;
    
    /** шрифт */
    public static final Font FONT = FontFactory.getFont("/Fonts/times.ttf","CP1251",true);//шрифт

    /**
     * Данный метод создает PDF документ, таблицу и добавляет изображение
     */
    public static void create(double area,int okon,double okno,double stoimost,String startLine) {//статический метод
        String[] tableHeads = {"№ Окна","Площадь окна (м2)","Стоимость 1 окна (руб.)"};//шапка пдф документа
        Document doc = new Document();//иницализируем документ

        try {//добавляем картинку в PDF
            image =  ImageIO.read(PdfCreator.class.getResource("/Images/money2.png"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            Image iTextImage = Image.getInstance(baos.toByteArray());
            image3 = Image.getInstance(iTextImage);
        } catch (BadElementException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        image3.scaleAbsolute(100f, 100f); //image width,height

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("Results.pdf"));
            doc.open();

            Paragraph firstLine = new Paragraph("ОТЧЕТ О РАБОТЕ ПРОГРАММЫ \n\n", FONT);
            firstLine.setAlignment(Element.ALIGN_CENTER);
            doc.add(firstLine);

            doc.add(new Paragraph(startLine, FONT));
            Paragraph resultLine = new Paragraph("Стоимость услуги = " + stoimost + " руб.\n\n", FONT);
            doc.add(resultLine);
            PdfPTable table = new PdfPTable(3);

            image3.setAbsolutePosition(475, 725);
            writer.getDirectContent().addImage(image3);
            doc.add(image3);

            for (String tableHead : tableHeads) {
                table.addCell(new Phrase(tableHead,FONT));
            }
            for (int i = 0; i < okon; i++) {
                table.addCell(Integer.toString(i+1));
                table.addCell(String.format("%.2f", area));
                table.addCell(Double.toString(okno));
            }
            doc.add(table);

            Paragraph footer = new Paragraph("Создано командой разработчиков №6", FONT);
            footer.setAlignment(Element.ALIGN_CENTER);
            doc.add(footer);

            doc.close();
            writer.close();

        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
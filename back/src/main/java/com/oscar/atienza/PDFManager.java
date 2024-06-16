package com.oscar.atienza;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class PDFManager {
    public void createPDF(Ship ship){
        try {
            Document document = new Document(PageSize.A4, 50, 50, 100, 72);
            PdfWriter.getInstance(document, new FileOutputStream("./back/naves/" + ship.getName() + ".pdf"));

            document.open();

            // Escribimos los nuevos datos
            document.add(new Paragraph("Ship information"));
            document.add(new Paragraph("Name: " + ship.getName()));
            document.add(new Paragraph("Model: " + ship.getModel()));
            document.add(new Paragraph("Starship Class: " + ship.getStarship_class()));
            document.add(new Paragraph("Crew: " + ship.getCrew()));
            document.add(new Paragraph("Number of movies: " + ship.getFilms().length));
            document.add(new Paragraph("Movies: " + String.join(", ", ship.getFilms())));

            document.close();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}

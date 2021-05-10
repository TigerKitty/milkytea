package util.print;

import java.awt.print.*;

public class Printer {
    private SalesTicket salesTicket;

    public Printer(SalesTicket salesTicket) {
        this.salesTicket = salesTicket;
    }

    public void printer() {
        try {
            Book book = new Book();

            PageFormat pf = new PageFormat();
            pf.setOrientation(PageFormat.PORTRAIT);
            Paper paper = new Paper();
            paper.setSize(226, 700);
            paper.setImageableArea(0, 0, 226, 700);
            pf.setPaper(paper);

            book.append(salesTicket, pf);

            PrinterJob job = PrinterJob.getPrinterJob();

            job.setPageable(book);

            job.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}

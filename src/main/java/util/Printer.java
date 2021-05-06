package util;

import java.awt.print.*;

public class Printer {
    private SalesTicket salesTicket;

    public Printer(SalesTicket salesTicket) {
        this.salesTicket = salesTicket;
    }

    public void printer() {
        try {
            //Book ���ṩ�ĵ��ı�ʾ��ʽ�����ĵ���ҳ�����ʹ�ò�ͬ��ҳ���ʽ��ҳ�� painter
            Book book = new Book(); //Ҫ��ӡ���ĵ�

            //PageFormat������Ҫ��ӡ��ҳ���С�ͷ���
            PageFormat pf = new PageFormat();  //��ʼ��һ��ҳ���ӡ����
            pf.setOrientation(PageFormat.PORTRAIT); //����ҳ���ӡ���򣬴������£���������

            //���ô�ӡֽҳ����Ϣ��ͨ��Paper����ҳ��Ŀհױ߾�Ϳɴ�ӡ���򡣱�����ʵ�ʴ�ӡֽ�Ŵ�С�����
            Paper paper = new Paper();
            paper.setSize(226, 700);// ֽ�Ŵ�С
            paper.setImageableArea(0, 0, 226, 700);// A4(595 X 842)���ô�ӡ������ʵ0��0Ӧ����72��72����ΪA4ֽ��Ĭ��X,Y�߾���72
            pf.setPaper(paper);

            book.append(salesTicket, pf);

            PrinterJob job = PrinterJob.getPrinterJob();   //��ȡ��ӡ��������Ȱ�װ��ӡ������

            job.setPageable(book);  //���ô�ӡ��

            job.print(); //��ʼ��ӡ
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}

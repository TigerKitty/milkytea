package util;

import util.print.Goods;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SalesTicket implements Printable {
    private List<Goods> goods; //��Ʒ�б�
    private String operatorName; //����Ա
    private String orderId; //�������
    private String totalGoodsNum; //��Ʒ����
    private String totalPrice; //�ܽ��
    private String actualCollection; //ʵ�տ�
    private String giveChange = "0"; //����
    private Date orderDate;


    private String cardNumber; //��Ա���
    private String integral; //����

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");


    @Override
    public String toString() {
        return "SalesTicket [goods=" + goods + ", operatorName=" + operatorName + ", orderId=" + orderId
                + ", totalGoodsNum=" + totalGoodsNum + ", totalPrice=" + totalPrice + ", actualCollection="
                + actualCollection + ", giveChange=" + giveChange + ", cardNumber=" + cardNumber + ", integral="
                + integral + "]";
    }


    public SalesTicket(List<Goods> goods, String operatorName, String orderId, String totalGoodsNum,
                       String totalPrice, String actualCollection, String giveChange, String cardNumber, String integral) {
        super();
        this.goods = goods;
        this.operatorName = operatorName;
        this.orderId = orderId;
        this.totalGoodsNum = totalGoodsNum;
        this.totalPrice = totalPrice;
        this.actualCollection = actualCollection;
        this.giveChange = giveChange;
        this.cardNumber = cardNumber;
        this.integral = integral;
    }


    public SalesTicket(List<Goods> goods, String operatorName, String orderId, String totalGoodsNum,
                       String totalPrice, String actualCollection, String giveChange) {
        super();
        this.goods = goods;
        this.operatorName = operatorName;
        this.orderId = orderId;
        this.totalGoodsNum = totalGoodsNum;
        this.totalPrice = totalPrice;
        this.actualCollection = actualCollection;
        this.giveChange = giveChange;
    }

    public SalesTicket(List<Goods> goods, String operatorName, String orderId, String totalGoodsNum, String totalPrice, String actualCollection, String giveChange, Date orderDate) {
        this.goods = goods;
        this.operatorName = operatorName;
        this.orderId = orderId;
        this.totalGoodsNum = totalGoodsNum;
        this.totalPrice = totalPrice;
        this.actualCollection = actualCollection;
        this.giveChange = giveChange;
        this.orderDate = orderDate;
    }

    /**
     * ��ӡ����
     * graphics - ��������ҳ��������ģ�����ӡ��ͼ��
     * pageFormat - ������ҳ��Ĵ�С�ͷ��򣬼����ô�ӡ��ʽ����ҳ���Сһ��Ϊ������λ����1/72 Ӣ��Ϊ��λ��1Ӣ��Ϊ25.4���ס�A4ֽ����Ϊ595 �� 842�㣩
     * СƱֽ���һ��Ϊ58mm�����Ϊ165��
     * pageIndex - Ҫ���Ƶ�ҳ��� 0 ��ʼ������ ����ҳ��
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//�� Graphics2D ����չ Graphics �࣬���ṩ�Լ�����״������ת������ɫ������ı����ָ�Ϊ���ӵĿ��ơ�
//���������� Java(tm) ƽ̨�ϳ��ֶ�ά��״���ı���ͼ��Ļ����ࡣ
        Graphics2D g2 = (Graphics2D) graphics;


        g2.setColor(Color.black);//���ô�ӡ��ɫΪ��ɫ

//��ӡ�������
        double x = pageFormat.getImageableX();  //������� PageFormat��ص� Paper����Ŀɳ����������Ϸ���� x���ꡣ
        double y = pageFormat.getImageableY();  //������� PageFormat��ص� Paper����Ŀɳ����������Ϸ���� y���ꡣ


//Font.PLAIN�� ��ͨ��ʽ����   Font.ITALIC б����ʽ����  Font.BOLD ������ʽ������
        Font font = new Font("����", Font.BOLD, 10); //����ָ�����ơ���ʽ�Ͱ�ֵ��С������һ���� Font��

        g2.setFont(font);//���ñ����ӡ����

        float heigth = font.getSize2D();///��ȡ����ĸ߶�

//����СƱ�ı������
        g2.drawString("No.3�̲��", (float) x + 25, (float) y + heigth);

        float line = 2 * heigth; //��һ�п�ʼ��ӡ�ĸ߶�
        g2.setFont(new Font("����", Font.PLAIN, 8));//������������
        heigth = font.getSize2D();// ����߶�

        line += 2;
//���ò���Ա
        g2.drawString("����Ա:" + operatorName, (float) x , (float) y + line);
        line += heigth;

//���ö�����
        g2.drawString("������:" + orderId, (float) x , (float) y + line);
        line += heigth + 2;

//���ñ���
        g2.drawString("����", (float) x , (float) y + line);
        g2.drawString("����", (float) x + 35, (float) y + line);
        g2.drawString("����", (float) x + 70, (float) y + line);
        g2.drawString("С��", (float) x + 105, (float) y + line);
        line += heigth;
        g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, new float[]{4.0f}, 0.0f));
        g2.drawLine((int) x, (int) (y + line), (int) x + 158, (int) (y + line));
        line += heigth;
        if (goods != null && goods.size() > 0) {
            for (Goods gdf : goods) {
                g2.drawString(gdf.getGname(), (float) x , (float) y + line);
                g2.drawString(gdf.getPrice(), (float) x + 40, (float) y + line);
                g2.drawString(gdf.getNum(), (float) x + 70, (float) y + line);
                g2.drawString(gdf.getTotal(), (float) x + 105, (float) y + line);
                line += heigth;
            }
        }
        g2.drawLine((int) x, (int) (y + line), (int) x + 158, (int) (y + line));
        line += heigth + 2;
        g2.drawString("��Ʒ����:" + totalGoodsNum + "��", (float) x, (float) y + line);
        g2.drawString("�ϼ�:" + totalPrice + " Ԫ", (float) x + 65, (float) y + line);
        line += heigth;
        g2.drawString("ʵ��:" + actualCollection + "Ԫ", (float) x , (float) y + line);
        g2.drawString("����:" + giveChange + "Ԫ", (float) x +65, (float) y + line);
        line += heigth;

        if (cardNumber != null && !"".equals(cardNumber)) {
            g2.drawString("��ǰ��Ա:" + cardNumber, (float) x + 15, (float) y + line);
            line += heigth;
            g2.drawString("����:" + integral, (float) x + 15, (float) y + line);
        }
        g2.drawString("ʱ��:" + sdf.format(orderDate), (float) x , (float) y + line);
        line += heigth;
        g2.drawString("ǮƱ�뵱����壬�뿪��̨ˡ������", (float) x , (float) y + line);
        line += heigth;
        g2.drawString("------------------------------------------", (float) x , (float) y + line);
        line += heigth;
        g2.drawString("------------------------------------------", (float) x , (float) y + line);
        line += heigth;
        g2.drawString("------------------------------------------", (float) x , (float) y + line);
        line += heigth;
        g2.drawString("------------------------------------------", (float) x , (float) y + line);
        switch (pageIndex) {
            case 0:
                return PAGE_EXISTS;  //0
            default:
                return NO_SUCH_PAGE;   //1
        }
    }
}

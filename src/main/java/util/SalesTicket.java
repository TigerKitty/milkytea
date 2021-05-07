package util;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SalesTicket implements Printable {
    private List<Goods> goods; //????б?
    private String operatorName; //?????
    private String orderId; //???????
    private String totalGoodsNum; //???????
    private String totalPrice; //????
    private String actualCollection; //????
    private String giveChange = "0"; //????
    private Date orderDate;


    private String cardNumber; //??????
    private String integral; //????

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
     * ???????
     * graphics - ?????????????????????????????
     * pageFormat - ???????????С???????????????????????С??????????λ????1/72 ??????λ??1????25.4?????A4??????595 ?? 842??
     * С?????????58mm??????165??
     * pageIndex - ?????????? 0 ????????? ???????
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//?? Graphics2D ????? Graphics ???????????????????????????????????????????????????
//?????????? Java(tm) ????????????????????????????
        Graphics2D g2 = (Graphics2D) graphics;


        g2.setColor(Color.black);//?????????????

//??????????
        double x = pageFormat.getImageableX();  //??????? PageFormat???? Paper????????????????????? x????
        double y = pageFormat.getImageableY();  //??????? PageFormat???? Paper????????????????????? y????


//Font.PLAIN?? ??????????   Font.ITALIC б?????????  Font.BOLD ?????????????
        Font font = new Font("????", Font.BOLD, 10); //?????????????????????С??????????? Font??

        g2.setFont(font);//?????????????

        float heigth = font.getSize2D();//??????????

//????С?????????
        g2.drawString("???????", (float) x + 25, (float) y + heigth);

        float line = 2 * heigth; //????п?????????
        g2.setFont(new Font("????", Font.PLAIN, 8));//????????????
        heigth = font.getSize2D();// ??????

        line += 2;
//???ò????
        g2.drawString("?????:" + operatorName, (float) x , (float) y + line);
        line += heigth;

//?????????
        g2.drawString("??????:" + orderId, (float) x , (float) y + line);
        line += heigth + 2;

//???????
        g2.drawString("????", (float) x , (float) y + line);
        g2.drawString("????", (float) x + 35, (float) y + line);
        g2.drawString("????", (float) x + 70, (float) y + line);
        g2.drawString("С??", (float) x + 105, (float) y + line);
        line += heigth;
        /*
         * ???????????    setStroke(Stroke):? Graphics2D ?????????? Stroke
         * ?? BasicStroke????????????????????????? Shape ??????????????????????????????? Shape ·????ε??????????????Ρ?
         * ??Щ?????????????
         * width????????????????????????????  ?????????????? 0.0f??0.0f??????????
         * end caps????δ?????·??????????ε?????????Щ??Ρ??????·????? CLOSE ?Σ??????????????????????·??????????δ?????
         * ???? CLOSE ?ε?????????????? SEG_CLOSE?????????????????
         * CAP_BUTT??????ε????δ??????·??????????Ρ?
         * CAP_ROUND????????????????????????ν???δ??????·??????????Ρ?
         * CAP_SQUARE??????????ν???δ??????·??????????Σ????????????ζ?????????????????????????
         * line joins????????·????ε???????????? SEG_CLOSE ??????·???????????????Ρ?
         * ???????????????
         * JOIN_BEVEL???????????????????????????·??????????????
         * JOIN_MITER?????·????ε???????????????????????
         * JOIN_ROUND??????????????????????????·??????????????
         * miter limit?????????? JOIN_MITER ??ε??????????????б????????????????? miterlimit ????????????????
         * б???????б?????????????????????????????????????????????γ?????С??б?????????????????????????
         * ??? miterlimit ?? 10.0f???????????С?? 11 ??????????á?????б????????????α??б??? ??????????? 1.0f??
         * dash attributes?????????????????????????????佻???γ??????????????塣 ???????????????
         * dash phase - ????????????????
         */
//????????
        g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, new float[]{4.0f}, 0.0f));
//??????????????????????????????? (x1, y1) ?? (x2, y2) ??仭?????? ??????????
        g2.drawLine((int) x, (int) (y + line), (int) x + 158, (int) (y + line));
        line += heigth;
//????????嵥
        if (goods != null && goods.size() > 0) {
            for (Goods gdf : goods) {
                g2.drawString(gdf.getGname(), (float) x , (float) y + line);
                g2.drawString(gdf.getPrice(), (float) x + 40, (float) y + line);
                g2.drawString(gdf.getNum(), (float) x + 70, (float) y + line);
                g2.drawString(gdf.getTotal(), (float) x + 105, (float) y + line);
                line += heigth;

                /*if (gdf.getBeiZhu() != null) {
                    //???????λ??
                    int i = gdf.getBeiZhu().lastIndexOf("??");
                    //??????????????
                    String ssss = gdf.getBeiZhu().substring(1, i-1);
                    //????????????????
                    g2.drawString(ssss, (float) x , (float) y + line);
                    line += heigth;
                }*/
            }
        }
        g2.drawLine((int) x, (int) (y + line), (int) x + 158, (int) (y + line));
        line += heigth + 2;
        g2.drawString("???????:" + totalGoodsNum + "??", (float) x, (float) y + line);
        g2.drawString("???:" + totalPrice + " ?", (float) x + 65, (float) y + line);
        line += heigth;
        g2.drawString("???:" + actualCollection + "?", (float) x , (float) y + line);
        g2.drawString("????:" + giveChange + "?", (float) x +65, (float) y + line);
        line += heigth;

        if (cardNumber != null && !"".equals(cardNumber)) {
            g2.drawString("??????:" + cardNumber, (float) x + 15, (float) y + line);
            line += heigth;
            g2.drawString("????:" + integral, (float) x + 15, (float) y + line);
        }
        g2.drawString("???:" + sdf.format(orderDate), (float) x , (float) y + line);
        line += heigth;
        g2.drawString("????????壬????????????", (float) x , (float) y + line);
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

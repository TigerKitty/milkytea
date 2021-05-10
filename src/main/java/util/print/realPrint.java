package util.print;

import java.util.*;

public class realPrint {

	public static boolean print(List<Goods> goods, String orderId){
		int totalPrice = 0;
		int actualCollection = 0;
		int giveChange = 0;
		int zhekou = 1;//�ۿ�
		String operatorName = "No3.�̲��";
		for (Goods good:goods){
			totalPrice+=Integer.valueOf(good.getTotal());//�ܼ۸�
		}
		actualCollection = totalPrice*zhekou;//ʵ����
		giveChange = totalPrice-actualCollection;//������
		int size = goods.size();
		String s = Integer.toString(size);
		Date date = new Date();
		SalesTicket stk = new SalesTicket(goods, operatorName, orderId, s, totalPrice+"", actualCollection+"", giveChange+"",date);
		Printer p = new Printer(stk);
		p.printer();
		return true;
	}
}
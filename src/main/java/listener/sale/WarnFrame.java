package listener.sale;

import javax.swing.*;

/**
 *�û�û����������ʱ���ﳵΪ�㣬�ύ����ʱ���������
 */
public class WarnFrame {
    public static void shopwarnFrame(){
        JFrame frame = new JFrame("���빺�ﳵʧ��");
        JOptionPane.showMessageDialog(frame, "���������",

                "���빺�ﳵʧ��", JOptionPane.WARNING_MESSAGE);
    }
    public static void orderwarnFrame(){
        JFrame frame = new JFrame("�ύ����ʧ��");
        JOptionPane.showMessageDialog(frame, "���Ĺ��ﳵΪ�㣬��ѡ����Ʒ",

                "�ύ����ʧ��", JOptionPane.WARNING_MESSAGE);
    }
    //�ӹ��ﳵɾ������ʱ�����ÿ�
    public static void deletewarnFrame(){
        JFrame frame = new JFrame("ɾ��ʧ��");
        JOptionPane.showMessageDialog(frame, "��û��ѡ����Ʒ����ѡ����Ʒ����ɾ��",

                "ɾ��ʧ��", JOptionPane.WARNING_MESSAGE);
    }
    public static void outlinePaywarnFrame(){
        JFrame frame = new JFrame("֧��ʧ��");
        JOptionPane.showMessageDialog(frame, "֧����ʱ�������½�������",

                "֧��ʧ��", JOptionPane.WARNING_MESSAGE);
    }
    public static void outlinePoswarnFrame(){
        JFrame frame = new JFrame("֧��ʧ��");
        JOptionPane.showMessageDialog(frame, "֧��ʧ��",

                "֧��ʧ��", JOptionPane.WARNING_MESSAGE);
    }
    public static void outlinePoswarnFrame1(){
        JFrame frame = new JFrame("֧���ɹ�");
        JOptionPane.showMessageDialog(frame, "֧���ɹ�",

                "֧���ɹ�", JOptionPane.WARNING_MESSAGE);
    }
    //�Ӽ�������
    public static void Add_subPoswarnFrame(){
        JFrame frame = new JFrame("�Ӽ�����ʧ��");
        JOptionPane.showMessageDialog(frame, "������Ӧ����Ʒ���мӼ�",

                "�Ӽ�����ʧ��", JOptionPane.WARNING_MESSAGE);
    }
    //��Ʒ��Ϣ�п�
    public static void productMes(){
        JFrame frame = new JFrame("��Ʒ��Ϣ����");
        JOptionPane.showMessageDialog(frame, "��ȷ����Ʒ��Ϣ",

                "��Ʒ��Ϣ����", JOptionPane.WARNING_MESSAGE);
    }

}

/*
 * Created by JFormDesigner on Wed May 12 00:02:07 CST 2021
 */

package swing.profitstatistics;

import entity.profit.DailyStatisBean;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author lbr
 * �ձ������
 * ÿ��ͳ�����ݵ���
 * ʹ��jxl��Jtable�ĵ���Excel
 * jxl.jar��ͨ��java����excel���Ĺ������
 */
public class AllDayStatisFrame extends JFrame {
    private static List<DailyStatisBean> list5;
    public AllDayStatisFrame(List<DailyStatisBean>list5) {
        this.list5=list5;
        initComponents(list5);
    }
    public void exportTable(JTable table1, File file) throws IOException {
        try {
            OutputStream out = new FileOutputStream(file);
            TableModel model = table1.getModel();
            WritableWorkbook wwb = Workbook.createWorkbook(out);
            // �����ֱ���д������
            WritableSheet ws = wwb.createSheet("�ձ���", 0);
            // ��ӱ���
            for (int i = 0; i < model.getColumnCount(); i++) {
                jxl.write.Label labelN = new jxl.write.Label(i, 0, model.getColumnName(i));
                try {
                    ws.addCell(labelN);
                } catch (RowsExceededException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
            // �����
            for (int i = 0; i < model.getColumnCount(); i++) {
                for (int j = 1; j <= model.getRowCount(); j++) {
                    jxl.write.Label labelN = new jxl.write.Label(i, j, model.getValueAt(j - 1, i).toString());
                    try {
                        ws.addCell(labelN);
                    } catch (RowsExceededException e) {
                        e.printStackTrace();
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }
                }
            }
            wwb.write();
            try {
                wwb.close();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "��������ǰ��رչ�����");
        }
    }
    private void initComponents(final List<DailyStatisBean>list5) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        this.setTitle("�ձ���");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();//��ʾÿ��ͳ������
        button1 = new JButton();//������ť

        String []name3 ={"ʱ�䣨�գ�","�ն�����","������","�����۶�","������"};
        Object tableDate3[][]=new Object[list5.size()][name3.length];
        for(int i=0;i<list5.size();i++) {
            for (int j = 0; j < name3.length; j++) {
                tableDate3[i][0] = list5.get(i).getDtime();
                tableDate3[i][1] = list5.get(i).getDorderquantity();
                tableDate3[i][2] = list5.get(i).getDsalesvolume();
                tableDate3[i][3] = list5.get(i).getDsales();
                tableDate3[i][4] = list5.get(i).getDprofit();
            }
        }
        DefaultTableModel tableModel3 = new DefaultTableModel(tableDate3, name3) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel3);
        /*
        ������������ݵ�������ǰĿ¼�µ�results.xls�ļ�
         */
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try {
                            exportTable(table1, new File("results.xls"));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            ex.printStackTrace();
                        }
                    }
                });

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 800, 425);

        //---- button1���� ----
        button1.setText("\u5bfc\u51fa");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 4f));
        contentPane.add(button1);
        button1.setBounds(665, 430, 115, 35);

        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

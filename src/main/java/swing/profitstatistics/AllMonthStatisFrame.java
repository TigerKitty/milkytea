/*
 * Created by JFormDesigner on Fri May 14 16:41:00 CST 2021
 */

package swing.profitstatistics;

import entity.profit.MonthlyStatisBean;
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
 */
public class AllMonthStatisFrame extends JFrame {
    private static List<MonthlyStatisBean> list6;
    public AllMonthStatisFrame(List<MonthlyStatisBean>list6) {
        this.list6=list6;
        initComponents(list6);
    }
    public void exportTable1(JTable table1, File file1) throws IOException {
        try {
            OutputStream out = new FileOutputStream(file1);
            TableModel model = table1.getModel();
            WritableWorkbook wwb = Workbook.createWorkbook(out);
            // 创建字表，并写入数据
            WritableSheet ws = wwb.createSheet("日报表", 0);
            // 添加标题
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
            // 添加列
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
            JOptionPane.showMessageDialog(null, "导入数据前请关闭工作表");
        }
    }

    private void initComponents(final List<MonthlyStatisBean> list6) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

        String []name4 ={"时间（月）","月订单量","月销量","月销售额","月利润"};
        Object tableDate4[][]=new Object[list6.size()][name4.length];
        for(int i=0;i<list6.size();i++) {
            for (int j = 0; j < name4.length; j++) {
                tableDate4[i][0] = list6.get(i).getMtime();
                tableDate4[i][1] = list6.get(i).getMorderquantity();
                tableDate4[i][2] = list6.get(i).getMsalesvolume();
                tableDate4[i][3] = list6.get(i).getMsales();
                tableDate4[i][4] = list6.get(i).getMprofit();
            }
        }
        DefaultTableModel tableModel3 = new DefaultTableModel(tableDate4, name4) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel3);

        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try {
                            exportTable1(table1, new File("results1.xls"));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            ex.printStackTrace();
                        }
                    }
                });

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 800, 425);

        //---- button1 ----
        button1.setText("\u5bfc\u51fa");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 5f));
        contentPane.add(button1);
        button1.setBounds(660, 430, 115, 35);

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

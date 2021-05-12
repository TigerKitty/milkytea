package dao.Underway;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Refresh {
    public JTable jTble;
    GetDate getDate = new GetDate();
    public void Refresh(JTable jTable){
        this.jTble = jTable;
        DefaultTableModel tableMode = new DefaultTableModel(getDate.UsersData(), getDate.head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable.setModel(tableMode);
    }
}

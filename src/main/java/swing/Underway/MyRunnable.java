package swing.Underway;


import dao.Underway.Automatic;
import javax.swing.*;
class MyRunnable implements Runnable{
    JTable jTable;
    public MyRunnable(JTable jTable){
        this.jTable=jTable;
    }
    public void run(){
        Automatic automatic = new Automatic();
        while (true) {
            try {
                Thread.sleep(1000);
                automatic.Automatic(jTable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

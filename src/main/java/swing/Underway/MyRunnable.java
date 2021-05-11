package swing.Underway;

import dao.Underway.Automatic;

class MyRunnable implements Runnable{
    public void run(){
        Automatic automatic = new Automatic();
        while (true) {
            try {
                Thread.sleep(1000);
                automatic.right();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

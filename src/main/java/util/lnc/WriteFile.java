package util.lnc;

import java.io.*;

public class WriteFile {
    public void writeFile(String s){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("F:/testvoice.txt");
            byte[] b = s.getBytes();
            fos.write(b);
            // 强行将缓冲区中的内容输出
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package gdut.miaomiao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtIOput {
    private String article;

    public TxtIOput() {
    }

    public TxtIOput(String address) throws IOException {
        setArticle(address);
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String address) throws IOException {
        try {
            FileReader fr = new FileReader(address);
            StringBuilder sb = new StringBuilder();
            int ch;
            while (true) {
                try {
                    if ((ch = fr.read()) != -1) {
                        sb.append((char) ch);
                    } else break;
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
            fr.close();
            this.article = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printResult(String address, double result) throws IOException {
        FileWriter fw = new FileWriter(address);
        fw.write(String.format("%.2f",result));
        fw.close();
    }
}

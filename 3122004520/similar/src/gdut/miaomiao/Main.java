package gdut.miaomiao;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TxtIOput tio1 = new TxtIOput(args[1]);
        TxtIOput tio2 = new TxtIOput(args[0]);
        Sentence s = new Sentence(tio1.getArticle(),tio2.getArticle());
        double d = s.Similarity();
        tio1.printResult(args[2],d);
    }
}

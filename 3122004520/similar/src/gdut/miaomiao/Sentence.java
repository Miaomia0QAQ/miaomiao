package gdut.miaomiao;

import java.util.HashMap;

public class Sentence {
    private String str1;    //抄袭文
    private char[] s1;
    private String str2;    //原论文
    private int len1;      //抄袭文长度

    Sentence() {
    }

    public Sentence(String str1, String str2) {
        this.str1 = delete(str1);
        this.str2 = delete(str2);
        s1 = this.str1.toCharArray();
        this.len1 = s1.length;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.len1 = str1.length();
        this.str1 = str1;
        s1 = str1.toCharArray();
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public double Similarity() {
        HashMap<Integer, Integer> map = new HashMap<>();
        isSimilar(map);
        double rs = 0;
        for (int i = 0; i < len1; i++) {
            if (map.get(i) == 1) {
                rs++;
            }
        }
        return rs / len1;
    }

    private void isSimilar(HashMap<Integer, Integer> map) {
        for (int i = 0; i < len1; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < len1; i++) {
            if (map.get(i) == 0) {
                int k = -1;
                do {
                    k = str2.indexOf(s1[i], k + 1);
                    for (int j = 1; j + i < len1 && j + k < str2.length(); j++) {
                        if (s1[i + j] == str2.charAt(k + j)) {
                            map.put(i + j, 1);
                            if (map.get(i) == 0) {
                                map.put(i, 1);
                            }
                        } else {
                            break;
                        }
                    }
                } while (k != -1);
            }
        }
    }

    private String delete(String str) {
        return str.replaceAll("[\\s，。：“”、！；《》（）*+\\-/]", "");
    }
}
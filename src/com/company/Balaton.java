package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balaton extends Matrix {
    public Balaton() {
        super(getSorok(), getOszlopok());
        init();
    }

    static private List<String> getFajlTartalom() throws IOException {
        return Files.readAllLines(Paths.get("balaton.txt"), StandardCharsets.UTF_8);
    }

    static private int getSorok() {
        try {
            List<String> sorok = getFajlTartalom();
            return sorok.size();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    static private int getOszlopok() {
        try {
            List<String> sorok = getFajlTartalom();
            return sorok.get(0).length();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void init() {
        try {
            List<String> sorok = getFajlTartalom();
            this.matrix = new int[sorokSzama][oszlopokSzama];
            for (int i = 1; i < sorokSzama; i++) {
                String[] temp = sorok.get(i).split("\t", -1);
                for (int j = 0; j < oszlopokSzama; j++) {
                    if (Objects.equals(temp[j], "")) {
                        this.setElem(i, j, 0);
                    } else {
                        this.setElem(i, j, Integer.parseInt(temp[j]));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private boolean isPart(int x, int y) {
        boolean ki = false;
        if(getElem(x,y)==0){
            ki = false;
        } else if (!(x == 0 || y == 0 || x == sorokSzama - 1 || y == oszlopokSzama - 1)) {
            int i = x - 1;
            int j;
            boolean ok = false;
            while (i < x + 2 && !ok) {
                j = y - 1;
                while (j < y + 2 && getElem(i, j) != 0) {
                    j++;
                }
                if (j == y+2) {
                    i++;
                } else {
                    ok = true;
                }
            }
            ki = ok;
        } else {
            ki = true;
        }
        return ki;
    }


    public String kiPartok() {
        StringBuilder sorok = new StringBuilder();
        for (int i = 0; i < this.getSorokSzama(); i++) {
            for (int j = 0; j < this.getOszlopokSzama(); j++) {
                int tag = this.getElem(i, j);
                if (tag ==0) {
                    sorok.append("####");
                } else if (isPart(i, j)) {
                    sorok.append(this.getElem(i, j)).append("\t");
                } else {
                    sorok.append("████");
                }
            }
            sorok.append('\n');
        }
        return sorok.toString();
    }
}

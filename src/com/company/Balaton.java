package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Balaton extends Matrix {
    public Balaton() {
        try {
            List<String> sorok = Files.readAllLines(Paths.get("balaton.txt"), StandardCharsets.UTF_8);
            int sorokSzama = sorok.size();
            int oszlopokSzama = sorok.get(0).split("\t").length;
            this.sorokSzama = sorokSzama;
            this.oszlopokSzama = oszlopokSzama;
            this.matrix = new int[sorokSzama][oszlopokSzama];
            for (int i = 0; i < sorokSzama; i++) {
                String[] temp = sorok.get(i).split("\t");
                for (int j = 0; j < oszlopokSzama; j++) {
                    this.setElem(i, j, Integer.parseInt(temp[j]));
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

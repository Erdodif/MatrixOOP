package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
    protected int sorokSzama;
    protected int oszlopokSzama;
    protected int[][] matrix;

    public Matrix(int sorokSzama, int oszlopokSzama) {
        this.sorokSzama = sorokSzama;
        this.oszlopokSzama = oszlopokSzama;
        this.matrix = new int[sorokSzama][oszlopokSzama];
    }

    public Matrix() {
        this.sorokSzama = (int) (Math.random() * 11) + 5;
        this.oszlopokSzama = (int) (Math.random() * 11) + 5;
        this.matrix = new int[sorokSzama][oszlopokSzama];
        feltolt();
    }

    protected void feltolt() {
        for (int i = 0; i < this.sorokSzama; i++) {
            for (int j = 0; j < this.oszlopokSzama; j++) {
                this.matrix[i][j] = ((int) (Math.random() * 90) + 10);
            }
        }
    }

    public int getSorokSzama() {
        return sorokSzama;
    }

    public int getOszlopokSzama() {
        return oszlopokSzama;
    }

    public int getElem(int x, int y) {
        return this.matrix[x][y];
    }

    public void setElem(int x, int y, int ertek){
        this.matrix[x][y] = ertek;
    }

    public boolean isNegyzetes() {
        return sorokSzama == oszlopokSzama;
    }

    public long getOsszErtek() {
        long sum = 0;
        for (int i = 0; i < this.sorokSzama; i++) {
            for (int j = 0; j < this.oszlopokSzama; j++) {
                sum += this.getElem(i, j);
            }
        }
        return sum;
    }

    public int getParosDarab() {
        int count = 0;
        for (int i = 0; i < this.sorokSzama; i++) {
            for (int j = 0; j < this.oszlopokSzama; j++) {
                if (this.getElem(i, j) % 2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getMax() {
        int maxi = this.getElem(0, 0);
        for (int i = 0; i < this.sorokSzama; i++) {
            for (int j = 0; j < this.oszlopokSzama; j++) {
                int temp = this.getElem(i, j);
                if (temp > maxi) {
                    maxi = temp;
                }
            }
        }
        return maxi;
    }

    public int getElsoParos() {
        int i = 0;
        int j;
        boolean ok = false;
        int ki = -1;
        while (i < this.sorokSzama && !ok) {
            j = 0;
            while (j < this.getOszlopokSzama() && this.getElem(i, j) % 2 != 0) {
                j++;
            }
            if (j < this.getOszlopokSzama() && this.getElem(i, j) % 2 == 0) {
                ok = true;
                ki = this.getElem(i, j);
            } else {
                i++;
            }
        }
        return ki;
    }


    @Override
    public String toString() {
        StringBuilder sorok = new StringBuilder();
        for (int i = 0; i < this.getSorokSzama(); i++) {
            for (int j = 0; j < this.getOszlopokSzama(); j++) {
                sorok.append(this.getElem(i, j)).append("\t");
            }
            sorok.append('\n');
        }
        return sorok.toString();
    }
}

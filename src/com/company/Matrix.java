package com.company;

import java.util.Arrays;

public class Matrix {
    private int sorokSzama;
    private int oszlopokSzama;
    private int[][] matrix;

    public Matrix(int sorokSzama, int oszlopokSzama){
        this.sorokSzama = sorokSzama;
        this.oszlopokSzama = oszlopokSzama;
        this.matrix = new int[sorokSzama][oszlopokSzama];
    }

    public Matrix(){
        this.sorokSzama = (int)(Math.random()*11)+5;
        this.oszlopokSzama = (int)(Math.random()*11)+5;
        this.matrix = new int[sorokSzama][oszlopokSzama];
        for(int i = 0; i < this.sorokSzama; i++){
            for (int j = 0; j < this.oszlopokSzama; j++){
                this.matrix[i][j] = ((int)(Math.random()*90)+10)
            }
        }
    }

    public boolean isNegyzetes(){
        return sorokSzama == oszlopokSzama;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}

package com.company;

public class NegyzetesMatrix extends Matrix {

    public NegyzetesMatrix(int sorokSzama) {
        super(sorokSzama, sorokSzama);
        feltolt();
    }

    public NegyzetesMatrix() {
        this((int) (Math.random() * 11) + 5);
        feltolt();
    }

    public long getFoatloOsszeg() {
        long sum = 0;
        for (int i = 0; i < this.getSorokSzama(); i++) {
            sum += this.getElem(i, i);
        }
        return sum;
    }

    public int getMellekatloLegnagyobb(){
        int maxi = getElem(0,sorokSzama-1);
        for (int i = 0; i < this.getSorokSzama(); i++) {
            int temp = getElem(i,sorokSzama-1-i);
            if (temp>maxi){
                maxi = temp;
            }
        }
        return maxi;
    }
}

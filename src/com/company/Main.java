package com.company;

public class Main {

    public static void ki(String cim, String tartalom) {
        System.out.println(cim + ": " + tartalom);
    }
    public static void ki(String cim, long tartalom) {
        System.out.println(cim + ": " + tartalom);
    }
    public static void ki(String cim, int tartalom) {
        System.out.println(cim + ": " + tartalom);
    }
    public static void kiln(String cim, String tartalom) {
        System.out.println(cim + ":\n" + tartalom);
    }
    public static void kiln(String cim, long tartalom) {
        System.out.println(cim + ":\n" + tartalom);
    }
    public static void kiln(String cim, int tartalom) {
        System.out.println(cim + ":\n" + tartalom);
    }

    public static void elsoFeladatok(){
        Matrix m = new Matrix();
        System.out.println(m);
        ki("Négyzetes-e",(m.isNegyzetes() ? "igen" : "nem"));
        ki("A mátrix mérete",m.getSorokSzama() + "x" + m.getOszlopokSzama());
        ki("Összérték",m.getOsszErtek());
        ki("Párosok száma",m.getParosDarab());
        ki("Első páros szám",m.getElsoParos());
    }

    public static void nemLetezoFeladatok(){
        Balaton nemLetezik = new Balaton();
        kiln("Hőmérsékletek",nemLetezik.toString());
    }

    public static void main(String[] args) {
        //elsoFeladatok();
        nemLetezoFeladatok();
    }
}

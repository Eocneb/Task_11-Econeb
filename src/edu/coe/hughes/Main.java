package edu.coe.hughes;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new CalcController(new CalcModel(), new CalcView());
    }
}
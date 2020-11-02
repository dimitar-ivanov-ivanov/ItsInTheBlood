package com.company;

import com.company.models.Cell;
import com.company.models.cells.RedBloodCell;
import com.company.models.cells.WhiteBloodCell;
import com.company.models.microbes.Bacteria;

public class Main {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        WhiteBloodCell whiteBloodCell = new WhiteBloodCell("WBC", 100, 5, 5, 50);
        RedBloodCell redBloodCell = new RedBloodCell("RBC", 100, 5, 5, 100);
        Bacteria bacteria = new Bacteria("BC", 100, 10, 10, 100);
    }
}

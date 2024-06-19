package org.example.lld.pen.pens;

import org.example.lld.pen.CloseType;
import org.example.lld.pen.Ink;
import org.example.lld.pen.Pen;
import org.example.lld.pen.PenType;

public class FountainPen extends Pen {
    Ink ink;
    int inkLeft;
    int maxInk;

    public FountainPen(String brand, float price, Ink ink, int inkLeft, int maxInk) {
        super(PenType.FOUNTAIN, CloseType.CAP, brand, price);
        this.ink = ink;
        this.inkLeft = inkLeft;
        this.maxInk = maxInk;
    }


    @Override
    public void write() {
        System.out.println("This is a FountainPen writing with ink " + ink.getColor());
    }

    public boolean refillInk(Ink ink, int quantity) {
        this.ink = ink;
        if (maxInk < quantity)
            return false;
        inkLeft = quantity;
        return true;
    }
}

package org.example.lld.pen.pens;

import org.example.lld.pen.CloseType;
import org.example.lld.pen.Ink;
import org.example.lld.pen.Pen;
import org.example.lld.pen.PenType;

public class UseAndThrowPen extends Pen {
    public UseAndThrowPen( CloseType closeType, String brand, float price, Ink ink, int inkQuantity) {
        super(PenType.BALL_POINT, closeType, brand, price);
        this.ink = ink;
        this.inkQuantity = inkQuantity;
    }

    Ink ink;

    int inkQuantity;
    @Override
    public void write() {
        if(inkQuantity > 0) {
            System.out.println("This is a Use and throw pen writing with " + ink.getColor() + " color ink");
            inkQuantity--;
        }
        else {
            //throw error here for no ink left to write
            //similar thing can be done for most
        }

    }

    public Ink getInk() {
        return ink;
    }

    public int getInkQuantity() {
        return inkQuantity;
    }
}

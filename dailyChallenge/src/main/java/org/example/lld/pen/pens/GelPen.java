package org.example.lld.pen.pens;

import org.example.lld.pen.CloseType;
import org.example.lld.pen.Pen;
import org.example.lld.pen.PenType;
import org.example.lld.pen.Refill;

public class GelPen extends Pen implements RefillablePen{
    Refill refill;
    @Override
    public void write() {
        System.out.println("This is a refillable Gel Pen writing with "+refill.getInk().getColor()+" color ink");
    }

    @Override
    public Refill getRefill() {
        return refill;
    }

    @Override
    public boolean refillPen(Refill refill) {
        this.refill=refill;
        return true;
    }

    public GelPen( CloseType closeType, String brand, float price, Refill refill) {
        super(PenType.GEL_PEN, closeType, brand, price);
        this.refill = refill;
    }
}

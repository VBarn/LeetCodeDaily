package org.example.lld.pen.pens;

import org.example.lld.pen.CloseType;
import org.example.lld.pen.Pen;
import org.example.lld.pen.PenType;
import org.example.lld.pen.Refill;

public class BallPointPen extends Pen implements RefillablePen {
    Refill refill;

    public BallPointPen(PenType penType, CloseType closeType, String brand, float price, Refill refill) {
        super(PenType.BALL_POINT, closeType, brand, price);
        this.refill = refill;
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

    @Override
    public void write() {
        System.out.println("This is a refillable Ballpoint writing with "+this.getRefill().getInk().getColor()+" color ink");
    }
}

package org.example.lld.pen.pens;

import org.example.lld.pen.Refill;

public interface RefillablePen{
    Refill getRefill();

    boolean refillPen(Refill refill);
}

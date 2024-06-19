package org.example.lld.pen;

public class Refill {
    public Refill(Ink ink, NIB nib) {
        this.ink = ink;
        this.nib = nib;
    }

    public Ink getInk() {
        return ink;
    }

    public NIB getNib() {
        return nib;
    }

    Ink ink;
    NIB nib;
}
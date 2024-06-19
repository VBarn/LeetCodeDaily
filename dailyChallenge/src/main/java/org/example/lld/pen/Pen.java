package org.example.lld.pen;

public abstract class Pen {
    PenType penType;
    CloseType closeType;

    String brand;

    float price;

    protected Pen(PenType penType, CloseType closeType, String brand, float price) {
        this.penType = penType;
        this.closeType = closeType;
        this.brand = brand;
        this.price = price;
    }


    public abstract void write();

    public boolean open() {
        try {
            closeType.open();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean close() {
        try {
            closeType.close();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
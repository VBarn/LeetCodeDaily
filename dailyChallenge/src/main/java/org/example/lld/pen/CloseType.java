package org.example.lld.pen;

public enum CloseType {
    CLICK {
        @Override
        public void open() {

        }

        @Override
        public void close() {

        }
    },CAP {
        @Override
        public void open() {

        }

        @Override
        public void close() {

        }
    },ROTATE {
        @Override
        public void open() {

        }

        @Override
        public void close() {

        }
    };

    public abstract void open();
    public abstract void close();
}

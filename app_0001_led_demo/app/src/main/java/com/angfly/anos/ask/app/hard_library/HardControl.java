package com.angfly.anos.ask.app.hard_library;

public class HardControl {

    public static native int ledCtrl(int which, int status);
    public static native int ledOpen();
    public static native void ledClose();

    static {
        try {
            System.loadLibrary("hard_control");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
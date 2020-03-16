package com.edu.cgbd.pojo;

public abstract class CgbdRecording {
    protected String id;

    abstract void Download();

    abstract void Play();

    void Export() {

    }
}

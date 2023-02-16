package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.Servo;
public class Grabber {
    public Servo Servo1;
    public Servo Servo2;
    public Servo Servo3;
    public double angle = 0;

    public void start() {
        Servo1.setPosition(0.35);
        Servo2.setPosition(0);
        tilter();
    }
    public void end() {
        Servo1.setPosition(0.08);
        Servo2.setPosition(0.27);
    }
    public void tilt(){
        angle = angle -0.01;
        tilter();
    }
    public void nottilt(){
        angle = angle +0.01;
        tilter();
    }
    public void tilter(){
        Servo3.setPosition(angle);
    }
}

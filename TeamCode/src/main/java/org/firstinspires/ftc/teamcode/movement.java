package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.ArrayList;

//import com.qualcomm.robotcore.hardware.HardwareDevice;
//import com.qualcomm.robotcore.hardware.HardwareMap;

public class movement {
    m1 is front right, m2 front left, m3 back right, m4 back right
    public DcMotor Motor1; // front right
    public DcMotor Motor2; // front left
    public DcMotor Motor3; // back left
    public DcMotor Motor4; // back right

    public movement(ArrayList<DcMotor> motors) {
        Motor1 = motors.get(0);
        Motor2 = motors.get(1);
        Motor3 = motors.get(2);
        Motor4 = motors.get(3);
    }

    //stop movement
    public void stop(){
        Motor1.setPower(0); // FR
        Motor2.setPower(0); // FL
        Motor3.setPower(0); // BL
        Motor4.setPower(0); // BR
    }

    //vertical movement
    public void verticalMovement(float power){
        power = (float) (power * 0.5);
        Motor1.setPower(power * 1); // FR = 0.5
        Motor2.setPower(power * 1); // FL = 0.5
        Motor3.setPower(power * 1); // BL = 0.5
        Motor4.setPower(power * 1); // BR = 0.5
    }
    //horizontal movement
    public void horizontalMovement(float power){
        power = (float) (power * 0.5);
        Motor1.setPower(power * -1); // FR = -0.5
        Motor2.setPower(power * 1); // FL = 0.5
        Motor3.setPower(power * -1); // BL = -0.5
        Motor4.setPower(power * 1); // BR = 0.5
    }
    //counter-clockwise rotation
    public void rotateMovement(float power){
        power = (float) (power * 0.5);
        Motor1.setPower(power); // FR = 0.5
        Motor2.setPower(power); // FL = 0.5
        Motor3.setPower(power); // BL = 0.5
        Motor4.setPower(power); // BR = 0.5
    }
    /*
    public void telmotor(){
        telemetry.addData("Motor1", Motor1);
        telemetry.addData("Motor2", Motor2);
        telemetry.addData("Motor3", Motor3);
        telemetry.addData("Motor4", Motor4);
        telemetry.update();
    }
    */
}

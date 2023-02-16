package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.ArrayList;
import java.util.List;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Last defender")

public class mainer extends LinearOpMode {
    private DcMotor Motor1;
    private DcMotor Motor2;
    private DcMotor Motor3;
    private DcMotor Motor4;
    private DcMotor Motor5;
    private DcMotor Motor6;
    private DcMotor Motor7;

    private Servo Servo1;
    private Servo Servo2;
    private Servo Servo3;
    public double tiltangle = 0;

    @Override
    public void runOpMode() {

        /**
         * Initialize hardware here.
         */
        Motor1 = hardwareMap.dcMotor.get("Motor1");
        Motor2 = hardwareMap.dcMotor.get("Motor2");
        Motor3 = hardwareMap.dcMotor.get("Motor3");
        Motor4 = hardwareMap.dcMotor.get("Motor4");

        Motor5 = hardwareMap.dcMotor.get("Motor5");
        Motor6 = hardwareMap.dcMotor.get("Motor6");

        Motor7 = hardwareMap.dcMotor.get("Motor7");

        Servo1 = hardwareMap.get(Servo.class, "Servo1");
        Servo2 = hardwareMap.get(Servo.class, "Servo2");
        Servo3 = hardwareMap.get(Servo.class, "Servo3");



        waitForStart();

        while (opModeIsActive()){
            gamepader();
        }
    }
    //gamepad input
    public void gamepader(){
        movementmethod1();

        if(Math.abs(gamepad1.right_stick_x) > 0){
            Motor1.setPower(gamepad1.right_stick_x);
            Motor2.setPower(gamepad1.right_stick_x);
            Motor3.setPower(gamepad1.right_stick_x);
            Motor4.setPower(gamepad1.right_stick_x);
        }
        if(gamepad1.circle){
            Servo1.setPosition(0.35);
            Servo2.setPosition(0);
        }else if(gamepad1.square){
            Servo1.setPosition(0.08);
            Servo2.setPosition(0.27);
        }

        if(gamepad1.dpad_up){
            Motor7.setPower(-1);
        }else if(gamepad1.dpad_down){
            Motor7.setPower(1);
        }
        Motor7.setPower(0);

        if(gamepad1.triangle){
            tiltangle = tiltangle -0.01;
            Servo3.setPosition(tiltangle);
        }else if(gamepad1.cross){
            tiltangle = tiltangle +0.01;
            Servo3.setPosition(tiltangle);
        }
        if (gamepad1.left_bumper){
            Motor5.setPower(-0.7);
            Motor6.setPower(0.7);
        } else if(gamepad1.right_bumper){
            Motor5.setPower(0.7);
            Motor6.setPower(-0.7);
        }
        Motor5.setPower(0);
        Motor6.setPower(0);

        logger();
    }
    public void movementmethod1(){
        float power = gamepad1.left_stick_y;
        if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
            power = (float) (power * 0.5);
            Motor1.setPower(power * 1);
            Motor2.setPower(power * 1);
            Motor3.setPower(power *1);
            Motor4.setPower(power * 1);
        } else if (Math.abs(gamepad1.left_stick_x) < Math.abs(gamepad1.left_stick_y)) {
            power = (float) (power * 0.5);
            Motor1.setPower(power * -1);
            Motor2.setPower(power * 1);
            Motor3.setPower(power * -1);
            Motor4.setPower(power * 1);
        } else if(gamepad1.left_stick_x == gamepad1.left_stick_y){
            Motor1.setPower(0);
            Motor2.setPower(0);
            Motor3.setPower(0);
            Motor4.setPower(0);
        }
    }
    public void movementmethod2(){
        if (gamepad1.left_stick_x == gamepad1.left_stick_y || Math.abs(gamepad1.left_stick_x)<0.05||Math.abs(gamepad1.left_stick_y)<0.05){
            Motor1.setPower(0);
            Motor2.setPower(0);
            Motor3.setPower(0);
            Motor4.setPower(0);
        }else{
            Motor1.setPower(gamepad1.left_stick_x * -1+gamepad1.left_stick_y);
            Motor2.setPower(gamepad1.left_stick_x * 1+gamepad1.left_stick_y);
            Motor3.setPower(gamepad1.left_stick_x * -1+gamepad1.left_stick_y*-1);
            Motor4.setPower(gamepad1.left_stick_x * 1+gamepad1.left_stick_y*-1);
        }
    }

    public void logger(){
        telemetry.addData("LeftY", gamepad1.left_stick_y);
        telemetry.addData("LeftX", gamepad1.left_stick_x);
        telemetry.addData("Leftfront", Motor1.getPower());
        telemetry.addData("Rightfront", Motor2.getPower());
        telemetry.addData("Leftback", Motor3.getPower());
        telemetry.addData("Rightback", Motor4.getPower());
        telemetry.addData("Circle", gamepad1.circle);
        telemetry.addData("Square", gamepad1.square);
        telemetry.addData("Servo1(leftfront)", Servo1.getPosition());
        telemetry.addData("Servo2(rightfront)", Servo2.getPosition());

        telemetry.addData("Cross", gamepad1.cross);
        telemetry.addData("Triangle", gamepad1.triangle);
        telemetry.addData("Servo3(tilter)", Servo3.getPosition());
        telemetry.addData("Tiltangle", tiltangle);

        telemetry.addData("Dpaddown", gamepad1.dpad_down);
        telemetry.addData("Dpadup", gamepad1.dpad_up);
        telemetry.addData("Motor7", Motor7.getPower());

        telemetry.addData("Leftbumper", gamepad1.left_bumper);
        telemetry.addData("Rightbumper", gamepad1.right_bumper);
        telemetry.addData("Motor5(Lift)", Motor5.getPower());
        telemetry.addData("Motor6(Lift)", Motor6.getPower());
        telemetry.update();
    }
}

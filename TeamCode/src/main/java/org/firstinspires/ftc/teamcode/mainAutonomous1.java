package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.ArrayList;


@Autonomous(name = "donga-auto1")

public class mainAutonomous1 extends LinearOpMode {
    movement movement = null;
//    movement movement = new movement(hardwareMap.get(DcMotor.class, "Motor1"),hardwareMap.get(DcMotor.class, "Motor2"),hardwareMap.get(DcMotor.class, "Motor3"),hardwareMap.get(DcMotor.class, "Motor4"));

    sensor sensor = new sensor();
    composetelemetry composetelemetry = new composetelemetry();

    ARM ARM = new ARM();
    Grabber Grabber= new Grabber();

    @Override
    public void runOpMode() {

        /**
         * Initialize hardware here.
         */
        DcMotor motor1, motor2, motor3, motor4;
        motor1 = hardwareMap.dcMotor.get("Motor1");
        motor2 = hardwareMap.dcMotor.get("Motor2");
        motor3 = hardwareMap.dcMotor.get("Motor3");
        motor4 = hardwareMap.dcMotor.get("Motor4");


        // Put hardware into a global list
        ArrayList<DcMotor> movement_motors = new ArrayList<>();
        movement_motors.add(motor1);
        movement_motors.add(motor2);
        movement_motors.add(motor3);
        movement_motors.add(motor4);

        movement = new movement(movement_motors);

        //initialize motors

        ARM.Motor5 = hardwareMap.get(DcMotor.class, "Motor5");
        ARM.Motor6 = hardwareMap.get(DcMotor.class, "Motor6");
        ARM.Motor7 = hardwareMap.get(DcMotor.class, "Motor6");

        //initialize sensor
        sensor.imu = hardwareMap.get(BNO055IMU.class, "imu");
        sensor.sensorIntitialize();
        sensor.imu.initialize(sensor.parameters);

        waitForStart();

        if(opModeIsActive()){

        }

        while (opModeIsActive()){

        }
    }
    public void logger(){
        telemetry.addData("LeftY", gamepad1.left_stick_y);
        telemetry.addData("LeftX", gamepad1.left_stick_x);
        telemetry.addData("Leftfront", movement.Motor1.getPower());
        telemetry.addData("Rightfront", movement.Motor2.getPower());
        telemetry.addData("Leftback", movement.Motor3.getPower());
        telemetry.addData("Rightback", movement.Motor4.getPower());
        telemetry.update();
    }
}

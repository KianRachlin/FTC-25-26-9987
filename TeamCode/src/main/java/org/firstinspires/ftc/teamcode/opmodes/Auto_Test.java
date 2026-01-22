package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
// Name changes for all ()
@Autonomous(name = "Auto_Test")
public class Auto_Test extends LinearOpMode {

    // Initilizing Motors & Servo

    // Motors
    private DcMotor rightFront;
    private DcMotor rightRear;
    private DcMotor leftFront;
    private DcMotor leftRear;


    @Override
    public void runOpMode() {

        // Setting Motors & Servo
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");

        waitForStart();
        if (opModeIsActive()) {

            // Reverse Motor Directions
            rightFront.setDirection(DcMotor.Direction.REVERSE);
            rightRear.setDirection(DcMotor.Direction.REVERSE);

            forward();
            sleep(400);
            left();
            sleep(200);
            halt();
            forward();
            sleep(100);
            backward();
            sleep(75);
            halt();
            left();
            sleep(100);
            halt();
            forward();
            sleep(150);
            halt();
            right();
            sleep(100);
            forward();
            sleep(50);
            halt();

        }
    }
  
  
  
  /*
  MOVEMENT:
  - STOP: halt()
  - FORWARD: forward()
  - BACKWARD: backward()
  TURNS:
  - RIGHT (15: ??ms, 45: ??ms, 90: ??ms): right()
  - LEFT (15: ??ms, 45: ??ms, 90: ??ms): left()
  STRAFE:
  - STRAFE RIGHT: sRight()
  - STRAFE LEFT: sLeft()
  OTHER:
  - SERVO RELEASE: servoRelease(How many releases)
  */


    //  MOVEMENT METHODS  //

    // STOP/HALT //
    public void halt() { leftFront.setPower(0); rightFront.setPower(0); leftRear.setPower(0); rightRear.setPower(0); }


    // FORWARD //
    double forwardPower = 0.65;
    int forwardDelay = 235;
    public void forward() { leftRear.setPower(forwardPower); rightRear.setPower(forwardPower); sleep(forwardDelay); leftFront.setPower(forwardPower); rightFront.setPower(forwardPower); }


    // BACKWARD //
    double backwardPower = -0.65;
    int backwardDelay = 235;
    public void backward() { leftFront.setPower(backwardPower); rightFront.setPower(backwardPower); sleep(backwardDelay); leftRear.setPower(backwardPower); rightRear.setPower(backwardPower); }


    //  TURN METHODS //

    // RIGHT //
    double rightPower = 0.65;
    public void right() { leftFront.setPower(rightPower); rightFront.setPower(0); leftRear.setPower(rightPower); rightRear.setPower(0);}


    // LEFT //
    double leftPower = 0.65;
    public void left() { leftFront.setPower(0); rightFront.setPower(leftPower); leftRear.setPower(0); rightRear.setPower(leftPower); }


    // STRAFE METHODS //

    //  STRAFE RIGHT //
    double strafeRightPower = 0.65;
    public void sRight() { leftFront.setPower(strafeRightPower); rightFront.setPower(-strafeRightPower); leftRear.setPower(strafeRightPower); rightRear.setPower(-strafeRightPower);}


    //  STRAFE LEFT
    double strafeLeftPower = 0.65;
    public void sLeft() { leftFront.setPower(-strafeLeftPower); rightFront.setPower(strafeLeftPower); leftRear.setPower(-strafeLeftPower); rightRear.setPower(strafeLeftPower);}
}

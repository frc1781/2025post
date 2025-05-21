package frc.robot.subsystems;


import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.util.function.BooleanSupplier;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import CRA.CRASparkMax;

public class Climber extends SubsystemBase {

    private RelativeEncoder armEncoder;
    private double requestedPosition;
    private double climberDutyCycle;
    private PIDController climberPID;
    private final double gravityDutyCycle = 0.0;
    private SparkMax leverMotor;
    private ArmFeedforward armFeedforward;

     public Climber() {
        leverMotor = new SparkMax(Constants.Climber.MOTOR, SparkLowLevel.MotorType.kBrushless);

        SparkMaxConfig leverMotorConfig = new SparkMaxConfig();
        leverMotorConfig.idleMode(SparkBaseConfig.IdleMode.kBrake);
        leverMotorConfig.inverted(true);
        leverMotorConfig.encoder.positionConversionFactor(Constants.Climber.RADIANS_PER_REVOLUTION);
        leverMotorConfig.closedLoop.apply(Constants.Climber.CLOSED_LOOP_CONFIG);

        leverMotor.configure(leverMotorConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);

        armFeedforward = new ArmFeedforward(Constants.Climber.KS, Constants.Climber.KG, Constants.Climber.KV);
        armEncoder = leverMotor.getEncoder();
        requestedPosition = armEncoder.getPosition();
        armFeedforward = new ArmFeedforward(Constants.Climber.KS, Constants.Climber.KG, Constants.Climber.KV);
        climberDutyCycle = 0.0;
        climberPID = new PIDController(2, 0, 0);
        climberPID.reset();
    }

    Command idle(){

        return new RunCommand(() -> {
            climberDutyCycle = climberPID.calculate(armEncoder.getPosition(), requestedPosition) + gravityDutyCycle;
           
            climberDutyCycle = Math.min(0.1, climberDutyCycle);
            climberDutyCycle = Math.max(-0.1, climberDutyCycle);
            leverMotor.set(climberDutyCycle);
        }, this);

    }

    Command ascend(){
        return new InstantCommand(() -> {
            requestedPosition -= .03;
        }, this);
    }

    Command descend(){
        return new InstantCommand(() -> {
            requestedPosition += .03;
        }, this);
    }

    Command resetPID(){
        return new InstantCommand(() -> {
            climberPID.reset();
        },this);
    }

}

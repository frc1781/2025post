package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.util.function.BooleanSupplier;

import CRA.CRASparkMax;

public class Climber extends SubsystemBase {
    CRASparkMax motor;

    // public Climber() {
    //     motor = new LinSparkMax(Constants.Climber.MOTOR);
    // }
    
    // public Command clearCoral(BooleanSupplier hasCoralToClear) {
    //     return new RunCommand(() -> {motor.set(hasCoralToClear.getAsBoolean() ? 0.5 : 0);}, this);
    // }         
}

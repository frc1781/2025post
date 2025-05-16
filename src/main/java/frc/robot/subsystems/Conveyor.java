package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import team1781.LinSparkMax;
import java.util.function.BooleanSupplier;

public class Conveyor extends SubsystemBase {
    LinSparkMax motor;

    public Conveyor() {
        motor = new LinSparkMax(Constants.Conveyor.MOTOR_CAN_ID);
    }
    
    public Command clearCoral(BooleanSupplier hasCoralToClear) {
        return new RunCommand(() -> {motor.set(hasCoralToClear.getAsBoolean() ? 0.5 : 0);}, this);
    }         
}

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import java.util.function.BooleanSupplier;

public class Conveyor extends SubsystemBase {
    SparkMax motor;

    public Conveyor() {
        motor = new SparkMax(Constants.Conveyor.MOTOR_CAN_ID, SparkLowLevel.MotorType.kBrushless);
        SparkMaxConfig coralConveyorConfig = new SparkMaxConfig();
        coralConveyorConfig.idleMode(SparkBaseConfig.IdleMode.kCoast);
        coralConveyorConfig.smartCurrentLimit(30);
        motor.configure(
            coralConveyorConfig, 
            SparkBase.ResetMode.kResetSafeParameters, 
            SparkBase.PersistMode.kPersistParameters
        );
    }
    
    public Command clearCoral(BooleanSupplier hasCoralToClear) {
        return new RunCommand(() -> {
            if (hasCoralToClear.getAsBoolean()) {
                motor.set(0.5);
            }
            else {
                motor.set(0.0);
            }
        }, this);
    }         
}
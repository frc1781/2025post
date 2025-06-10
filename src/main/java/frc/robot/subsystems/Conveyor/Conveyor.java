package frc.robot.subsystems.Conveyor;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.BooleanSupplier;

public class Conveyor extends SubsystemBase {
    ConveyorIO io;

    public Conveyor() {
        io = new ConveyorSim();
    }
    
    public Command clearCoral(BooleanSupplier hasCoralToClear) {
        return new RunCommand(() -> {io.set(hasCoralToClear.getAsBoolean() ? 0.5 : 0); io.update();}, this);
    }         
}
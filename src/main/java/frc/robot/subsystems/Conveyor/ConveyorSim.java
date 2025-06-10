package frc.robot.subsystems.Conveyor;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class ConveyorSim implements ConveyorIO
{
    DCMotorSim motor;

    ConveyorSim()
    {
        motor = new DCMotorSim(LinearSystemId.createDCMotorSystem(DCMotor.getNEO(1), 3, 3), DCMotor.getNEO(1));
    }

    public void update()
    {
        motor.update(0.02);
    }

    public void set(double speed)
    {
        motor.setInputVoltage(speed * 12);
    }
}

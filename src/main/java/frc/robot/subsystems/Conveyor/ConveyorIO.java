package frc.robot.subsystems.Conveyor;

public interface ConveyorIO 
{
    void set(float speed);
    void brake(boolean value);
    void inverted(boolean value);

    void update();
}

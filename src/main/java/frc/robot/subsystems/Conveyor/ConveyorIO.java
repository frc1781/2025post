package frc.robot.subsystems.Conveyor;

public interface ConveyorIO 
{
    record Data
    (
        //some stuff
    ) {}
    Data data = new Data();

    void set(double speed);

    void update();
}

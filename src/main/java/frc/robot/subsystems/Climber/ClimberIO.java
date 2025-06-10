package frc.robot.subsystems.Climber;

public interface ClimberIO 
{
    record Data
    (
        //some stuff
    ) {}
    Data data = new Data();

    void update();
}

package frc.robot.subsystems.Conveyor;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants;

public class ConveyorReal implements ConveyorIO
{
    private SparkMax motor;

    ConveyorReal()
    {
        motor = new SparkMax(Constants.Conveyor.MOTOR_CAN_ID, SparkLowLevel.MotorType.kBrushless);
        SparkMaxConfig config = new SparkMaxConfig();
        config.idleMode(SparkBaseConfig.IdleMode.kCoast);
        config.smartCurrentLimit(30);
        config.inverted(false);
        motor.configure(config, 
            SparkBase.ResetMode.kResetSafeParameters, 
            SparkBase.PersistMode.kPersistParameters
        );
    }

    public void update()
    {

    }

    public void set(double speed)
    {
        motor.set(speed);
    }
}

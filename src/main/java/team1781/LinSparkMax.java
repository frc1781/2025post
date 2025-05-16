package team1781;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

public class LinSparkMax extends SparkMax {
    
    public LinSparkMax(int canid) {
        super(canid, SparkLowLevel.MotorType.kBrushless);
        SparkMaxConfig coralConveyorConfig = new SparkMaxConfig();
        coralConveyorConfig.idleMode(SparkBaseConfig.IdleMode.kCoast);
        coralConveyorConfig.smartCurrentLimit(30);
        super.configure(coralConveyorConfig, 
            SparkBase.ResetMode.kResetSafeParameters, 
            SparkBase.PersistMode.kPersistParameters
        );
    }
}

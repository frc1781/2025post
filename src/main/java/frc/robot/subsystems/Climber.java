package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import team1781.LinSparkMax;
import java.util.function.BooleanSupplier;

public class Climber extends SubsystemBase {
    private LinSparkMax motor;
    boolean initalized; 

    public Climber() {
        initalized = false;
        motor = new LinSparkMax(Constants.Climber.MOTOR);
    }
    
    public Command clearCoral(BooleanSupplier hasCoralToClear) {
        return new RunCommand(() -> {motor.set(hasCoralToClear.getAsBoolean() ? 0.5 : 0);}, this);
    }         

    public Command descend(){
        return this.runOnce(() -> {
            if (!climbing) {
                climberPID.reset();
            }
            climbing = true;
            requestedPosition += 0.03}
            );
    }

    public Command climb(){
        return this.runOnce(() -> {
            requestedPosition -= 0.03;

            if (!climbing) {
                climberPID.reset();
            }
            climbing = true;
        });
        
    }

    public Command run(){

        return new RunCommand(() -> {
            
            if (initalized == false){
                requestedPosition = armEncoder.getPosition();
                initalized = true;
            }

            if (climbing) {
                climberDutyCycle = climberPID.calculate(armEncoder.getPosition(), requestedPosition) + gravityDutyCycle;
            }
            else {
                climberDutyCycle = 0.0;
            }

            climberDutyCycle = EEUtil.clamp(-0.5, 0.5, climberDutyCycle);
            leverMotor.set(climberDutyCycle);
            Logger.recordOutput("Climber/dutyCycle", climberDutyCycle);
            Logger.recordOutput("Climber/position", armEncoder.getPosition());
            Logger.recordOutput("Climber/requestedPosition", mMotorPosition);
            
        });
    }


}

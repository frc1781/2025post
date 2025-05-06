package frc.robot.subsystems;

import frc.robot.Constants;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.DigitalInput;

public class Sensation
{
    DigitalInput enterBeam;
    DigitalInput hopperBackBeam;
    DigitalInput hopperFrontBeam;
    DigitalInput exitBeam;

    public Sensation()
    {
        enterBeam = new DigitalInput(Constants.SensationConstants.enter);
    }

    public BooleanSupplier enterSupplier() 
    {
        return new BooleanSupplier()
        {
            @Override
            public boolean getAsBoolean() 
            {
                return enterBeam.get();
            }
        };
    }
}
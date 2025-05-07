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
        hopperBackBeam = new DigitalInput(Constants.SensationConstants.hopperBack);
        hopperFrontBeam = new DigitalInput(Constants.SensationConstants.hopperFront);
        exitBeam = new DigitalInput(Constants.SensationConstants.exit);
    }

    public BooleanSupplier enterSupplier() 
    {
        return new BooleanSupplier()
        {
            @Override
            public boolean getAsBoolean() 
            {
                return !enterBeam.get();
            }
        };
    }

    public BooleanSupplier hopperSupplier() 
    {
        return new BooleanSupplier()
        {
            @Override
            public boolean getAsBoolean() 
            {
                return (!hopperBackBeam.get()) || (!hopperFrontBeam.get());
            }
        };
    }

    public BooleanSupplier exitSupplier() 
    {
        return new BooleanSupplier()
        {
            @Override
            public boolean getAsBoolean() 
            {
                return !exitBeam.get();
            }
        };
    }
}
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Lights;

public class SetLights extends Command
{
    Lights lights;
    boolean isSpecial = false;
    Lights.Colors color = null;
    Lights.Patterns pattern = null;
    Lights.Special special = null;

    public SetLights(Lights lights, Lights.Colors color, Lights.Patterns pattern)
    {
        this.lights = lights;
        addRequirements(lights);
        isSpecial = false;
        this.color = color;
        this.pattern = pattern;
    }

    public SetLights(Lights lights, Lights.Special special)
    {
        this.lights = lights;
        addRequirements(lights);
        isSpecial = true;
        this.special = special;
    }

    @Override
    public void execute() 
    {
        if(isSpecial)
        {
            lights.runSpecial(special);
        }
        else
        {
            lights.run(color, pattern);
        }
    }

    @Override
    public boolean isFinished() 
    {
      return false;
    }
}

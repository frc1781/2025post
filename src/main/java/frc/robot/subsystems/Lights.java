package frc.robot.subsystems;

import java.util.Timer;

import org.dyn4j.exception.NullElementException;

public class Lights 
{
    public enum Colors
    {
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        PURPLE,
        WHITE
    }
    public enum Patterns 
    {
        SOLID,
        BLINK,
        FAST_BLINK,
        FLASH,
        FAST_FLASH,
        MARCH
    }
    public enum Special 
    {
        OFF,
        RAINBOW
    }

    Timer timer;

    public Lights()
    {
        timer = new Timer();
    }

    void run(Colors colorName, Patterns pattern)
    {
        
    }

    Color solid(int i, Color color)
    {
        return null;
    }

    Color colorLookup(Colors color)
    {
        switch (color) {
            case RED:
                return new Color(255, 0, 0);
            case ORANGE:
                return new Color(255, 150, 0);
            case YELLOW:
                return new Color(255, 255, 0);
            case GREEN:
                return new Color(0, 255, 0);
            case BLUE:
                return new Color(0, 0, 255);
            case PURPLE:
                return new Color(255, 0, 255);
            case WHITE:
                return new Color(254, 254, 254);
            default:
                return new Color(0, 0, 0);
        }
    }

    void special(Special special)
    {

    }

    class Color 
    {
        public int r;
        public int g;
        public int b;

        public Color(int r, int g, int b)
        {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
}

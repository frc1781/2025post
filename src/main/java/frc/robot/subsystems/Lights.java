package frc.robot.subsystems;

import java.util.Timer;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class Lights 
{
    private final int LED_LENGTH = 150;
    
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

    private AddressableLED controller = null;
    private AddressableLEDBuffer buffer = null;

    private Timer timer;

    public Lights()
    {
        ledController = new AddressableLED(1);
        ledBuffer = new AddressableLEDBuffer(LED_LENGTH + 1);
        ledController.setLength(ledBuffer.getLength());
        ledController.setData(ledBuffer);
        ledController.start();
        
        timer = new Timer();
        timer.reset();
        timer.start();
    }

    Color solid(int i, Color color)
    {
        return color;
    }

    Color blink(int i, Color color, int delay)
    {
        if(timer.get() > delay)
        {
            if(timer.get() > delay * 2)
            {
                timer.reset();
            }
            return color;
        }
        else
        {
            return new Color();
        }
    }

    Color flash(int i, Color color, int delay)
    {
        boolean toggle = timer.get() > delay;
        if(timer.get() > delay * 2)
        {
            timer.reset();
        }
        if((i % 2 == 0) != toggle)
        {
            return color;
        }
        else
        {
            return new Color();
        }
    }

    Color rainbow(int i)
    {

    }

    Color march(int i, Color color, int delay, int ammount)
    {
        if(timer.get() > delay * ammount)
        {
            timer.reset();
        }
        if(i % ammount == Math.round(timer.get()/delay))
        {
            return color;
        }
        else
        {
            return new Color();
        }
    }

    Color patternLookup(Patterns pattern, int i, Color color)
    {
        switch(Pattern)
        {
            case SOLID:
                return solid(i, color)
            case BLINK:
                return blink(i, color, 0.4);
            case FAST_BLINK:
                return blink(i, color, 0.2);
            case FLASH:
                return flash(i, color, 0.4);
            case FAST_FLASH:
                return flash(i, color, 0.2);
            case MARCH:
                return march(i, color, 0.2, 3);
            default:
                return new Color(0, 0, 0);
        }
    }

    Color speicalLookup(Special special, int i)
    {
        switch(specail)
        {
            case RAINBOW:
                return solid(i, color)
            default: case OFF:
                return new Color(0, 0, 0);
        }
    }

    Color colorLookup(Colors colorName)
    {
        switch(colorName)
        {
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

    void run(Colors colorName, Patterns pattern)
    {
        Color color = colorLookup(colorName);
        for(int i = 0; i < LED_LENGTH; i++)
        {
            color = patternLookup(pattern, i, color);
            buffer.setRGB(color.g, color.r, color.b)
        }
        controller.setData(buffer);
    }

    void runSpecial(Special special)
    {
        for(int i = 0; i < LED_LENGTH; i++)
        {
            Color color = specialLookup(special, i);
            buffer.setRGB(color.g, color.r, color.b)
        }
        controller.setData(buffer);
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

        public Color()
        {
            r = 0;
            g = 0;
            b = 0;
        }
    }
}

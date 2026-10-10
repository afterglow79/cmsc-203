// the purpose of this class is to model a television
// Kelvin Zimmerman, 10/9/2026

public class Television {
    private final String MANUFACTURER;
    private final int SCREEN_SIZE;
    private boolean powerOn;
    private int channel;
    private int volume = 0;

    // Constructor that initializes the manufacturer and screen size of the television.
    // It also initializes the power state to off, channel to 2, and volume to 20.
    public Television(String MANUFACTURER, int SCREEN_SIZE) {
        this.MANUFACTURER = MANUFACTURER;
        this.SCREEN_SIZE = SCREEN_SIZE;

        powerOn = false;
        channel = 2;
        volume = 20;
    }

    //Toggles the power state of the television.
    public void power() {
        powerOn = !powerOn;
    }

    // sets the channel of the television to the specified value.
    public void setChannel(int channel) {
        this.channel = channel;
    }

    // returns the current channel of the television.
    public int getChannel() {
        return this.channel;
    }

    // increases the volume of the television by 1.
    public void increaseVolume() {
        if(volume < 100) {
            volume++;
        }
    }
    // decreases the volume of the television by 1.
    public void decreaseVolume() {
        if(volume > 0){ volume--; }
    }

    // returns the current volume of the television.
    public int getVolume() {
        return this.volume;
    }

    // returns the manufacturer of the television.
    public String getManufacturer() {
        return this.MANUFACTURER;
    }

    // returns the screen size of the television.
    public int getScreenSize() {
        return this.SCREEN_SIZE;
    }

}

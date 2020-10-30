import java.util.Date;

/**
 * Simple wigdet class that can be enabled or disabled
 */
public class Widget {

    private boolean enabled;
    private boolean broken;
    private ISettingsProvider settingsProvider;
    private Date releaseDate;
    private String devicename;

    /**
     * Create new enabled widget
     */
    public Widget() {
        enabled = true;
        broken = false;
    }

    public void setSettingsProvider(ISettingsProvider settingsProvider){
        this.settingsProvider = settingsProvider;
    }
    public void applySettingsFromProvider(){
        releaseDate = settingsProvider.getReleaseDate();
        devicename = settingsProvider.getDeviceName();
    }
    /**
     * Is the widget currently enabled?
     *
     * @return true if enabled, false otherwise
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Is the widget currently broken?
     *
     * @return true if broken, false otherwise
     */
    public boolean isBroken() {
        return broken;
    }
    /**
     * Set the widget enable state
     *
     * @param enabled
     * @return this widget
     */
    public Widget setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
    /**
     * Enable widget
     * @return this widget
     */
    public Widget Enable() {
        return this.setEnabled(true);
    }
    /**
     * Enable widget
     * @return this widget
     */
    public Widget Disable() {
        return this.setEnabled(false);
    }

    /**
     * Drop your lovely widget
     * @return this widget
     */
    public Widget DropFromHeight(int meters) {
        if (meters > 1)
            this.broken = true;
        else
            this.broken = false;
        return this;
    }
}
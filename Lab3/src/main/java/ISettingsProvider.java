import java.util.Date;

public interface ISettingsProvider {
    public Date setReleaseDate();
    public String setDeviceName(String name);
    public Date getReleaseDate();
    public Date getMinimumAllowedReleaseDate();
    public void resetSettings();
    public String getDeviceName();
    public String SetDateAsDeviceName();
    public String SetDeviceId(int id);

}

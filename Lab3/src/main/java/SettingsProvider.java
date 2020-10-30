import java.util.Calendar;
import java.util.Date;

public class SettingsProvider implements ISettingsProvider {
    private Date releaseDate;
    private String deviceName;

    public SettingsProvider(){

    };

    public String setDeviceName(String name){
        deviceName = name;
        return deviceName;
    }

    public String SetDeviceId(int id){
        deviceName = "Device_" + id;
        return deviceName;
    }

    public Date setReleaseDate() {
        releaseDate = new Date();
        return releaseDate;
    }

    public Date getMinimumAllowedReleaseDate() {
        return new Date(0);
    }

    public String SetDateAsDeviceName(){
        if (releaseDate == null) throw new NullPointerException("Date is null, what are you expected to see?");
        deviceName = releaseDate.toString();
        return deviceName;
    }

    public Date getReleaseDate() {
        if (releaseDate == null) throw new NullPointerException("Date is null, what are you expected to see?");
        return releaseDate;
    }

    public void resetSettings() {
        releaseDate = getMinimumAllowedReleaseDate();
    }

    public String getDeviceName() {
        return deviceName;
    }
}

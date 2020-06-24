package HTTP.InfoServer;

import java.util.Date;

public class ServiceHandle {
    public static String getTime(){
        return new Date().toString();
    }

    public static String getWeather(){
        return "Some weather";
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;




public class Main {
    private static String steamAPIkey = "key goes here";
    /**
     *
     * @param sName = the profile username (vanity url)
     * @return the steam user ID of the user
     */
    public static String urlToID(String sName){
        String steamName = sName;
        String apiCall = "http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key=" + steamAPIkey +"&vanityurl=" + steamName;
        URL getID = null;
        List<String> ret = new ArrayList<>();
        try{
            getID = new URL(apiCall);
            //more code goes here
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }
        try {

            URLConnection sc = getID.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            sc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                ret.add(inputLine);
                /*System.out.println(inputLine);*/

            in.close();
        }catch(IOException iex){
            iex.printStackTrace();
        }
        String id = " ";
        for(int i = 0; i <ret.get(2).length(); i++){
            if (Character.isDigit(ret.get(2).charAt(i))){
                id += ret.get(2).charAt(i);
            }
        }
        return id.trim();
    }
/*    public static String getID(List<String> apic){
        List<String> res = apic;
        res = urlToAPICall("seankennedy3");
        String id = " ";
        for(int i = 0; i <res.get(2).length(); i++){
            if (Character.isDigit(res.get(2).charAt(i))){
                id += res.get(2).charAt(i);
            }
        }
        return id.trim();
    }*/

    public void scrapeUserInfo(){

    }

    public void retTime(){

    }


    public static void main(String[] args) {


        System.out.println(urlToID("seankennedy3"));
    }
}

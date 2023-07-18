import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SizeCalculator {
    final static String[] SFX_SHORT = {"B", "K", "M", "G" , "T"};
    final static String[] SFX = {"B", "Kb", "Mb", "Gb" , "Tb"};

    public static String getHumanReadableSize(long size){
        for (int i = 0; i <= SFX.length; i++) {

            if (size/Math.pow(1024,i) <= 999){
                return String.format("%.2f",(size / Math.pow( 1024, i))) + SFX[i];
            }
        }
        return Long.toString(size);
    }

    public static long getSizeFromHumanReadable(String size){
        Matcher matcher = Pattern.compile("([0-9]+)([a-z,A-Z]+)").matcher(size);
        int pow = 0;
        if (matcher.find()){
            for (int i = 0; i < 5; i++) {
                if (matcher.group(2).equals(SFX[i]) || matcher.group(2).equals(SFX_SHORT[i])){
                    pow = i;
                    break;
                }
            }
            return (long) (Long.parseLong(matcher.group(1)) * Math.pow(1024,pow));
        }
        return 0;
    }
}

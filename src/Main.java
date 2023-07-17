import java.io.File;

public class Main {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\Alexey\\Desktop";
        File file = new File(folderPath);

        System.out.println(getFolderSize(file));
    }

     public static long getFolderSize(File folder){
        if(folder.isFile()){
            return folder.length();
        }
        long sum = 0;
        for(File file : folder.listFiles()){
            sum += getFolderSize(file);
        }
        return  sum;
     }
}

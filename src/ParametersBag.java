import java.io.File;

public class ParametersBag {
    private long limit = 0;
    private String path = "";

    public ParametersBag(String[] args){
        if (args.length < 4){
            throw new IllegalArgumentException("Слишком мало аргументов");
        }
        if (args.length > 4){
            throw new IllegalArgumentException("Слишком много аргументов");
        }

        for (int i = 0; i < 4; i++) {
            if (args[i].equals("-d")){
                path = args[++i];
            }
            if (args[i].equals("-l")){
                limit = SizeCalculator.getSizeFromHumanReadable(args[++i]);
            }
        }
        if (limit <= 0){
            throw new IllegalArgumentException("лимит указан не верно");
        }
        File folder = new File(path);
        if(!folder.exists() || !folder.isDirectory()){
            throw new IllegalArgumentException("путь к папке уеазан не верно");
        }
    }
    public String getPath(){
        return path;
    }

    public long getLimit(){
        return limit;
    }
}

import java.io.File;
import java.util.ArrayList;

public class Node {

    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int level = 0;

     public Node(File folder){
         this.folder = folder;
         children = new ArrayList<>();
     }

     public File getFolder(){
         return folder;
     }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public void addCild(Node node){
         node.setLevel(level + 1);
         children.add(node);
     }

     public ArrayList<Node> getChildren(){
         return children;
     }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
         String size = SizeCalculator.getHumanReadableSize(getSize());
         StringBuilder builder = new StringBuilder();

         builder.append(folder.getName()).append(" - ").append(size).append("\n");
         for (Node cild : children){
             String repeat = "- ".repeat(cild.getLevel());
             builder.append(repeat).append(cild.toString());
         }

        return builder.toString();
    }
}

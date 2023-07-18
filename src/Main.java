import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        ParametersBag bag = new ParametersBag(args);

        File file = new File(bag.getPath());
        long sizeLimit = bag.getLimit();

        Node root = new Node(file, sizeLimit);

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);

        System.out.println(root);
    }
}

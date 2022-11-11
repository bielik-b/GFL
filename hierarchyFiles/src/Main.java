import java.io.File;

public class Main {
    public static void main(String[] args) {
       new Main().run(new File("D:\\GFL"),0);
    }

   static String gap(int n, String value) {
       return new String(new char[n]).replace("\0", value);
   }
    private static void run(File dir, int level){

        String retreat = gap(level,"   ");

        if(dir.isDirectory()){
            for (File file :dir.listFiles()) {
                if(file.isFile()){
                    System.out.println(retreat + file.getName()+" file");
                } else {
                    System.out.println(retreat + file.getName() + " catalog");
                    run(file,level+1);
                }

            }
        }
    }
}
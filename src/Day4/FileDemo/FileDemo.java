package Day4.FileDemo;

import java.io.*;

public class FileDemo {
    public static void main(String[] args) {
        String[] matkul = {
                "programming logic",
                "Database",
                "Web Dev"
        };
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("output.txt")
            );
            writer.write("nama saya akmal");
//            writer.write("\nsaya.... See More");
            for (String mat: matkul){
                writer.write("\n" + mat);
            }
            writer.close();
        }catch(IOException e){
            System.out.println(e);
        }

        try{
            BufferedReader reader = new BufferedReader(
                    new FileReader("output.txt")
            );
//            String line = reader.readLine();
//            System.out.println(line);
            String line;
            while((line = reader.readLine())!=null
            ){
                System.out.println(line);
            }
            reader.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

}

import java.io.*;


public class FileHandler {

    public static void appendLine(String fileName, String data) {
        // write text to end of the file
        boolean append = true;
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, append))) {
            pr.println(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readLineAt(String fileName, int start) {
        // grab the line from position "start" in the file
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start);
            return rf.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void writeLineAt(String fileName, String data, int start) {
        // overwrite a line from position "start" in the file
        // doesn't check that the start position is actually 
        // the beginning of the file. This will not behave well
        // unless every line is the same length
    }

    public static int countLines(String fileName) {
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();
            while(line != null){
                count ++;
                line= br.readLine();
            }
        } catch (IOException e){
        e.printStackTrace();
        }

        return count;
    }


}

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Database {
    private String filename;
    private int rowWidth;
    private int recordCount;
    public Database(String filename, int rowWidth) {
        this.filename = filename;
        this.rowWidth = rowWidth;
        recordCount = FileHandler.countLines(filename);
    }
    // add a new record to the end of the database
    public void appendRecord(String data) {
        // TODO: Pad the data to the correct record width
        // TODO: Report an error if the data is too long for the record
        int dataLength = data.length();
        if (dataLength > 10) {
            System.out.println("Error, data entered is too long for the record.");
        }
        if (dataLength < 10) {
            for (int i = 0; i < 10 - dataLength; i++) {
                data = data + " ";
            }
        }
        FileHandler.appendLine(filename, data);
        recordCount++;
    }
    // delete the record at the specified row
    public void deleteRecord(int rowNumber) {
        
        // Record count  -1;
    }
    // return the record at the specified row
    public String getRecord(int rowNumber) {
        return ""; // TODO: replace this placeholder code
    }
    // return the number of records in the database
    public int getRecordCount(Database db) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(db.filename))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
                count = count + 1;
            }
            return count;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    // search for a record matching data
    // return true if found
    public boolean findRecord(String data,String fileName) {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();
            for (int i = 0; i <FileHandler.countLines("test.txt");i++) {
                if (line.equals(data)) {
                    return true;
                }
            line = br.readLine();
                }
            }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
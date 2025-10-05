import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader {
    private BufferedReader br;
    private String fileName, linea, cvsSplitBy, message;
    private int [] result;
    private int size;
    public CSVReader(String fileName) {
        this.fileName = fileName;
        this.br = null;
        this.cvsSplitBy = ",";
        this.size = 0;
    }
    public int[] Read(){
        try{
            br = new BufferedReader(new FileReader(fileName));
            while((linea = br.readLine()) != null){
                String[] datos = linea.split(cvsSplitBy);
                for(String dato : datos){
                    result[size] = Integer.parseInt(dato);
                    size++;
                }
            }
        }catch(Exception e){
            message = "Error: " + e.getMessage();
            return null;
        }
        return result;
    }

    public int[] getResult(){
        return result;
    }
    public int getSize(){
        return size;
    }
    public String getMessage() {
        return message;
    }
}

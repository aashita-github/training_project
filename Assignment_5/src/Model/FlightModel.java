package Model;
import java.io.FileReader;

public class FlightModel  
{    
public static void main(String[] args)  
{  
CSVReader reader = null;  
try  
{  
//parsing a CSV file into CSVReader class constructor  
CSVReader reader = new CSVReader(new FileReader("C:\\Users\\FlightData\\AirIndia.csv"));  
String [] nextLine;  
//reads one line at a time  
while ((nextLine = reader.readNext()) != null)  
{  
for(String token : nextLine)  
{  
System.out.print(token);  
}  
System.out.print("\n");  
}  
}  
catch (Exception e)   
{  
e.printStackTrace();  
}  
}  
} 
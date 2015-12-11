import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.bson.Document;

public class InputClusters {
public static void main(String args[]) throws FileNotFoundException, IOException    
{
  MongoClient mongo = new MongoClient();

        DB db = mongo.getDB("WebDB");

       DBCollection idf = db.getCollection("Clusters");
      File f=new File("C:\\Users\\Anjali\\Desktop\\TestRuns");       
   File a[]=f.listFiles();
   BufferedReader br;
String sb[] = new  String[a.length];	    
    for(int i=0;i<a.length;i++)
    {
    br=new BufferedReader(new FileReader(a[i].getAbsolutePath()));
    Document d=new Document();
    d.put("Cluster Name",a[i].getName().replace(".txt", ""));
    sb[i]=new String();
          for (String line; (line = br.readLine()) != null;) 
          {
sb[i]=sb[i]+","+line;
        }   
          sb[i]=sb[i].substring(1);
    d.put("PaperID",sb[i]);
    DBObject dbo=new BasicDBObject(d);
    idf.insert(dbo);
         }
    
}
        
          }
          


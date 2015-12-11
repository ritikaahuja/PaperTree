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
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

public class Threshold {
public static void main(String args[]) throws FileNotFoundException, IOException    
{
    Double threshold=new Double(6);
  MongoClient mongo = new MongoClient();
DB pa=mongo.getDB("TFIDF");
DB cl=mongo.getDB("WebDB");
StringBuilder sb=null;
DBCollection cluster=cl.getCollection("Clusters");
DBCursor cur=cluster.find();
while(cur.hasNext())
{
    sb=new StringBuilder();
    cur.next();
    DBObject ob=cur.curr();
    String papers=(String) ob.get("PaperID");
    String cname=(String) ob.get("Cluster Name");
    
    List<String> pi = Arrays.asList(papers.split(","));
    System.out.println(pi.toString());
   
   for(int i=0;i<pi.size();i++)
   {
       
       DBCollection temp=pa.getCollection(pi.get(i));
       DBCursor tempcur=temp.find();
       while(tempcur.hasNext())
       {
           tempcur.next();
           DBObject tempdb=tempcur.curr();
           Double d=(Double) tempdb.get("Imp");
           if(d!=null)
           if(d>threshold)
           {
               sb=sb.append(tempdb.get("Word")+",");
           }
       }
       
       
   }
   DBCollection newC=cl.getCollection("ClusterKey");
       Document j=new Document();
       j.put("Cluster Name",cname);
       
       j.put("Keywords",sb.toString());
       DBObject ul=new BasicDBObject(j);
       newC.insert(ul);
}
    
}
        
          }
          


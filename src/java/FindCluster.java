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
public class FindCluster {
    public String getCluster(String b)
    {
        MongoClient mongo=new MongoClient();
        DB db=mongo.getDB("WebDB");
        DBCollection c1=db.getCollection("ClusterKey");
        DBCursor cur=c1.find();
        String a[]=null;
        StringBuilder sb=new StringBuilder();
        while(cur.hasNext())
        {
            cur.next();
            DBObject ob=new BasicDBObject();
            ob=cur.curr();
            String cname=(String)ob.get("Cluster Name");
            String words=(String)ob.get("Keywords");
            if(words.contains(b))
            sb.append(","+cname);
            
        }
        return sb.toString();
        
    }
public static void main(String args[])    
{
    FindCluster fc=new FindCluster();
    fc.getCluster("bluetooth");
}
}

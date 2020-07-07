import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.AggregationOutput;
import java.util.*;
                	
public class MongoDBConnection
{
public static DBCollection users;
public static DBCollection getConnection()
{
MongoClient mongo;
mongo = new MongoClient("localhost", 27017);

DB db = mongo.getDB("recommendproject");
 users= db.getCollection("users");	
return users; 
}


public static String setFavoriteItems(String username,String category, String eventids)
{
	try
		{		
			getConnection();
			BasicDBObject doc = new BasicDBObject("title", "users").
				append("name", username).
				append("categoryName", category).
			append("event", eventids);
			users.insert(doc);
			System.out.println("Successfull");
			return "Successfull";
		}
		catch(Exception e)
		{
		return "UnSuccessfull";
		}	
		
}
}

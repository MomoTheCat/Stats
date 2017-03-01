package configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Created by szymon on 01.03.2017.
 */
public class MongoDbConnection {

    public static MongoDbConnection mongoDbConnection;

    private MongoDatabase db;

    private MongoDbConnection(String mongoConf) {
        if (!mongoConf.equals("")) {
            MongoClientURI uri = new MongoClientURI(mongoConf);
            MongoClient client = new MongoClient(uri);
            db = client.getDatabase("satellite");
        }
    }

    public static MongoDbConnection newInstance(String mongoConf) {
        if (mongoDbConnection == null) {
            mongoDbConnection = new MongoDbConnection(mongoConf);
        }
        return mongoDbConnection;
    }

    public long getNumberOfElements() {
        MongoCollection songs = db.getCollection("one");
        System.out.println(songs.count());
        return songs.count();
    }


}

package com.healthhgt8.mentalhealthapp;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Filters.*;

import org.bson.BsonDocument;
import org.bson.Document;

import java.util.*;


public class DBObject {

    private static DBObject instance = new DBObject();
    private final MongoClient client = MongoClients.create("$credentials"); //FIXME: paste in connection string here


    // Get the only object available
    public static DBObject getInstance() {
        if (instance == null) {
            instance = new DBObject();
        }
        return instance;
    }

    private DBObject() {

    }

    // can't ensure the type of all values in this map, but the keys should be strings
    public boolean sendToDB(HashMap<String, String> BSONKeysAndValues, String dbName, String collectionName) {
        Document document = new Document();
        for (String key: BSONKeysAndValues.keySet()) {
            document.put(key, BSONKeysAndValues.get(key));
        }
        MongoDatabase db = client.getDatabase(dbName);
        //Inserting the document into the collection
        db.getCollection(collectionName).insertOne(document);
        System.out.println("Document inserted successfully");
        return true;
    }

    /**
     *
     * @param number Number of random entries to fetch
     * @return
     */
    public List<Document> queryRandom(int number, String dbName, String collectionName) {
        MongoDatabase db = client.getDatabase(dbName);
        MongoCollection<Document> collection = db.getCollection(collectionName);
        // query for all documents and add them to an arraylist
        // record collection size under here -- collectionSize
        FindIterable<Document> iterable = collection.find();
        MongoCursor<Document> cursor = iterable.iterator();
        List<Document> collectionList = new ArrayList<>();
        while(cursor.hasNext()) {
            collectionList.add(cursor.next());
        }
        int collectionSize = collectionList.size();
        Set<Integer> indices = new HashSet<>();
        while (indices.size() < number) {
            int randomIndex = (int) Math.floor(Math.random() * collectionSize);
            indices.add(randomIndex);

        }
        List<Document> documentList = new ArrayList<>();
        indices.forEach(index -> {
            Document dbObj = collectionList.get(index);
            documentList.add(dbObj);
        });
        return documentList;
    }

    public void attachMeeting(String email, String meeting, String dbName, String collectionName) {
        MongoDatabase db = client.getDatabase(dbName);
        MongoCollection<Document> collection = db.getCollection(collectionName);

        collection.updateOne(Filters.eq("email", email), Updates.combine(Updates.set("meeting", meeting)));
    }

    public MongoClient getClient() {
        return this.client;
    }
}
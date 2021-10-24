package com.healthhgt8.mentalhealthapp;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.HashMap;


public class DBObject {

    private static DBObject instance = new DBObject();
    private final MongoClient client = MongoClients.create("mongodb+srv://hackgt8-mental-health:cR7jD9*~52QyA6T@cluster0.j9dny.mongodb.net/myFirstDatabase?retryWrites=true&w=majority"); //FIXME: paste in connection string here


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


    public MongoClient getClient() {
        return this.client;
    }
}
package com.healthhgt8.mentalhealthapp;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.w3c.dom.Document;


import java.util.HashMap;


// FIXME: NEED TO IMPORT org.bson.Document or something along those lines
public class DBObject {

    private static DBObject instance = new DBObject();
    private MongoClient client = MongoClients.create(""); //FIXME: paste in connection string here


    private DBObject() {

    }

    // Get the only object available
    public static DBObject getInstance() {
        if (instance == null) {
            instance = new DBObject();
        }
        return instance;
    }

    // can't ensure the type of all values in this map, but the keys should be strings
    public boolean sendToDB(HashMap<String, Object> BSONKeysAndValues, String dbName, String collectionName) {
        Document document = new Document();
        for (String key: BSONFieldsAndValues.keySet()) {
            document.append(key, value);
        }
        MongoDatabase db = client.getDatabase(dbName);
        //Inserting the document into the collection
        db.getCollection(collectionName).insertOne(document);
        System.out.println("Document inserted successfully");

    }


    public MongoClient getClient() {
        return this.client;
    }
}
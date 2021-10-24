package com.healthhgt8.mentalhealthapp;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DBObject {
    // make as a singleton- we only need one instance of this, one client etc.
    private MongoDatabase db;
    private MongoClient client;
    private String var3;

    /**
     *  cAL
     * @param connectionString
     */
    public DBObject(ConnectionString connectionString) {
        MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .build();
        MongoClient mongoClient = MongoClients.create(settings);
    }
}

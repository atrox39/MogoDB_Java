/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adrossoftware.mavenproject1;

/**
 *
 * @author atrox
 */

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import org.bson.BsonType;

public class TestConnection {
    
    // @props
    private MongoClient client;
    private MongoDatabase database;
    
    public TestConnection(){
        client = MongoClients.create("mongodb://localhost/");
        database = client.getDatabase("javamongo");
        // Create element
        MongoCollection<Document> toys = database.getCollection("toys");
        Document toy = new Document("name", "Yoyo").append("ages", new Document("min", 5).append("max", 16));
        BsonType id = toys.insertOne(toy).getInsertedId().getBsonType();
        // Get element
        Document yoyo = toys.find(new Document("name", "Yoyo")).first();
        System.out.println(yoyo.toJson());
    }
    
    // Gets
    public MongoClient getClient(){
        return client;
    }
    
    public MongoDatabase getDatabase(){
        return database;
    }
    
    public static void main(String[] args){
        TestConnection test = new TestConnection();
    }
}

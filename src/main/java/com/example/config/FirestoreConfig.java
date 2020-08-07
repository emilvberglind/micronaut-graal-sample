package com.example.config;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
public class FirestoreConfig {

    @Bean
    public Firestore db() throws Exception {
        FirebaseApp.initializeApp();
        return FirestoreClient.getFirestore();
    }

}

package com.javatechie.spring.paypal.api.upload_image;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class FBInitialize {
    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream inputStream =
                    new FileInputStream("serviceaccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(inputStream))
                    .setDatabaseUrl("https://quanlyktx-4b1db-default-rtdb.asia-southeast1.firebasedatabase.app/")
                    .setStorageBucket("quanlyktx-4b1db.appspot.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package com.javatechie.spring.paypal.api.upload_image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/firebase")
public class FBImageController {
    @Autowired
    FBImageService fbImageService;
    @PostMapping("/upload-image")
    public ResponseEntity<?> addImageToFirebase(@RequestParam("file") MultipartFile file){
        if(!file.isEmpty()) {
            try{
                String fileName = fbImageService.save(file);
                String urlFile = fbImageService.getImageUrl(fileName);
                return ResponseEntity.ok().body(urlFile);
            }catch (Exception e){
                e.getStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Add image failed");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input not found");
    }
}

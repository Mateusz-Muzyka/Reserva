package app.reserve.api.controller;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.reserve.api.data.*;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "*")
public class FileUpload {
    @Autowired
    private Storage storage;
    public FileUpload(Storage storage) {
        this.storage = storage;
    }
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String result = storage.uploadFile(file);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/url")
    public ResponseEntity<String> getFileUrl(@RequestParam String fileName) {
        String fileUrl = storage.getFileUrl(fileName);
        return ResponseEntity.ok(fileUrl);
    }
}

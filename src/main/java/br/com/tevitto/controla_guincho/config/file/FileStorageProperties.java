package br.com.tevitto.controla_guincho.config.file;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

    public FileStorageProperties() {}

    public FileStorageProperties(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}

package com.Storage.Service.System;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("localStorage")
@Lazy(true)
@Scope("prototype")

public class LocalStorageService implements StorageService {

    public LocalStorageService() {
        System.out.println("LocalStorageService Bean Created");
    }

    @Override
    public void storeFile(String fileName) {
        System.out.println("File stored in Local Storage: " + fileName);
    }
}

package com.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * 下载接口
 * Created by sa on 2017-11-24.
 */
@Controller
@RequestMapping(value = "/download")
public class DownLoadController {

    @RequestMapping(value = "/downloadC", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadFileC()
            throws IOException {
        System.out.print("");
        String filePath = "C:/Users/Administrator/Desktop/apk/小桥金融.apk";
        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        String filename= URLEncoder.encode(file.getFilename(),"UTF-8");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", filename));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

    @RequestMapping(value = "/downloadAB", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadFileAB()
            throws IOException {
        System.out.print("");
        String filePath = "C:/Users/Administrator/Desktop/apk/小桥融通.apk";
        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        String filename= URLEncoder.encode(file.getFilename(),"UTF-8");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", filename));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }
}

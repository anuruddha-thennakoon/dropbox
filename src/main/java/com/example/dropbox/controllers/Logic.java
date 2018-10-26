package com.example.dropbox.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URLEncoder;

@Component
public class Logic {

    @Value("${dropbox.clientId}")
    private String clientId;

    @Value("${dropbox.callbackUrl}")
    private String callbackUrl;

    @Value("${dropbox.secret}")
    private String clientSecret;

    public Logic() {
    }

    public String buildRedirectUrl() throws UnsupportedEncodingException {
        return "https://www.dropbox.com/oauth2/authorize/?" +
                "client_id=" + clientId +
                "&redirect_uri=" + URLEncoder.encode(callbackUrl, "UTF-8") +
                "&response_type=code" +
                "&scope=basic";
    }

    public String buildAccessTokenQueryUrl(String code) throws UnsupportedEncodingException {
        return "client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&grant_type=authorization_code" +
                "&redirect_uri=" + URLEncoder.encode(callbackUrl, "UTF-8") +
                "&code=" + code;
    }

    public String accessTokenUrl() {
        return "https://api.dropboxapi.com/oauth2/token?";
    }

    public String getJsonResponse(InputStream stream) throws IOException {

        String response = "";

        if (stream != null) {
            StringBuilder sb = new StringBuilder();
            String line;

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(stream));

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                reader.close();
            } finally {
                stream.close();
            }

            response = sb.toString();
        }

        return response;
    }

}

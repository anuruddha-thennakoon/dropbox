# OAuth with Dropbox API

[![maven](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/google/code/gson/gson/maven-metadata.xml.svg?style=flat-square)](https://maven.apache.org/)

Dropbox is a personal cloud storage service (sometimes referred to as an online backup service) that is frequently used for file sharing and collaboration. 
OAuth (Open Authorization) is an open standard for token-based authentication and authorization on the Internet. This allows an end user’s account information to be used by third-party services, such as Facebook, without exposing the user’s password. OAuth acts as an intermediary on behalf of the end user, providing the service with an access token that authorizes specific account information to be shared.

Full article related to this can be found in my blog (https://medium.com/@anuruddha.thennakoon/manage-personal-cloud-from-your-own-app-using-oauth-2-0-with-dropbox-api-c6648e06655a).

## Getting Started

Build project with maven
```
mvn clean install
```
or
```
mvn package
```
Type "java -jar target\dropbox-0.0.1-SNAPSHOT -Dserver.port=8080" to run the project.(If "java.net.BindException: Address already in use: bind" Exception occurred change server port.) Open browser and navigate to
```
http://localhost:8080/
```
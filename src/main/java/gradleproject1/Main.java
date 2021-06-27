/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;

/**
 *
 * @author galih
 */
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import java.io.ByteArrayOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class Main {
//    private DefaultTableModel table_data;
    /** Application name. */
    private static final String APPLICATION_NAME =
        "Bismillah";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/drive-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/drive-java-quickstart
     */
    private static final List<String> SCOPES =
        Arrays.asList(DriveScopes.DRIVE);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
            Main.class.getResourceAsStream("/credentials.json");
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Drive client service.
     * @return an authorized Drive client service
     * @throws IOException
     */
    public static Drive getDriveService() throws IOException {
        Credential credential = authorize();
        return new Drive.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void main(String[] args) throws IOException {
//        // Build a new authorized API client service.
//        Drive driveService = getDriveService();
//
//        // Your script is here.
//        File fileMetadata = new File();
//        fileMetadata.setName("percobaan");
//        fileMetadata.setMimeType("application/vnd.google-apps.folder");
//
//        File file = driveService.files().create(fileMetadata)
//                .setFields("id")
//                .execute();
//        System.out.println("Folder ID: " + file.getId());
        Main main = new Main();
//        
//        for (File temp : main.getDir()) {
//            System.out.println(temp.getName());
//        }
        
        System.out.println("Berjalan.....");
    }
    public void newFolder(String folderName) throws IOException {
        // Build a new authorized API client service.
        Drive driveService = getDriveService();

        // Your script is here.
        File fileMetadata = new File();
        fileMetadata.setName(folderName);
        fileMetadata.setMimeType("application/vnd.google-apps.folder");

        File file = driveService.files().create(fileMetadata)
                .setFields("id")
                .execute();
        System.out.println("Folder ID: " + file.getId());
    }
    public void uploadFile(String path, String fileName, String mimeType) throws IOException {
        Drive driveService = getDriveService();
        File fileMetadata = new File();
        fileMetadata.setName(fileName);
        fileMetadata.setMimeType("application/vnd.google-apps.file");

        java.io.File filePath = new java.io.File(path+"/"+fileName);
        FileContent mediaContent = new FileContent(mimeType, filePath);
        File file = driveService.files().create(fileMetadata, mediaContent)
        .setFields("id")
        .execute();
        System.out.println("File ID: " + file.getId());
    }
    public List<File> retrieveAllFiles() throws IOException {
        Drive driveService = getDriveService();
        List<File> result = new ArrayList<File>();
        Files.List request = driveService.files().list().setQ("trashed = false").setSpaces("drive");

        do {
          try {
            FileList files = request.execute();

            result.addAll(files.getFiles());
            request.setPageToken(files.getNextPageToken());
          } catch (IOException e) {
            System.out.println("An error occurred: " + e);
            request.setPageToken(null);
          }
        } while (request.getPageToken() != null &&
                 request.getPageToken().length() > 0);
        

        return result;
    }
    public void deleteFile(String fileId) throws IOException {
        Drive driveService = getDriveService();
        try {
          driveService.files().delete(fileId).execute();
          System.out.println("Berhasil hapus" + fileId);
        } catch (IOException e) {
          System.out.println("An error occurred: " + e);
        }
    }
    public void downloadFile(String fileId) throws IOException {
        Drive driveService = getDriveService();
        OutputStream outputStream = new FileOutputStream("/home/galih/Downloads/galihgalihagalih.pdf");
        driveService.files().get(fileId)
            .executeMediaAndDownloadTo(outputStream);
//        OutputStream outputStream = new ByteArrayOutputStream();
//        driveService.files().export(fileId, "image/jpg")
//            .executeMediaAndDownloadTo(outputStream);
        System.out.println("Download Successfully "+ outputStream);
    }
    public List<File> search(String keyword) throws IOException{
        Drive driveService = getDriveService();
        List<File> datas = new ArrayList<File>();
        String pageToken = null;
        
        do {
          FileList result = driveService.files().list()
//              .setQ("mimeType='image/jpeg'")
              .setQ("name contains '"+keyword+"'")
              .setSpaces("drive")
              .setFields("nextPageToken, files(id, name, mimeType)")
              .setPageToken(pageToken)
              .execute();
          datas.addAll(result.getFiles());
          for (File file : result.getFiles()) {
            System.out.printf("Found file: %s (%s) %s\n",
                file.getName(), file.getId(), file.getMimeType());
          }
          pageToken = result.getNextPageToken();
        } while (pageToken != null);
        
        return datas;
    }
    public List<File> getDir(String googleFolderIdParent) throws IOException{
        Drive driveService = getDriveService();
 
        String pageToken = null;
        List<File> list = new ArrayList<File>();
        if (googleFolderIdParent == "root"){
            googleFolderIdParent = null;
        }
        String query = null;
        if (googleFolderIdParent == null) {
            query = " mimeType = 'application/vnd.google-apps.folder' " //
                    + " and 'root' in parents and trashed = false";
            
        } else {
            query = " mimeType = 'application/vnd.google-apps.folder' " //
                    + " and '" + googleFolderIdParent + "' in parents and trashed = false";
            
        }
 
        do {
            FileList result = driveService.files().list().setQ(query).setSpaces("drive") //
                    // Fields will be assigned values: id, name, createdTime
                    .setFields("nextPageToken, files(id, name, createdTime)")//
                    .setPageToken(pageToken).execute();
            for (File file : result.getFiles()) {
                list.add(file);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        //
        return list;
    }
    public List<File> getFiles(String googleFolderIdParent) throws IOException {
        Drive driveService = getDriveService();
        
        List<File> result = new ArrayList<File>();
        Files.List request = driveService.files().list().setQ("trashed = false and '" + googleFolderIdParent + "' in parents").setSpaces("drive");

        do {
          try {
            FileList files = request.execute();

            result.addAll(files.getFiles());
            request.setPageToken(files.getNextPageToken());
          } catch (IOException e) {
            System.out.println("An error occurred: " + e);
            request.setPageToken(null);
          }
        } while (request.getPageToken() != null &&
                 request.getPageToken().length() > 0);
        

        return result;
    }
    
    
}

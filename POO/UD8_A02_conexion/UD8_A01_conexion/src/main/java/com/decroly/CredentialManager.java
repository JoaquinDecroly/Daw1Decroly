import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CredentialManager{

    public static void escribirCredenciales(String filePath, DatabaseCredentials credentials) {
        try(FileOutputStream fileWriteInit = new FileOutputStream(filePath);)
            ObjectOutputStream fileWriterFinal = new ObjectOutputStream(fileWriteInit)) {
            objectOutputStream.writeObject(credentials);
            system.out.println("Credenciales guardadas en: " + filePath);
        } catch (IOException e) {
            e.getMessage();
        }
    }

     public static DatabaseCredentials leerCredenciales(String filePath) {
         DatabaseCredentials credentials = null;
         try (FileInputStream fileIn = new FileInputStream(filePath);
              ObjectInputStream in = new ObjectInputStream(fileIn)) {
             credentials = (DatabaseCredentials) in.readObject();
             System.out.println("Credenciales leídas desde " + filePath);
         } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
             e.getMessage();
         }
         return credentials;
     }
 }

 }
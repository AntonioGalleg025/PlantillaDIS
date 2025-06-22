package es.ufv.dis.front.final2025.services;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import es.ufv.dis.front.final2025.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class Servicio implements Serializable {

    public ArrayList<Usuario> getUsuarios() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost/8081/api/ExamenFinal/Usuario"))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            ArrayList <Usuario> usuarios = gson.fromJson(response.body(), new TypeToken<ArrayList<Usuario>>(){}.getType());

            return usuarios;

        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<Usuario>();
    }
    public Usuario editarUsuario(Usuario usuario){
        try {
            Gson gson = new Gson();
            String json = gson.toJson(usuario);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost/8081/api/ExamenFinal/Usuario"))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(json))
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), Usuario.class);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}

package Servicio;

import Modelos.Divisa;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.RemoteException;
// Si la api no sirve podes generar una nueva keyAPI en  https://www.exchangerate-api.com
public class ConsultaDivisa {
    public Divisa buscarDivisa(String divisa) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/0d08555a04a8f7819024f0ef/latest/"+divisa; //pedido
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //respuesta
            return new Gson().fromJson(response.body(), Divisa.class);
        }catch (Exception e){
            throw new RemoteException("No encontre la Divisa esperada..., Por favor Reinicie el Sistema y reintente con las unidades especificadas");
        }
    }
}

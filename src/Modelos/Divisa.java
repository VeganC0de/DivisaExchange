package Modelos;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Divisa {
    @SerializedName("base_code")
    private String codigoDivisa;
    private int valor;
    @SerializedName("conversion_rates")
    private HashMap lista;
    @SerializedName("time_last_update_utc")
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public HashMap getLista() {
        return lista;
    }

    public void setLista(HashMap lista) {
        this.lista = lista;
    }

    public String getCodigoDivisa() {
        return codigoDivisa;
    }

    public void setCodigoDivisa(String codigoDivisa) {
        this.codigoDivisa = codigoDivisa;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


}

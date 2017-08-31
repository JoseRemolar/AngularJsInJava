package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Jugador;
import model.PersonData;

public class AngularJsServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        public AngularJsServlet() {
                super();
        }

        protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        		
        	String JSON = getJsonDataViaHttp("http://chess-rankings.com/t/server/api.php/jugadores/1002");
        	Gson conversor = new Gson();
        	Jugador jug =conversor.fromJson(JSON, Jugador.class);
        	

                String json = new Gson().toJson(jug);
                response.setContentType("application/json");
                response.getWriter().write(json);
        }
        public String getJsonDataViaHttp(String address){
        	 URL url;
             try {
                 // Creando un objeto URL
                 url = new URL(address);
      
                 // Realizando la petición GET
                 URLConnection con = url.openConnection();
      
                 // Leyendo el resultado
                 BufferedReader in = new BufferedReader(new InputStreamReader(
                         con.getInputStream()));
      
                 String linea;
                 String JSON = "";
                 while ((linea = in.readLine()) != null) {
                     JSON += linea;
                 }
                 return JSON;
             } catch (IOException e) {
                 System.out.println(e.getMessage());
             }
             return "FAIL*********";
        }
}
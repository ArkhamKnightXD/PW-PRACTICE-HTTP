package edu.pucmm.pw;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Connection;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;


public class Main {
    public static void main(String[] args)
    {

         String url ="http://itachi.avathartech.com:4567/opcion2.html";

        try {
             Document document=Jsoup.connect(url).get(); // comando para establecer la conexion con la url que queremos analizar

            //Punto B
            int parrafos= document.getElementsByTag("p").size();


            //Punto C
            int[] cantidad = {0};

            document.getElementsByTag("p").forEach(element ->
            { element.getElementsByTag("img").forEach(element1 ->
            {
                    cantidad[0]++;

                });
            });


            //Punto D
            int[] cantidadFormGet = {0};

            document.getElementsByTag("form").forEach(element -> {
                element.getElementsByAttributeValue("method", "get").forEach(element1 -> {
                    cantidadFormGet[0]++;
                });
            });

            int[] cantidadFormPost = {0};


            document.getElementsByTag("form").forEach(element -> {
                element.getElementsByAttributeValue("method", "post").forEach(element1 -> {
                    cantidadFormPost[0]++;
                });
            });

            int cantidaElementos = document.getAllElements().size(); // Creo que este codigo podria ser una opcion para la respuesta A

            //Punto A


            System.out.println("La cantidad totales de lineas del recurso son : " + document.html().split("\n").length);

            System.out.println("La cantidad total de parrafos <p> que contiene el documento es de: " +parrafos);

            System.out.println("La cantidad de imagenes contenidad dentro de los parrafos es de: "+ cantidad[0]);

            System.out.println("La cantidad de formularios categorizados por el method get: " + cantidadFormGet[0]);

            System.out.println("La cantidad de formularios categorizados por el method post: " + cantidadFormPost[0]);

            System.out.println("Los campos del tipo input de cada formulario son los siguientes: ");


            //Punto E
            for (Element tiposForm : document.getElementsByTag("form"))
            {
                System.out.println(tiposForm);
            }

            //punto F

            Connection.Response response = null;
            Document doc = null;
            Map<String, String> parametros = new HashMap<>();


                for (Element element : document.getElementsByTag("form")) {
                    String absURL = element.absUrl("action");

                    if (element.attr("method").equals("post")) {
                        parametros.put("asignatura", "practica1");

                        document = Jsoup.connect(absURL)
                                .method(Connection.Method.POST)
                                .data(parametros)
                                .post();

                        System.out.println(document.outerHtml());
                    }
                }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}

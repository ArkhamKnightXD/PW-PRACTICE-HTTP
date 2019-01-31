package edu.pucmm.pw;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Connection;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args)
    {

         String url ="http://itachi.avathartech.com:4567/opcion2.html";


        try {
             Document document=Jsoup.connect(url).get(); // comando para establecer la conexion con la url que queremos analizar

            Connection.Response conexion = Jsoup.connect(url).execute();
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

            //Punto A

            String pagina = conexion.body();
            int cantidadLineas = pagina.split("\n").length;

            System.out.println("La cantidad totales de lineas del recurso son : " + cantidadLineas);

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

            //Punto F

            Connection.Response response = null;
            Map<String, String> parametros = new HashMap<>();


                for (Element element : document.getElementsByTag("form")) {
                    String URL = element.absUrl("action");

                    if (element.attr("method").equals("post")) {
                        parametros.put("asignatura", "practica1");


                        document = Jsoup.connect(URL)
                                .method(Connection.Method.POST)
                                .data(parametros)
                                .header("matricula","20141336")
                                .post();

                        System.out.println(document.outerHtml());
                    }
                }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}

package edu.pucmm.pw;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Main {
    public static void main(String[] args)
    {

         String url ="https://www.pabloyglesias.com/obtener-datos-publicos-persona/";

        try {
             Document document=Jsoup.connect(url).get(); // comando para establecer la conexion con la url que queremos analizar

            int parrafos= document.getElementsByTag("p").size();

            int[] cantidad = {0};

            document.getElementsByTag("p").forEach(element ->
            { element.getElementsByTag("img").forEach(element1 ->
            {
                    cantidad[0]++;

                });
            });


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


            System.out.println("La cantidad totales de lineas del recurso son : " + document.html().split("\n").length);

            System.out.println("La cantidad total de parrafos <p> que contiene el documento es de: " +parrafos);

            System.out.println("La cantidad de imagenes contenidad dentro de los parrafos es de: "+ cantidad[0]);

            System.out.println("La cantidad de formularios categorizados por el method get: " + cantidadFormGet[0]);

            System.out.println("La cantidad de formularios categorizados por el method post: " + cantidadFormPost[0]);

            System.out.println("Los campos del tipo input de cada formulario son los siguientes: ");

            for (Element tiposForm : document.getElementsByTag("form"))
            {
                System.out.println(tiposForm);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}

package edu.pucmm.pw;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {
    public static void main(String[] args)
    {

         String url ="https://shares.telegraph.co.uk/indices/summary/index/MCX";

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

            int cantidadFormPost = document.getElementsByAttributeValue("method", "post").size();

            int cantidadFormGet = document.getElementsByAttributeValue("method", "get").size();

            document.getElementsByAttributeValue("type","text");


            System.out.println("La cantidad totales de lineas del recurso son : " + document.html().split("\n").length);

            System.out.println("La cantidad total de parrafos <p> que contiene el documento es de: " +parrafos);

            System.out.println("La cantidad de imagenes contenidad dentro de los parrafos es de: "+ cantidad[0]);

            System.out.println(cantidadFormGet);

            System.out.println(cantidadFormPost);

            System.out.println(document.getElementsByAttributeValue("type","text"));

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}

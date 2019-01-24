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

           // String textoCompleto = document.html(); // Este comando nos imprime el texto completo html

            int parrafos= document.getElementsByTag("p").size();

            int imagenes= document.getElementsByTag("img").size(); // Este codigo permite contar cuantos elemento hay del tag que uno defina

            int cantidadFormPost = document.getElementsByAttributeValue("method", "post").size();

            int cantidadFormGet = document.getElementsByAttributeValue("method", "get").size();

            document.getElementsByAttributeValue("type","text");

            int cantidadElementos = document.getAllElements().size();


           // System.out.println(textoCompleto);

            System.out.println(cantidadElementos);

            System.out.println(parrafos);

            System.out.println(imagenes);

            System.out.println(cantidadFormGet);

            System.out.println(cantidadFormPost);

            System.out.println(document.getElementsByAttributeValue("type","text"));

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}

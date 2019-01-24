package edu.pucmm.pw;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {
    public static void main(String[] args)
    {
        System.out.println("hola mundo");

        final String url ="https://shares.telegraph.co.uk/indices/summary/index/MCX";

        try {
            final Document document=Jsoup.connect(url).get(); // comando para establecer la conexion con la url que queremos analizar


          // System.out.println(document.outerHtml()); // Este comando nos imprime el codigo html de la pagina completo

            //int lines = document.html().split(System.getProperty("line.separator")).length;
           // System.out.println(lines);


            String textoCompleto2 = document.html();

            String textoCompleto = document.outerHtml();

            document.getElementsByAttribute("POST").size();

            document.getElementsByAttribute("GET").size();



            int imagenes= document.getElementsByTag("img").size();

            int parrafos= document.getElementsByTag("p").size();

            document.getElementsByAttributeValue("type","text");

            int cantidadElementos = document.getAllElements().size(); // Esto cuenta la cantidad de elementos de la pagina, pero no cuenta body ni expacios en blanco


            System.out.println(textoCompleto);

            System.out.println(cantidadElementos);

            System.out.println(parrafos); // Este codigo permite contar cuantos elemento hay del tag que uno defina

            System.out.println(imagenes);

        }catch (Exception ex){
            ex.printStackTrace();
        }



      /*  Elements ele=p.select("div#reviews");
        for (Element element: ele)
        {
            String img_url=element.select(div.prerendered);
            System.out.println("img_url");

        }*/
    }
}

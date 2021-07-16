package edu.pucmm.pw;

import edu.pucmm.pw.services.JsoupConnectionService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Connection;

public class Main {

    public static void main(String[] args) {

        JsoupConnectionService jsoupConnectionService = new JsoupConnectionService();

        Document document = jsoupConnectionService.getJsoupConnectionDocument();

        Connection.Response connectionResponse = jsoupConnectionService.getJsoupConnectionResponse();

        String wholePage = connectionResponse.body();

        int lineQuantity = wholePage.split("\n").length;

        int paragraphs = document.getElementsByTag("p").size();

        int imgQuantity = jsoupConnectionService.getImgQuantityInsideParagraphs()[0];

        int formGetQuantity = jsoupConnectionService.getFormGetQuantity()[0];

        int formPostQuantity = jsoupConnectionService.getFormPostQuantity()[0];


        System.out.println("Punto A: La cantidad totales de lineas del recurso son : " + lineQuantity);

        System.out.println("Punto B: La cantidad total de parrafos <p> que contiene el documento es de: " + paragraphs);

        System.out.println("Punto C: La cantidad de imagenes contenidad dentro de los parrafos es de: " + imgQuantity);

        System.out.println("Punto D: La cantidad de formularios categorizados por el method get: " + formGetQuantity);

        System.out.println("Punto D: La cantidad de formularios categorizados por el method post: " + formPostQuantity);

        System.out.println("Punto E: Los campos del tipo input de cada formulario son los siguientes: ");

        for (Element formType : document.getElementsByTag("form")) {
            System.out.println(formType);
        }

        System.out.println("<------------------ Punto F: ------------------->");

        jsoupConnectionService.sendPostRequestToThePage();
    }
}

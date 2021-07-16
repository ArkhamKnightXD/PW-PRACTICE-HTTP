package edu.pucmm.pw.services;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsoupConnectionService {

    private final String url ="http://itachi.avathartech.com:4567/opcion2.html";

    private Document document = getJsoupConnectionDocument();


    // Metodo encargado de establecer la conexion con la url que queremos analizar
    public Document getJsoupConnectionDocument() {

        try {

            return Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Otro metodo de conexion de jsoup
    public Connection.Response getJsoupConnectionResponse() {

        try {

            return Jsoup.connect(url).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //Punto C
    public int[] getImgQuantityInsideParagraphs() {

        int[] counter = {0};

        document.getElementsByTag("p").forEach(element -> {

            element.getElementsByTag("img").forEach(element1 -> {

                counter[0]++;
            });
        });

        return counter;
    }

    //Punto D part 1
    public int[] getFormGetQuantity() {

        int[] formGetCounter = {0};

        document.getElementsByTag("form").forEach(element -> {

            element.getElementsByAttributeValue("method", "get").forEach(element1 -> {

                formGetCounter[0]++;
            });
        });

        return formGetCounter;
    }

    //Punto D part 2
    public int[] getFormPostQuantity() {

        int[] formPostCounter = {0};

        document.getElementsByTag("form").forEach(element -> {

            element.getElementsByAttributeValue("method", "get").forEach(element1 -> {

                formPostCounter[0]++;
            });
        });

        return formPostCounter;
    }

    //Punto F
    public void sendPostRequestToThePage() {

        Map<String, String> params = new HashMap<>();

        List<Element> formElements = getJsoupConnectionDocument().getElementsByTag("form");

        for (Element element : formElements) {

            String URL = element.absUrl("action");

            if (element.attr("method").equals("post")) {

                params.put("asignatura", "practica1");

                try {

                    document = Jsoup.connect(URL)
                            .method(Connection.Method.POST)
                            .data(params)
                            .header("matricula", "20141336")
                            .post();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(document.outerHtml());
            }
        }
    }
}

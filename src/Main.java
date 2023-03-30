import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar as Séries mais populares

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest  request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // Extrair só os dados que interessam (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeSeries = parser.parse(body);

        // Exibir e manipular os dados

        for (Map<String, String> serie :
                listaDeSeries) {
            System.out.println("\u001b[1m\u001b[30m\u001b[47m"+(serie.get("title")) + "\u001b[m");
            System.out.println(serie.get("image"));
            System.out.println(serie.get("imDbRating"));

            String rating = serie.get("imDbRating");
            int rating2 = Math.round(Float.parseFloat(rating));

            System.out.println(Math.round(Float.parseFloat(rating)));

            System.out.println();
        }

    }
}
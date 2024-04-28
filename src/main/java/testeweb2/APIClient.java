package testeweb2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIClient {
	
	 public static String fetchDataFromAPI(String apiUrl) throws IOException {
	        URL url = new URL(apiUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");

	        StringBuilder response = new StringBuilder();
	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	            String inputLine;
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	        }
	        return response.toString();
	    }
}


/*
 *
 * 
Claro, vamos analisar essa classe em detalhes:

java
Copy code
public class APIClient {
Aqui estamos declarando uma classe chamada APIClient. Classes em Java são blocos de código que encapsulam dados e funcionalidades relacionadas.

java
Copy code
    public static String fetchDataFromAPI(String apiUrl) throws IOException {
Este é um método estático chamado fetchDataFromAPI. Ele recebe uma String chamada apiUrl como parâmetro, que é a URL da API da qual queremos buscar os dados. O método é declarado como static, o que significa que pode ser chamado sem a necessidade de instanciar um objeto da classe APIClient. O método também lança uma exceção do tipo IOException, que deve ser tratada caso ocorra algum erro de entrada/saída durante a execução do método.

java
Copy code
        URL url = new URL(apiUrl);
Nesta linha, estamos criando um novo objeto URL a partir da String apiUrl. Esta classe é usada para representar uma URL e nos permite manipular URLs em Java.

java
Copy code
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
Aqui, estamos abrindo uma conexão HTTP com a URL fornecida. O método openConnection() retorna um objeto URLConnection, que é então convertido para HttpURLConnection, pois estamos lidando com uma conexão HTTP.

java
Copy code
        connection.setRequestMethod("GET");
Definimos o método de requisição como "GET". Isso indica que estamos apenas solicitando dados do servidor e não estamos modificando nada no servidor.

java
Copy code
        StringBuilder response = new StringBuilder();
Criamos um objeto StringBuilder chamado response. Este objeto será usado para construir a resposta recebida da API.

java
Copy code
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
Iniciamos um bloco try-with-resources. Aqui, estamos criando um novo BufferedReader para ler os dados de entrada da conexão HTTP. Usamos um InputStreamReader para converter o fluxo de entrada binário em caracteres legíveis.

java
Copy code
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
Dentro do bloco try, estamos lendo cada linha de dados recebidos da API e anexando-as ao StringBuilder response. Este processo continua enquanto houver mais linhas de dados para ler.

java
Copy code
        }
O bloco try-with-resources garante que o BufferedReader seja fechado corretamente após a leitura dos dados da API, liberando os recursos associados.

java
Copy code
        return response.toString();
Retornamos a resposta completa da API, convertida em uma String, usando o método toString() do StringBuilder.

java
Copy code
    }
}
Aqui termina a definição da classe APIClient e do método fetchDataFromAPI.

Em resumo, esta classe fornece um método estático para fazer uma solicitação HTTP GET a uma URL de API específica e retorna os dados recebidos como uma String. Ele usa as classes URL, HttpURLConnection, BufferedReader e StringBuilder para realizar a conexão, ler os dados da API e construir a resposta.
 */
 
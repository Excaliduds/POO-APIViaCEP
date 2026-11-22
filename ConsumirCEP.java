package consumirCEP;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirCEP {

public static void main (String [] args) {
		
    System.out.println("==============================");
    System.out.println("Nome: Eduardo Pinheiro da Luz | Matrícula: 0025085");
    System.out.println("==============================");
	
		String cep = "72862-511"; // INFORMAR UM CEP PARA A BUSCA
		String url = "https://viacep.com.br/ws/"+ cep +"/json/"; // ADD O CEP NA URL PARA BUSCAR
		
	try {
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url)) // INFROME ENDEREÇO PRA CONSULTA
			.GET() // PEDE OS DADOS DO SITE
			.build(); // FINALIZA A CONSULTA
			
		HttpResponse < String > response = client.send(
				request,
				HttpResponse.BodyHandlers.ofString()
				);
		
		System.out.println(response.body());
		
	} catch (Exception e) {
		
		System.out.println("Erro ao consultar o CEP"  + e.getMessage());
		
	}
	
	}

}

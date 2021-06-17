package agenciaDeHerois;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AgenciaDeHerois {
	public static void main(String[] args) throws IOException {
		int opcao = 0;
		String linhaLista;
		List<String> listaHerois = new ArrayList<String>();
		
		Scanner entrada = new Scanner(System.in);
		// Altere o caminho do File para o seu 
		File arquivo = new File("/SEU_CAMINHO/DE_DIRETORIO/herois.txt");
		BufferedReader arquivoBuffer = new BufferedReader(new FileReader(arquivo));
		
		System.out.println("\n ----- AGÊNCIA DE HERÓIS ----- \n"
				+ "Iniciando sicronização de dados...\n"
				+ "Sincronizado com sucesso! \n");
		
		System.out.println("Heróis cadastrados: ");
		while((linhaLista = arquivoBuffer.readLine()) != null) {
			System.out.print(linhaLista + "\n");
			listaHerois.add(linhaLista);
		}
		
		arquivoBuffer.close();
		
		while(opcao != 2) {
			System.out.println("\n ----- Enviar herói aleatório em missão? 1 - Sim | 2 - Não");
			opcao = entrada.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("Selecionando herói....\n");
					String heroiAleatorio = listaHerois.get(new Random().nextInt(listaHerois.size()));
					System.out.println("Herói selecionado: " + heroiAleatorio);
					break;
				case 2: 
					System.out.println("Encerrando conexão..." 
							+ "Obrigado por utilizar a Agência de Heróis :)");
					entrada.close();
					break;
			}
		}
	}
}

package br.com.rafael.ubs.model;

public enum ScoresEnum {
	
	DesempenhoMedianoOuUmPoucoAbaixoDaMedia ("Desempenho mediano ou  um pouco abaixo da média", 1),
	DesempenhoAcimaDaMédia ("Desempenho acima da média", 2),
	DesempenhoMuitoAcimaDaMédia ("Desempenho muito acima da média", 3);
	
	public String descricaoScore;
	public int codigoScore;
	ScoresEnum(String frase, int valor){
		descricaoScore = frase;
		codigoScore = valor;
	}
	
}

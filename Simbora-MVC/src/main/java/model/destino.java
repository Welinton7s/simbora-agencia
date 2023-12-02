package model;

public class destino {
	private String partida;
	private String destino;
	private String data;
	private int quantidade_de_passageiros;

	// getters e setters
	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQuantidade_de_passageiros() {
		return quantidade_de_passageiros;
	}

	public void setQuantidade_de_passageiros(int quantidade_de_passageiros) {
		this.quantidade_de_passageiros = quantidade_de_passageiros;
	}
}
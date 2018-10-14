package jogador;

public class Player {
	
	protected String level;
	protected String palpite;
	protected String letrasDigitadas;
	protected String dataInicio;
	protected String status;
	protected String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPalpite() {
		return palpite;
	}
	public void setPalpite(String palpite) {
		this.palpite = palpite;
	}
	public String getLetrasDigitadas() {
		return letrasDigitadas;
	}
	public void setLetrasDigitadas(String letrasDigitadas) {
		this.letrasDigitadas = letrasDigitadas;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

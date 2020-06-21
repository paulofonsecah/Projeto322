public class Armas {
	
	private int alcance;
	private int bonus;
	private boolean ehdestruida;
	

	public Armas(int a, int b, boolean d) { //ablubluulull�l�
		alcance = a;
		bonus = b;
		ehdestruida = d;
	}	
	
	public boolean isEhdestruida() {
		return ehdestruida;
	}
	public void setEhdestruida(boolean ehdestruida) {
		this.ehdestruida = ehdestruida;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getAlcance() {
		return alcance;
	}
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}	
	
}
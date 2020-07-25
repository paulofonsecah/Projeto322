
public class Heroi extends MapElement{
	protected int salaX;
	protected int salaY;
	
	public Heroi(int x, int y, int salaX, int salaY) {
		super(x,y);
		this.salaX = salaX;
		this.salaY = salaY;
	}

    public int getSalaX(){
    	return salaX;
    }
    public void setSalaX(int salaX){
    	this.salaX = salaX;
    }
    public int getSalaY(){
    	return salaY;
    }
    public void setSalaY(int salaY){
    	this.salaY = salaY;
    }
}
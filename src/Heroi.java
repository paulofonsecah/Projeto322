
public class Heroi extends MapElement{
	
	public Heroi(int x, int y) {
		super(x,y);
	}
	public void moveHeroiVertical(int delta) {
        this.y = this.y + delta;
        
    }

    public void moveHeroiHorizontal(int delta) {
        this.x = this.x + delta;
        
        }

	


}
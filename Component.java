//package draw;

class Component
{
	private int x, y;
	
	public Component(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public Component setX(int x)
	{
		this.x = x;
		
		return this;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public Component setY(int y)
	{
		this.y = y;
		
		return this;
	}
	
	public void draw(char[][] screen)
	{
		//screen[x][y] = '*';
		draw(screen, 0, 0);
	}
	
	public void draw(char[][] screen, int xoff, int yoff)
	{
		screen[x+xoff][y+yoff] = '*';
	}
}

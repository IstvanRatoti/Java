//package draw;

public class Draw
{
	private int numRow, numCol;
	private char[][] content;
	
	public Draw(int rows, int columns)
	{
		this.content = new char[rows][columns];
		this.numRow = rows;
		this.numCol = columns;
	}
	
	public char[][] getContent()
	{
		return this.content;
	}
	
	public static void main(String[] args)
	{
		Container outer = new Container(4, 4);
		Container middle = new Container(5, 5);
		Container inner = new Container(6, 6);
		
		outer.add(middle);
		middle.add(inner);
		
		outer.add(new Component(1,1));
		middle.add(new Component(2,2));
		inner.add(new Component(3,3));
		
		outer.draw(screen.content);
		
		Draw screen = new Draw(25, 80);
		new Component(3,7).draw(screen.getContent());
		new Component(5,71).draw(screen.getContent());
		new Component(22,5).draw(screen.getContent());
		screen.printScreen();
	}
	
	public void printScreen()
	{
		for(int i=0;i<numRow;i++)
		{
			for(int j=0;j<numCol;j++)
			{
				if((0==i)||(numRow==i))
				{
					System.out.print('#');
				}
				else if((0==j)||(numCol==j))
				{
					System.out.print('#');
				} 
				else
					System.out.print(content[i][j]);
			}
		}
			
		System.out.println();
	}
}

/*class Component
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

class Container extends Component
{
	private List<Component> components;
	
	public Container(int x, int y)
	{
		super(x, y);
	}
	
	public Container add(Component component)
	{
		components.add(component);
		
		return this;
	}
}*/

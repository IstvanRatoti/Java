import java.util.List;
import java.util.ArrayList;

//package draw;

class Container extends Component
{
	private List<Component> components;
	
	public Container(int x, int y)
	{
		this.components = new ArrayList();
		this.components.add(new Component(x, y));
	}
	
	public List<Component> getComponents()
	{
		return components;
	}
	
	public Container add(Component component)
	{
		this.components.add(component);
		
		return this;
	}
	
	public Container add(Container container)
	{
		this.components.addAll(container.getComponents());
	}
	
	public void draw()
	{
		this(0, 0);
	}
	
	public void draw(int xoff, int yoff)
	{
		for (Component element : this.components)
			element.draw(screen, xoff, yoff);
	}
}

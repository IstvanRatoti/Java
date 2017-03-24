import java.util.List;
import java.util.ArrayList;

//package draw;

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
}

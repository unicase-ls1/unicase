package org.unicase.changetracking.common;

abstract class AbstractResource{
	abstract protected void begin(ResourceClient client, Object object);
 	abstract protected void end(ResourceClient client, Object object); 
public void consume(ResourceClient client, Object object){
	begin(client, object);
	try { 
		client.consume(this, object); 
	} finally {
		end(client, object);
	}
}
} 
interface ResourceClient{
	abstract public void consume(AbstractResource resource, Object object ); 
}

class Option<T>{
	private T val;
	
	public Option(){//Missing value constructor
		val = null;
	}
	
	public Option(T val){
		this.val = val;
	}
	
	public boolean hasValue(){
		return this.val != null;
	}
	
	public T getValue(){
		if(val == null){
			throw new RuntimeException("Idiot!");
		}
		return val;
	}
	
}

class FileReaderResource extends AbstractResource{

	@Override
	protected void begin(ResourceClient client, Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void end(ResourceClient client, Object object) {
		// TODO Auto-generated method stub
		
	}
	
}

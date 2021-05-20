package resources;

public enum APIResources {
	
	ListUsers("/users"),
	CreateUser("/users"),
	RegisterUnsuccess("/register");
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}

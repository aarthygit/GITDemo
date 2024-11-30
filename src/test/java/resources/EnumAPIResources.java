package resources;

//enum is the special class in java which has collections of constants or methods

public enum EnumAPIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),

	deletePlaceAPI("/maps/api/place/delete/json");
	
	public String resource;

	EnumAPIResources(String resource) {
		this.resource=resource;

	
	}
	
	public String getResource() {
		return resource;
		
	}


}

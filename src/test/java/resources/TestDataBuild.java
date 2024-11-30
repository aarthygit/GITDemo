package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddLocation;
import pojo.Location;

public class TestDataBuild {

	public AddLocation addPlacePayLoad(String name, String language, String address) {
		AddLocation l = new AddLocation();
		l.setAccuracy(50);
		l.setName(name);
		l.setPhone_number("(+91) 983 893 3937");
		l.setAddress(address);
		l.setWebsite("https://rahulshettyacademy.com");
		l.setLanguage(language);
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		l.setTypes(myList);

		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		l.setLocation(loc);
		return l;

	}

	 public String deletePlacePayload(String place_id)
	 {
	 return "{\r\n\"place_id\":\""+place_id+"\"\r\n}";
	 }

}

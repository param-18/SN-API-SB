package com.illuminati.scnetapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.illuminati.scnetapi.entity.Location;
import com.illuminati.scnetapi.repository.*;

@Service
public class LocationService {
	
//	private List<Location> locations = new ArrayList<>();
	
	@Autowired
	LocationRepository locrepo;
	
    public List<Location> getAllLocations(){
    	List<Location> locations = new ArrayList<>();
		locrepo.findAll().forEach(locations::add);;
		return locations;
	}

	public Location getLocation(String id) {
		//locations.stream().filter(location -> id.equals(location.getId())).findFirst().orElse(null);
		return locrepo.findById(id).get();
	}
 
	public void addLocation(Location location) {
//		locations.add(location);
		locrepo.save(location);
	}
	
	public boolean updateLocation(String id , Location location) {
//		 Location matchedLocation = locations.stream().filter(locationO -> id.equals(locationO.getId())).findFirst().orElse(null);
//	       	 
//		 if(matchedLocation == null)
//			 return false;
//		 locations.set(locations.indexOf(matchedLocation), location);
//		 return true;
		
		//in this method id must be same 
		locrepo.save(location);
		return true;
	}
	
	public boolean deleteLocation(String id) {
//		Location matchedLocation = locations.stream().filter(locationO -> id.equals(locationO.getId())).findFirst().orElse(null);
//      	 
//		 if(matchedLocation == null)
//			 return false;
//		 locations.remove(matchedLocation);
//		 return true;
		
		locrepo.deleteById(id);
		return true;
	}
}

package com.illuminati.scnetapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.illuminati.scnetapi.entity.*;
import com.illuminati.scnetapi.services.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	LocationService ls;
	
	@RequestMapping(value="/locations")
	public List<Location> getAllLocations(){
		
		
		
		return ls.getAllLocations();
	}
	
	@RequestMapping(value = "/locations/{id}")
	   public Location getLocation(@PathVariable String id) {
		   return ls.getLocation(id);
	 }
	
	@RequestMapping(method=RequestMethod.POST , value="/addlocations")
	public void addLocation(@RequestBody Location location) {
		ls.addLocation(location);
	}

	@RequestMapping(method=RequestMethod.POST , value="/updatelocations/{id}")
	public boolean updateLocation(@RequestBody Location location , @PathVariable String id) {
		return ls.updateLocation(id ,location);
	}
	
	@RequestMapping(value="/deletelocation/{id}")
	public boolean deleteLocation(@PathVariable String id) {
		return ls.deleteLocation(id);
	}
}

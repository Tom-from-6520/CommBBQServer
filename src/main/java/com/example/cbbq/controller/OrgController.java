package com.example.cbbq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.example.cbbq.model.*;
import com.example.cbbq.repository.*;

@Controller
@RequestMapping("/org")
public class OrgController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private OrganizerRepository organizerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private FoodRepository foodRepository;
    
	@GetMapping({"/{id}", "/{id}/info"})
	public @ResponseBody Organizer getOrgById(@PathVariable(name = "id") String id) {
		// return a JSON object of the organizer
		return organizerRepository.findById(Long.valueOf(id)).orElse(null);
	}

	// @GetMapping("/{id}/info")
	// public String getOrgInfo(@PathVariable(name = "id") String id) {
	// 	// return a JSON object of the organizer's info
	// 	return null;
	// }

	@PutMapping("/{id}/info")
	public @ResponseBody Organizer updateOrgInfo(@PathVariable(name = "id") String id, @RequestBody Organizer newOrg) {
		// return the new JSON object of the organizer's info
        Organizer oldOrg = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        if (oldOrg != null) {
            oldOrg.setUsername(newOrg.getUsername());
            oldOrg.setPassword(newOrg.getPassword());
            oldOrg.setName(newOrg.getName());
            oldOrg.setPhone(newOrg.getPhone());
            oldOrg.setAddresses(newOrg.getAddresses());
            oldOrg.setHostingEvents(newOrg.getHostingEvents());
            organizerRepository.save(oldOrg);
        }
		return oldOrg;
	}

	@GetMapping("/{id}/addresses")
	public @ResponseBody Iterable<Address> getOrgAddressList(@PathVariable(name = "id") String id) {
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        List<Address> addressList = new ArrayList<>();
        if (org != null) {
            for (Address a : org.getAddresses()) {
                Address address = addressRepository.findById(a.getId()).orElse(null);
                if (address != null) {
                    addressList.add(address);
                }
            }
        }
		return addressList;
	}

	@PostMapping("/{id}/addresses")
	public @ResponseBody Address createOrgAddress(@PathVariable(name = "id") String id, @RequestBody Address address) {
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        if (org != null) {
            Address newAddress = new Address();
            newAddress.setOrg(org);
			newAddress.setStreet_address(address.getStreet_address());
			newAddress.setCity(address.getCity());
			newAddress.setUs_state(address.getUs_state());
			newAddress.setZip_code(address.getZip_code());
			newAddress.setCountry(address.getCountry());
			addressRepository.save(newAddress);
			return newAddress;
        }
		return null;
	}

	@GetMapping({"/{id}/addresses/{address_id}", "/{id}/addresses/{address_id}/info"})
	public @ResponseBody Address getOrgAddress(@PathVariable(name = "id") String id, @PathVariable(name = "address_id") String addr_id) {
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        Address address = addressRepository.findById(Long.valueOf(addr_id)).orElse(null);
        if(org != null && address != null && org.getAddresses().contains(address)) {
            return address;
        }
		return null;
	}

	@DeleteMapping("/{id}/addresses/{address_id}")
	public @ResponseBody Organizer deleteOrgAddress(@PathVariable(name = "id") String id, @PathVariable(name = "address_id") String addr_id) {
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        Address address = addressRepository.findById(Long.valueOf(addr_id)).orElse(null);
        if(org != null && address != null && org.getAddresses().contains(address)) {
			addressRepository.delete(address);
			org.getAddresses().remove(address);
			organizerRepository.save(org);
        }
		return org;
	}

	@PutMapping("/{id}/addresses/{address_id}/info")
	public @ResponseBody Address updateOrgAddressInfo(@PathVariable(name = "id") String id, @PathVariable(name = "address_id") String addr_id, @RequestBody Address newAddress) {
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
		Address oldAddress = addressRepository.findById(newAddress.getId()).orElse(null);
        if (org != null && oldAddress != null && org.getAddresses().contains(oldAddress)) {
			oldAddress.setStreet_address(newAddress.getStreet_address());
			oldAddress.setCity(newAddress.getCity());
			oldAddress.setUs_state(newAddress.getUs_state());
			oldAddress.setZip_code(newAddress.getZip_code());
			oldAddress.setCountry(newAddress.getCountry());
			addressRepository.save(oldAddress);
			return oldAddress;
        }
		return null;
	}

	@GetMapping("/{id}/events")
	public @ResponseBody Iterable<Event> getOrgEventsList(@PathVariable(name = "id") String id) {
		// return the list of events the organizer hosts
        Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        List<Event> hostingList = new ArrayList<>();
        if (org != null) {
            for (Event e : org.getHostingEvents()) {
                Event event = eventRepository.findById(e.getId()).orElse(null);
                if (event != null) {
                    hostingList.add(event);
                }
            }
        }
		return hostingList;
	}

	@PostMapping("/{id}/events")
	public @ResponseBody Event createOrgEvent(@PathVariable(name = "id") String id, @RequestBody Event event) {
		// create an event and add the event_id to the list of events hosted by the organizer
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        if (org != null) {
            Event newEvent = new Event();
            newEvent.setOrg(org);
			Address addr = addressRepository.findById(event.getAddress().getId()).orElse(null);
            if (addr != null)
				newEvent.setAddress(addr);
			newEvent.setName(event.getName());
			newEvent.setEventTime(event.getEventTime());
			newEvent.setPrice(event.getPrice());
			eventRepository.save(newEvent);
			return newEvent;
        }
        return null;
	}

	@GetMapping({"/{id}/events/{event_id}", "/{id}/events/{event_id}/info"})
	public @ResponseBody Event getOrgEvent(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// return the detail of an event hosted by the organizer
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        Event event = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
        if(org != null && event != null && org.getHostingEvents().contains(event)) {
            return event;
        }
		return null;
	}

	@DeleteMapping("/{id}/events/{event_id}")
	public @ResponseBody Organizer deleteOrgEvent(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// delete the event hosted by the organizer
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        Event event = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
        if(org != null && event != null && org.getHostingEvents().contains(event)) {
			eventRepository.delete(event);
			org.getHostingEvents().remove(event);
			organizerRepository.save(org);
        }
		return org;
	}
	
	// @GetMapping("/{id}/events/{event_id}/info")
	// public String getOrgEventInfo(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
	// 	// return the detail of an event hosted by the organizer
	// 	return null;
	// }

	@PutMapping("/{id}/events/{event_id}/info")
	public @ResponseBody Event updateOrgEventInfo(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id, @RequestBody Event event) {
		// update the info of the event hosted by the organizer
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        Event oldEvent = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
        if(org != null && oldEvent != null && org.getHostingEvents().contains(oldEvent)) {
			Address addr = addressRepository.findById(event.getAddress().getId()).orElse(null);
            if (addr != null)
				oldEvent.setAddress(addr);
			oldEvent.setName(event.getName());
			oldEvent.setEventTime(event.getEventTime());
			oldEvent.setPrice(event.getPrice());
			eventRepository.save(oldEvent);
			return oldEvent;
		}
		return null;
	}

	@GetMapping("/{id}/events/{event_id}/food")
	public @ResponseBody Iterable<Food> getEventFoodList(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        Event event = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
        List<Food> foodList = new ArrayList<>();
		if(org != null && event != null && org.getHostingEvents().contains(event)) {
            for (Food f : event.getServingFoods()) {
				Food food = foodRepository.findById(f.getId()).orElse(null);
				if (food != null) {
					foodList.add(food);
				}
			}
        }
		return foodList;
	}

	@PostMapping("/{id}/events/{event_id}/food")
	public @ResponseBody Event addEventFood(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id, @RequestParam(name = "food_id") String food_id) {
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        Event event = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
		Food food = foodRepository.findById(Long.valueOf(food_id)).orElse(null);
		if(org != null && event != null && food != null && org.getHostingEvents().contains(event)) {
            event.getServingFoods().add(food);
			eventRepository.save(event);
        }
		return event;
	}

	@GetMapping("/{id}/events/{event_id}/food/{food_id}")
	public @ResponseBody Food getEventFood(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id, @PathVariable(name = "food_id") String food_id) {
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        Event event = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
		Food food = foodRepository.findById(Long.valueOf(food_id)).orElse(null);
		if(org != null && event != null && food != null && org.getHostingEvents().contains(event) && event.getServingFoods().contains(food)) {
            return food;
        }
		return null;
	}

	@DeleteMapping("/{id}/events/{event_id}/food/{food_id}")
	public @ResponseBody Event deleteEventFood(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id, @PathVariable(name = "food_id") String food_id) {
		Organizer org = organizerRepository.findById(Long.valueOf(id)).orElse(null);
        Event event = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
		Food food = foodRepository.findById(Long.valueOf(food_id)).orElse(null);
		if(org != null && event != null && food != null && org.getHostingEvents().contains(event) && event.getServingFoods().contains(food)) {
            event.getServingFoods().remove(food);
			eventRepository.save(event);
        }
		return null;
	}
}
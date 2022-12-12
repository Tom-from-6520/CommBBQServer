package com.example.cbbq.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.cbbq.model.*;
import com.example.cbbq.repository.*;

// import org.apache.tomcat.util.json.JSONParser;
// import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patron")
public class PatronController {
    @Autowired
    private PatronRepository patronRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private OrganizerRepository organizerRepository;

    @GetMapping({"/{id}", "/{id}/info"})
	public @ResponseBody Patron getPatronById(@PathVariable(name = "id") String id) {
		return patronRepository.findById(Long.valueOf(id)).orElse(null);
	}

	// @GetMapping("/info")
	// public String getPatronInfo(@PathVariable(name = "id") String id) {
	// 	return null;
	// }

	@PutMapping("/{id}/info")
	public @ResponseBody Patron updatePatronInfo(@PathVariable(name = "id") String id, @RequestBody Patron newPatron) {
        Patron oldPatron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        if(oldPatron != null) {
            oldPatron.setUsername(newPatron.getUsername());
            oldPatron.setName(newPatron.getName());
            oldPatron.setPhone(newPatron.getPhone());
            oldPatron.setPassword(newPatron.getPassword());
            oldPatron.setFavoriteOrgs(newPatron.getFavoriteOrgs());
            oldPatron.setFavoriteEvents(newPatron.getFavoriteEvents());
            oldPatron.setAttendingEvents(newPatron.getAttendingEvents());
            patronRepository.save(oldPatron);
        }
		return oldPatron;
	}

	@GetMapping("/{id}/attend")
	public @ResponseBody Iterable<Event> getAttendingEventsList(@PathVariable(name = "id") String id) {
        Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        List<Event> attendingList = new ArrayList<>();
        if(patron != null) {
            for (Event e : patron.getAttendingEvents()) {
                Event event = eventRepository.findById(e.getId()).orElse(null);
                if (event != null) {
                    attendingList.add(event);
                }
            }
        }
        return attendingList;
	}

	@PostMapping("/{id}/attend")
	public @ResponseBody Patron addAttendingEvent(@PathVariable(name = "id") String id, @RequestParam(name = "event_id") String event_id) {
		Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        Event newEvent = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
        if(patron != null && newEvent != null) {
            patron.getAttendingEvents().add(newEvent);
            patronRepository.save(patron);
        }
		return patron;
	}

	@GetMapping("/{id}/attend/{event_id}")
	public @ResponseBody Event getAttendingEvent(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        Event event = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
        if(patron != null && event != null) {
            return event;
        }
		return null;
	}

	@DeleteMapping("/{id}/attend/{event_id}")
	public @ResponseBody Patron deleteEventAttendance(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
        Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        Event event = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
        if(patron != null && event != null) {
            patron.getAttendingEvents().remove(event);
            patronRepository.save(patron);
        }
		return patron;
	}

	@GetMapping("/{id}/fav/org")
	public @ResponseBody Iterable<Organizer> getFavoriteOrgsList(@PathVariable(name = "id") String id) {
		Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        List<Organizer> favOrgList = new ArrayList<>();
        if(patron != null) {
            for (Organizer org : patron.getFavoriteOrgs()) {
                Organizer organizer = organizerRepository.findById(org.getId()).orElse(null);
                if (organizer != null) {
                    favOrgList.add(organizer);
                }
            }
        }
        return favOrgList;
	}

	@PostMapping("/{id}/fav/org")
	public @ResponseBody Patron addFavoriteOrg(@PathVariable(name = "id") String id, @RequestParam(name = "org_id") String org_id) {
		Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        Organizer newOrg = organizerRepository.findById(Long.valueOf(org_id)).orElse(null);
        if(patron != null && newOrg != null) {
            patron.getFavoriteOrgs().add(newOrg);
            patronRepository.save(patron);
        }
		return patron;
	}

	@GetMapping("/{id}/fav/org/{org_id}")
	public @ResponseBody Organizer getFavOrg(@PathVariable(name = "id") String id, @PathVariable(name = "org_id") String org_id) {
		Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        Organizer org = organizerRepository.findById(Long.valueOf(org_id)).orElse(null);
        if(patron != null && org != null) {
            return org;
        }
		return null;
	}

	@DeleteMapping("/{id}/fav/org/{org_id}")
	public @ResponseBody Patron deleteFavoriteOrg(@PathVariable(name = "id") String id, @PathVariable(name = "org_id") String org_id) {
		Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        Organizer org = organizerRepository.findById(Long.valueOf(org_id)).orElse(null);
        if(patron != null && org != null) {
            patron.getFavoriteOrgs().remove(org);
            patronRepository.save(patron);
        }
		return patron;
	}

	
	@GetMapping("/{id}/fav/events")
	public @ResponseBody Iterable<Event> getFavoriteEventsList(@PathVariable(name = "id") String id) {
		Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        List<Event> favEventList = new ArrayList<>();
        if(patron != null) {
            for (Event e : patron.getFavoriteEvents()) {
                Event event = eventRepository.findById(e.getId()).orElse(null);
                if (event != null) {
                    favEventList.add(event);
                }
            }
        }
        return favEventList;
	}

	@PostMapping("/{id}/fav/events")
	public @ResponseBody Patron addFavoriteEvent(@PathVariable(name = "id") String id, @RequestParam(name = "event_id") String event_id) {
		// add the new organizer into the patron's favorite events list
		Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        Event newEvent = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
        if(patron != null && newEvent != null) {
            patron.getFavoriteEvents().add(newEvent);
            patronRepository.save(patron);
        }
		return patron;
	}

	@GetMapping("/{id}/fav/events/{event_id}")
	public @ResponseBody Event getFavEvent(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// get the details on a patron's favorite event
        Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        Event event = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
        if(patron != null && event != null && patron.getFavoriteEvents().contains(event)) {
            return event;
        }
		return null;
	}

	@DeleteMapping("/{id}/fav/events/{event_id}")
	public @ResponseBody Patron deleteFavoriteEvent(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		Patron patron = patronRepository.findById(Long.valueOf(id)).orElse(null);
        Event event = eventRepository.findById(Long.valueOf(event_id)).orElse(null);
        if(patron != null && event != null) {
            patron.getFavoriteEvents().remove(event);
            patronRepository.save(patron);
        }
		return patron;
	}
}
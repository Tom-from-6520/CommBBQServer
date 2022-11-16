package com.example.cbbq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class CBBQApplication {

	public static void main(String[] args) {
		SpringApplication.run(CBBQApplication.class, args);
	}

	@GetMapping("/")
	public String simpleRequest(HttpServletResponse res) {
		StringBuilder sb = new StringBuilder();
		try {
			Scanner in = new Scanner(new File("C:\\Users\\Tom\\codespace\\vscode_test\\cbbq\\cbbq\\src\\main\\resources\\smt.txt"));
			while(in.hasNextLine()) {
				sb.append(in.nextLine());
			}
			in.close();

			res.setStatus(HttpStatus.OK.value());
			return sb.toString();
		} catch (FileNotFoundException e) {
			res.setStatus(HttpStatus.BAD_REQUEST.value());
			return "bad";
		}
	}

	@GetMapping("/patron/{id}")
	public String getPatronById(@PathVariable(name = "id") String id) {
		// TODO: return a JSON object of the patron
		return null;
	}

	@GetMapping("/patron/{id}/info")
	public String getPatronInfo(@PathVariable(name = "id") String id) {
		// TODO: return a JSON object of the patron's info
		return null;
	}

	@PutMapping("/patron/{id}/info")
	public String updatePatronInfo(@PathVariable(name = "id") String id) {
		// TODO: return the new JSON object of the patron's info
		return null;
	}

	@GetMapping("/patron/{id}/attend")
	public String getAttendingEventsList(@PathVariable(name = "id") String id) {
		// TODO: return the list of events the patron attends
		return null;
	}

	@PostMapping("/patron/{id}/attend")
	public String addAttendingEvent(@PathVariable(name = "id") String id, @RequestParam(name = "event_id") String event_id) {
		// TODO: add the new event to the list of patron's attending events
		return null;
	}

	@GetMapping("/patron/{id}/attend/{event_id}")
	public String getAttendingEvent(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// TODO: get the details on the event the patron attend
		return null;
	}

	@DeleteMapping("/patron/{id}/attend/{event_id}")
	public String deleteEventAttendance(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// TODO: delete the attendance of the patron in an event
		return null;
	}

	@GetMapping("/patron/{id}/fav/org")
	public String getFavoriteOrgsList(@PathVariable(name = "id") String id) {
		// TODO: get the list of the patron's favorite organizers
		return null;
	}

	@PostMapping("/patron/{id}/fav/org")
	public String addFavoriteOrg(@PathVariable(name = "id") String id, @RequestParam(name = "org_id") String org_id) {
		// TODO: add the new organizer into the patron's favorite organizers list
		return null;
	}

	@GetMapping("/patron/{id}/fav/{org_id}")
	public String getFavOrg(@PathVariable(name = "id") String id, @PathVariable(name = "org_id") String org_id) {
		// TODO: get the details on a patron's favorite organizer
		return null;
	}

	@DeleteMapping("/patron/{id}/fav/{org_id}")
	public String deleteFavoriteOrg(@PathVariable(name = "id") String id, @PathVariable(name = "org_id") String org_id) {
		// TODO: delete the organizer id in the list of patron's favorite
		return null;
	}

	
	@GetMapping("/patron/{id}/fav/events")
	public String getFavoriteEventsList(@PathVariable(name = "id") String id) {
		// TODO: get the list of the patron's favorite events
		return null;
	}

	@PostMapping("/patron/{id}/fav/events")
	public String addFavoriteEvent(@PathVariable(name = "id") String id, @RequestParam(name = "event_id") String event_id) {
		// TODO: add the new organizer into the patron's favorite events list
		return null;
	}

	@GetMapping("/patron/{id}/fav/{event_id}")
	public String getFavEvent(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// TODO: get the details on a patron's favorite event
		return null;
	}

	@DeleteMapping("/patron/{id}/fav/{event_id}")
	public String deleteFavoriteEvent(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// TODO: delete the event id in the list of patron's favorite
		return null;
	}

	@GetMapping("/org/{id}")
	public String getOrgById(@PathVariable(name = "id") String id) {
		// TODO: return a JSON object of the organizer
		return null;
	}

	@GetMapping("/org/{id}/info")
	public String getOrgInfo(@PathVariable(name = "id") String id) {
		// TODO: return a JSON object of the organizer's info
		return null;
	}

	@PutMapping("/org/{id}/info")
	public String updateOrgInfo(@PathVariable(name = "id") String id) {
		// TODO: return the new JSON object of the organizer's info
		return null;
	}

	@GetMapping("/org/{id}/events")
	public String getOrgEventsList(@PathVariable(name = "id") String id) {
		// TODO: return the list of events the organizer hosts
		return null;
	}

	@PostMapping("/org/{id}/events")
	public String createOrgEvent(@PathVariable(name = "id") String id) {
		// TODO: create an event and add the event_id to the list of events hosted by the organizer
		return null;
	}

	@GetMapping("/org/{id}/events/{event_id}")
	public String getOrgEvent(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// TODO: return the detail of an event hosted by the organizer
		return null;
	}

	@DeleteMapping("/org/{id}/events/{event_id}")
	public String deleteOrgEvent(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// TODO: delete the event hosted by the organizer
		return null;
	}
	
	@GetMapping("/org/{id}/events/{event_id}/info")
	public String getOrgEventInfo(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// TODO: return the detail of an event hosted by the organizer
		return null;
	}

	@PutMapping("/org/{id}/events/{event_id}")
	public String updateOrgEventInfo(@PathVariable(name = "id") String id, @PathVariable(name = "event_id") String event_id) {
		// TODO: update the info of the event hosted by the organizer
		return null;
	}
}

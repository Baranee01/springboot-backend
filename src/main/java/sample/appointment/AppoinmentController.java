package sample.appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud/appointment/")
public class AppoinmentController {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@GetMapping("/getall")
	public List<AppointmentDetails> getAllusers(){
		return this.appointmentRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<AppointmentDetails> getbyId(@PathVariable(value = "id") Long userid){
		return this.appointmentRepository.findById(userid);
	}
	
	@PostMapping("/create")
	public AppointmentDetails createappoinment(@RequestBody AppointmentDetails appoinment) {
		return this.appointmentRepository.save(appoinment);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteappoinment(@PathVariable(value = "id") Long appid) {
		this.appointmentRepository.deleteById(appid);
		return ("Deleted ID:"+appid);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<AppointmentDetails> updateappointment(@PathVariable(value = "id") Long appid,
			@Validated @RequestBody AppointmentDetails appointment) {
		AppointmentDetails entry = appointmentRepository.findById(appid).orElseThrow();
		entry.setTitle(appointment.getTitle());
		entry.setDescription(appointment.getDescription());
		entry.setDatetime(appointment.getDatetime());
		return ResponseEntity.ok(this.appointmentRepository.save(entry));
	}
}

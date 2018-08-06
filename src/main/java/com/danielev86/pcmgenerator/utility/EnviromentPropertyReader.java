package com.danielev86.pcmgenerator.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnviromentPropertyReader {

	@Autowired
	private Environment env;
	
	public String getFieldLastName() {
		return env.getProperty("cyclist_field_lastname");
	}
	
	public String getFieldFirstName() {
		return env.getProperty("cyclist_field_firstname");
	}
	
	public String getFieldCharacPlain() {
		return env.getProperty("cyclist_field_charac_plain");
	}

	public String getFieldCharacMountain() {
		return env.getProperty("cyclist_field_charac_mountain");
	}
	
	public String getFieldCharacDownHilling() {
		return env.getProperty("cyclist_field_charac_downhilling");
	}
	
	public String getFieldCharacCobble() {
		return env.getProperty("cyclist_field_charac_cobble");
	}
	
	public String getFieldCharacTimetrial() {
		return env.getProperty("cyclist_field_charac_timetrial");
	}
	
	public String getFieldCharacPrologue() {
		return env.getProperty("cyclist_field_charac_prologue");
	}
	
	public String getFieldCharacSprint() {
		return env.getProperty("cyclist_field_charac_sprint");
	}
	
	public String getFieldCharacAcceleration() {
		return env.getProperty("cyclist_field_charac_acceleration");
	}
	
	public String getFieldCharacResistance() {
		return env.getProperty("cyclist_field_charac_resistance");
	}
	
	public String getFieldCharacRecuperation() {
		return env.getProperty("cyclist_field_charac_i_recuperation");
	}
	
	public String getFieldCharacHill() {
		return env.getProperty("cyclist_field_charac_hill");
	}
	
	public String getFieldCharacBarouder() {
		return env.getProperty("cyclist_field_charac_baroudeur");
	}
	
	public String getFieldCharacEndurance() {
		return env.getProperty("cyclist_field_charac_endurance");
	}
	
}

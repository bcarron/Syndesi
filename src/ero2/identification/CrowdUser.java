package ero2.identification;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Represents a smartphone user part of the crowd
 * 
 * @author Blaise
 *
 */
public class CrowdUser {
	int id;
	String ipaddr;
	String agent;
	String name;
	String surname;
	String office;
	int targetLight;
	int targetTemp;
	ArrayList<String> availableSensors;
	CrowdData lastData;
	
	public CrowdUser(int id, String ipaddr, String agent, String name, String surname, String office, int targetLight, int targetTemp, ArrayList<String> availableSensors){
		this.id = id;
		this.ipaddr = ipaddr;
		this.agent = agent;
		this.name = name;
		this.surname = surname;
		this.office = office;
		this.targetLight = targetLight;
		this.targetTemp = targetTemp;
		this.availableSensors = availableSensors;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getJSON(){
		JSONObject representation = new JSONObject();
		representation.put("id",id);
		representation.put("ip",ipaddr);
		representation.put("device",agent);
		representation.put("name",name);
		representation.put("surname",surname);
		representation.put("office",office);
		representation.put("target light",targetLight);
		representation.put("target temp",targetTemp);
		JSONArray availableSensorsArray = new JSONArray();
		availableSensorsArray.addAll(availableSensors);
		representation.put("available sensors",availableSensorsArray);
		return representation;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public int getTargetLight() {
		return targetLight;
	}

	public void setTargetLight(int targetLight) {
		this.targetLight = targetLight;
	}

	public int getTargetTemp() {
		return targetTemp;
	}

	public void setTargetTemp(int targetTemp) {
		this.targetTemp = targetTemp;
	}
	
	public ArrayList<String> getAvailableSensors() {
		return availableSensors;
	}

	public void setAvailableSensors(ArrayList<String> availableSensors) {
		this.availableSensors = availableSensors;
	}

	public CrowdData getLastData() {
		return lastData;
	}

	public void setLastData(CrowdData lastData) {
		this.lastData = lastData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrowdUser other = (CrowdUser) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

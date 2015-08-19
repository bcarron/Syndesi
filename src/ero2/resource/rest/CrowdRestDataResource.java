package ero2.resource.rest;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import ero2.identification.CrowdController;
import ero2.identification.CrowdData;
import ero2.identification.CrowdUser;

/**
 * Rest resource to view / send data
 * 
 * @author Blaise
 *
 */
public class CrowdRestDataResource extends ServerResource {
	private CrowdController crowdController;

	public CrowdRestDataResource(){
		this.crowdController = CrowdController.getInstance();
	}

	@SuppressWarnings("unchecked")
	@Get("json")
	public String getData() {
		if(((String)getRequest().getAttributes().get("type")) != null && ((String)getRequest().getAttributes().get("type")).equals("mobile")){
			return crowdController.getDataJSON().toJSONString();
		}else if(((String)getRequest().getAttributes().get("type")) != null && ((String)getRequest().getAttributes().get("type")).equals("fixed")){
			return CrowdNodesManager.getInstance("http://129.194.70.52:8111/ero2proxy").getNodesJSON().toJSONString();
		}else{
			JSONObject dataJSON = new JSONObject();
			JSONArray dataArray = new JSONArray();
			dataArray.add(crowdController.getDataJSON());
			dataArray.add(CrowdNodesManager.getInstance("http://129.194.70.52:8111/ero2proxy").getNodesJSON());
			dataJSON.put("data", dataArray);
			return dataJSON.toJSONString();
		}
	}
	
	@Post()
	public String addData(String request) throws IOException, ParseException {
		JSONObject dataJSON = (JSONObject) JSONValue.parse(request);
		CrowdData newData = new CrowdData((String) dataJSON.get("mAccountId"), ((Number) dataJSON.get("mData")).floatValue(), (String)dataJSON.get("mDataType"));
		crowdController.setLastData(newData);;
		return dataJSON.toJSONString();
	}
	
}

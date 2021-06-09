package resources;

import java.util.HashMap;

import pojo.CreateUser;

public class TestDataCreation {
	
	public CreateUser createUser(String name,String job) {
		CreateUser cu=new CreateUser();
		cu.setName(name);
		cu.setJob(job);
		return cu;
	}

	public HashMap<String,String> sendEmail(String key, String value) {
		HashMap<String, String> map=new HashMap();
		map.put(key, value);
		return map;
	}

}

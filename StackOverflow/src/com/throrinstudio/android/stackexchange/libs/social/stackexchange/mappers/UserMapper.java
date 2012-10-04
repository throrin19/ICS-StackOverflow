package com.throrinstudio.android.stackexchange.libs.social.stackexchange.mappers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;

import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.User;

public class UserMapper extends AbstractMapper<User>{

	public UserMapper(ObjectMapper mapper) {
		super(mapper);
	}

	@Override
	public User map(JsonParser jp) throws JsonProcessingException, IOException {
		User user 		= new User();
		JsonNode elem 	= mObjectMapper.readTree(jp);
		
		user = mObjectMapper.readValue(elem, User.class);
		
		return user;
	}

	@Override
	public List<User> mapList(JsonParser jp) throws JsonProcessingException,
			IOException {
		List<User> users = new ArrayList<User>();
		
		while(jp.nextToken() != JsonToken.END_OBJECT){
			if(jp.getCurrentName() != null){	
				if(jp.getCurrentName().equals("items")){
					while(jp.nextToken() != JsonToken.END_ARRAY){
						jp.nextToken();
						users.add(map(jp));
					}
				}
			}
		}
//		JsonNode node = mObjectMapper.readTree(jp);
//		System.out.println(node.toString());
		
		return users;
	}

}

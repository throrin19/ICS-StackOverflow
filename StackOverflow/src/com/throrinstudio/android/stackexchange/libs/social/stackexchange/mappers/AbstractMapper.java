package com.throrinstudio.android.stackexchange.libs.social.stackexchange.mappers;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.AbstractEntity;

public abstract class AbstractMapper<A extends AbstractEntity >{
	
	protected ObjectMapper mObjectMapper;
	
	public AbstractMapper(ObjectMapper mapper){
		mObjectMapper = mapper;
	}
	
	public abstract A map(JsonParser jp) throws JsonProcessingException, IOException;
	
	public abstract List<A> mapList(JsonParser jp) throws JsonProcessingException, IOException;
}

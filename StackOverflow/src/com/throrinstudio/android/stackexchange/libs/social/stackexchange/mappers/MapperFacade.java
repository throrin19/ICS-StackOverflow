package com.throrinstudio.android.stackexchange.libs.social.stackexchange.mappers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.AbstractEntity;

public class MapperFacade<A extends AbstractEntity> {

	private JsonFactory		mJsonFactory	= null;
	private JsonParser		mJsonParser		= null;
	private ObjectMapper	mObjectMapper	= null;
	
	private void init()
	{
		mObjectMapper = new ObjectMapper();
		mJsonFactory = new JsonFactory();
		
		mObjectMapper
				.configure(
						DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
	}
	
	private void createParser(InputStream stream) throws JsonParseException, IOException{
		mJsonParser = mJsonFactory.createJsonParser(stream);
		mJsonParser.enable(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
		mJsonParser.enable(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER);
		mJsonParser.nextToken();
	}
	
	public static enum MapperType{
		site
	};
	
	
	public A map(InputStream stream, MapperType type)
	{
		init();
		
		A entity 					= null;
		AbstractMapper<A> 	mapper	= null;
		
		return entity;
	}
	


	@SuppressWarnings("unchecked")
	public List<A> mapList(InputStream stream, MapperType type)
	{
		init();
		
		List<A> 			entities 	= null;
		AbstractMapper 		mapper		= null;
		
		try {
			createParser(stream);
			
			if(type == MapperType.site){
				mapper = new SiteMapper(mObjectMapper);
			}
			
			if(mapper != null){
				entities = mapper.mapList(mJsonParser);
			}
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return entities;
	}
}

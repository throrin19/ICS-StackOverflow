package com.throrinstudio.android.stackexchange.libs.social.stackexchange.mappers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;

import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.Site;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.Site.SiteState;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.Site.SiteType;

public class SiteMapper extends AbstractMapper{

	public SiteMapper(ObjectMapper mapper) {
		super(mapper);
	}


	@Override
	public Site map(JsonParser jp) throws JsonProcessingException, IOException 
	{
		Site site = new Site();
		
		while(jp.nextToken() != JsonToken.END_OBJECT){
			JsonNode elem = mObjectMapper.readTree(jp);
			
			
			if(elem.has("site_type")){
				site.setSiteType(SiteType.valueOf(elem.getTextValue()));
			}else 
			if(elem.has("name")){
				site.setName(elem.getTextValue());
			}else 
			if(elem.has("logo_url")){
				site.setLogoUrl(elem.getTextValue());
			}else
			if(elem.has("api_site_parameter")){
				site.setApiSiteParameter(elem.getTextValue());
			}else
			if(elem.has("site_url")){
				site.setSiteUrl(elem.getTextValue());
			}else 
			if(elem.has("audience")){
				site.setAudience(elem.getTextValue());
			}else 
			if(elem.has("aliases")){
				Iterator<JsonNode> aliases = elem.getElements();
				
				List<String> aliasesList = new ArrayList<String>();
				
				while(aliases.hasNext()){
					aliasesList.add(aliases.next().getTextValue());
				}
				site.setAliases(aliasesList);
			}else
			if(elem.has("site_state")){
				site.setSiteState(SiteState.valueOf(elem.getTextValue()));
			}else
			if(elem.has("styling")){
				JsonNode stylingNode = elem.get("styling");
				Site.Styling styling = new Site.Styling();
				
				if(stylingNode.has("link_color")){
					styling.setLinkColor(stylingNode.getTextValue());
				}else
				if(stylingNode.has("tag_foreground_color")){
					styling.setTagForegroundColor(stylingNode.getTextValue());
				}else
				if(stylingNode.has("tag_background_color")){
					styling.setTagBackgroundColor(stylingNode.getTextValue());
				}
				site.setStyling(styling);
			}else 
			if(elem.has("launch_date")){
				site.setLaunchDate(new Date(elem.getLongValue()*1000));
			}else 
			if(elem.has("favicon_url")){
				site.setFaviconUrl(elem.getTextValue());
			}else
			if(elem.has("related_sites")){
				
				Iterator<JsonNode> relateds = elem.getElements();
				
				List<Site.RelatedSite> relatedArray = new ArrayList<Site.RelatedSite>();
				
				while(relateds.hasNext()){
					JsonNode relatedNode = relateds.next();
					
					Site.RelatedSite relatedSite = new Site.RelatedSite();
					
					if(relatedNode.has("name")){
						relatedSite.setName(relatedNode.getTextValue());
					}else
					if(relatedNode.has("site_url")){
						relatedSite.setSiteUrl(relatedNode.getTextValue());
					}else
					if(relatedNode.has("relation")){
						relatedSite.setRelation(relatedNode.getTextValue());
					}
					
					relatedArray.add(relatedSite);
				}
				
				site.setRelatedSites(relatedArray);
				
			}else
			if(elem.has("markdown_extensions")){
				Iterator<JsonNode> markdown = elem.getElements();
				
				List<String> markdownList = new ArrayList<String>();
				
				while(markdown.hasNext()){
					markdownList.add(markdown.next().getTextValue());
				}
				site.setMarkdownExtensions(markdownList);
			}else
			if(elem.has("high_resolution_icon_url")){
				site.setHighResolutionIconUrl(elem.getTextValue());
			}else
			if(elem.has("open_beta_date")){
				site.setOpenBetaDate(new Date(elem.getLongValue()*1000));
			}else
			if(elem.has("closed_beta_date")){
				site.setClosedBetaDate(new Date(elem.getLongValue()*1000));
			}else
			if(elem.has("twitter_account")){
				site.setTwitterAccount(elem.getTextValue());
			}
		}
		
		
		return site;
	}

	@Override
	public List<Site> mapList(JsonParser jp) throws JsonProcessingException, IOException 
	{
		List<Site> sites = new ArrayList<Site>();
		
		while(jp.nextToken() != JsonToken.END_OBJECT){
			if(jp.getCurrentName().equals("items")){
				jp.nextToken();
				while(jp.nextToken() != JsonToken.END_ARRAY){
					jp.nextToken();
					sites.add(map(jp));
				}
			}
		}
		
		return sites;
	}

}

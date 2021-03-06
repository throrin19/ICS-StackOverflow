package com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities;

import java.util.Date;
import java.util.List;

public class Site extends AbstractEntity {

	public static enum SiteState{
		normal, closed_beta, open_beta, linked_meta
	};
	
	public static enum SiteType{
		main_site, meta_site
	};
	
	private List<String>		aliases;
	private String 				apiSiteParameter;
	private String 				audience;
	private Date 				closedBetaDate;
	private String 				faviconUrl;
	private String 				highResolutionIconUrl;
	private String 				iconUrl;
	private Date 				launchDate;
	private String 				logoUrl;
	private List<String>		markdownExtensions;
	private String 				name;
	private Date 				openBetaDate;
	private List<RelatedSite> 	relatedSites;
	private String 				siteUrl;
	private String 				twitterAccount;
	
	private SiteType 			siteType;
	private SiteState 			siteState;
	
	private Styling				styling;
	
	
	/**
	 * @return the aliases
	 */
	public List<String> getAliases() {
		return aliases;
	}

	/**
	 * @param aliases the aliases to set
	 */
	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	/**
	 * @return the apiSiteParameter
	 */
	public String getApiSiteParameter() {
		return apiSiteParameter;
	}

	/**
	 * @param apiSiteParameter the apiSiteParameter to set
	 */
	public void setApiSiteParameter(String apiSiteParameter) {
		this.apiSiteParameter = apiSiteParameter;
	}

	/**
	 * @return the audience
	 */
	public String getAudience() {
		return audience;
	}

	/**
	 * @param audience the audience to set
	 */
	public void setAudience(String audience) {
		this.audience = audience;
	}

	/**
	 * @return the closedBetaDate
	 */
	public Date getClosedBetaDate() {
		return closedBetaDate;
	}

	/**
	 * @param closedBetaDate the closedBetaDate to set
	 */
	public void setClosedBetaDate(Date closedBetaDate) {
		this.closedBetaDate = closedBetaDate;
	}

	/**
	 * @return the faviconUrl
	 */
	public String getFaviconUrl() {
		return faviconUrl;
	}

	/**
	 * @param faviconUrl the faviconUrl to set
	 */
	public void setFaviconUrl(String faviconUrl) {
		this.faviconUrl = faviconUrl;
	}

	/**
	 * @return the highResolutionIconUrl
	 */
	public String getHighResolutionIconUrl() {
		return highResolutionIconUrl;
	}

	/**
	 * @param highResolutionIconUrl the highResolutionIconUrl to set
	 */
	public void setHighResolutionIconUrl(String highResolutionIconUrl) {
		this.highResolutionIconUrl = highResolutionIconUrl;
	}

	/**
	 * @return the iconUrl
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * @param iconUrl the iconUrl to set
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	/**
	 * @return the launchDate
	 */
	public Date getLaunchDate() {
		return launchDate;
	}

	/**
	 * @param launchDate the launchDate to set
	 */
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}

	/**
	 * @param logoUrl the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	/**
	 * @return the markdownExtensions
	 */
	public List<String> getMarkdownExtensions() {
		return markdownExtensions;
	}

	/**
	 * @param markdownExtensions the markdownExtensions to set
	 */
	public void setMarkdownExtensions(List<String> markdownExtensions) {
		this.markdownExtensions = markdownExtensions;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the openBetaDate
	 */
	public Date getOpenBetaDate() {
		return openBetaDate;
	}

	/**
	 * @param openBetaDate the openBetaDate to set
	 */
	public void setOpenBetaDate(Date openBetaDate) {
		this.openBetaDate = openBetaDate;
	}

	/**
	 * @return the relatedSites
	 */
	public List<RelatedSite> getRelatedSites() {
		return relatedSites;
	}

	/**
	 * @param relatedSites the relatedSites to set
	 */
	public void setRelatedSites(List<RelatedSite> relatedSites) {
		this.relatedSites = relatedSites;
	}

	/**
	 * @return the siteUrl
	 */
	public String getSiteUrl() {
		return siteUrl;
	}

	/**
	 * @param siteUrl the siteUrl to set
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	/**
	 * @return the twitterAccount
	 */
	public String getTwitterAccount() {
		return twitterAccount;
	}

	/**
	 * @param twitterAccount the twitterAccount to set
	 */
	public void setTwitterAccount(String twitterAccount) {
		this.twitterAccount = twitterAccount;
	}

	/**
	 * @return the siteType
	 */
	public SiteType getSiteType() {
		return siteType;
	}

	/**
	 * @param siteType the siteType to set
	 */
	public void setSiteType(SiteType siteType) {
		this.siteType = siteType;
	}

	/**
	 * @return the siteState
	 */
	public SiteState getSiteState() {
		return siteState;
	}

	/**
	 * @param siteState the siteState to set
	 */
	public void setSiteState(SiteState siteState) {
		this.siteState = siteState;
	}

	/**
	 * @return the styling
	 */
	public Styling getStyling() {
		return styling;
	}

	/**
	 * @param styling the styling to set
	 */
	public void setStyling(Styling styling) {
		this.styling = styling;
	}
	
	
	public static class Styling extends AbstractEntity {

		private String linkColor;
		private String tagBackgroundColor;
		private String tagForegroundColor;
		
		
		/**
		 * @return the linkColor
		 */
		public String getLinkColor() {
			return linkColor;
		}
		/**
		 * @param linkColor the linkColor to set
		 */
		public void setLinkColor(String linkColor) {
			this.linkColor = linkColor;
		}
		/**
		 * @return the tagBackgroundColor
		 */
		public String getTagBackgroundColor() {
			return tagBackgroundColor;
		}
		/**
		 * @param tagBackgroundColor the tagBackgroundColor to set
		 */
		public void setTagBackgroundColor(String tagBackgroundColor) {
			this.tagBackgroundColor = tagBackgroundColor;
		}
		/**
		 * @return the tagForegroundColor
		 */
		public String getTagForegroundColor() {
			return tagForegroundColor;
		}
		/**
		 * @param tagForegroundColor the tagForegroundColor to set
		 */
		public void setTagForegroundColor(String tagForegroundColor) {
			this.tagForegroundColor = tagForegroundColor;
		}
	}
	
	public static class RelatedSite {

		private String name;
		private String siteUrl;
		private String relation;
		
		
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the siteUrl
		 */
		public String getSiteUrl() {
			return siteUrl;
		}
		/**
		 * @param siteUrl the siteUrl to set
		 */
		public void setSiteUrl(String siteUrl) {
			this.siteUrl = siteUrl;
		}
		/**
		 * @return the relation
		 */
		public String getRelation() {
			return relation;
		}
		/**
		 * @param relation the relation to set
		 */
		public void setRelation(String relation) {
			this.relation = relation;
		}
		
		
	}
}

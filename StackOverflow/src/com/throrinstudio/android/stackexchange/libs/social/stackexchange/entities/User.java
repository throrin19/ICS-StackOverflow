package com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities;

import java.util.Date;

public class User {

	public static enum UserType{
		unregistered, registered, moderator, does_not_exist
	};
	
	private int accountId;
	private int userId;
	
	private int badgeBronze;
	private int badgeGold;
	private int badgeSilver;
	
	private Date creationDate;
	private Date lastAccessDate;
	
	private int questionCount;
	private int answerCount;
	private int reputation;
	
	private String siteName;
	private String siteUrl;
	
	private UserType userType;

	
	
	
	
	
	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the badgeBronze
	 */
	public int getBadgeBronze() {
		return badgeBronze;
	}

	/**
	 * @param badgeBronze the badgeBronze to set
	 */
	public void setBadgeBronze(int badgeBronze) {
		this.badgeBronze = badgeBronze;
	}

	/**
	 * @return the badgeGold
	 */
	public int getBadgeGold() {
		return badgeGold;
	}

	/**
	 * @param badgeGold the badgeGold to set
	 */
	public void setBadgeGold(int badgeGold) {
		this.badgeGold = badgeGold;
	}

	/**
	 * @return the badgeSilver
	 */
	public int getBadgeSilver() {
		return badgeSilver;
	}

	/**
	 * @param badgeSilver the badgeSilver to set
	 */
	public void setBadgeSilver(int badgeSilver) {
		this.badgeSilver = badgeSilver;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the lastAccessDate
	 */
	public Date getLastAccessDate() {
		return lastAccessDate;
	}

	/**
	 * @param lastAccessDate the lastAccessDate to set
	 */
	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	/**
	 * @return the questionCount
	 */
	public int getQuestionCount() {
		return questionCount;
	}

	/**
	 * @param questionCount the questionCount to set
	 */
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	/**
	 * @return the answerCount
	 */
	public int getAnswerCount() {
		return answerCount;
	}

	/**
	 * @param answerCount the answerCount to set
	 */
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

	/**
	 * @return the reputation
	 */
	public int getReputation() {
		return reputation;
	}

	/**
	 * @param reputation the reputation to set
	 */
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	/**
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * @param siteName the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
}

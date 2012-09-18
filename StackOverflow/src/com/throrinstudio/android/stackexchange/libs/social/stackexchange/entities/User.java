package com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities;

import java.util.Date;

public class User extends AbstractEntity{

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
	private Date lastModifiedDate;
	
	private int questionCount;
	private int answerCount;
	
	private int reputation;
	private int reputationChangeDay;
	private int reputationChangeWeek;
	private int reputationChangeMonth;
	private int reputationChangeQuarter;
	private int reputationChangeYear;
	
	private String siteUrl;
	private String profileUrl;
	
	private UserType userType;

	private String location;
	private int age;
	private String profileImage;
	private boolean isEmployee;
	private String name;
	
	
	
	
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
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
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
	 * @return the reputationChangeDay
	 */
	public int getReputationChangeDay() {
		return reputationChangeDay;
	}
	/**
	 * @param reputationChangeDay the reputationChangeDay to set
	 */
	public void setReputationChangeDay(int reputationChangeDay) {
		this.reputationChangeDay = reputationChangeDay;
	}
	/**
	 * @return the reputationChangeWeek
	 */
	public int getReputationChangeWeek() {
		return reputationChangeWeek;
	}
	/**
	 * @param reputationChangeWeek the reputationChangeWeek to set
	 */
	public void setReputationChangeWeek(int reputationChangeWeek) {
		this.reputationChangeWeek = reputationChangeWeek;
	}
	/**
	 * @return the reputationChangeMonth
	 */
	public int getReputationChangeMonth() {
		return reputationChangeMonth;
	}
	/**
	 * @param reputationChangeMonth the reputationChangeMonth to set
	 */
	public void setReputationChangeMonth(int reputationChangeMonth) {
		this.reputationChangeMonth = reputationChangeMonth;
	}
	/**
	 * @return the reputationChangeQuarter
	 */
	public int getReputationChangeQuarter() {
		return reputationChangeQuarter;
	}
	/**
	 * @param reputationChangeQuarter the reputationChangeQuarter to set
	 */
	public void setReputationChangeQuarter(int reputationChangeQuarter) {
		this.reputationChangeQuarter = reputationChangeQuarter;
	}
	/**
	 * @return the reputationChangeYear
	 */
	public int getReputationChangeYear() {
		return reputationChangeYear;
	}
	/**
	 * @param reputationChangeYear the reputationChangeYear to set
	 */
	public void setReputationChangeYear(int reputationChangeYear) {
		this.reputationChangeYear = reputationChangeYear;
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
	 * @return the profileUrl
	 */
	public String getProfileUrl() {
		return profileUrl;
	}
	/**
	 * @param profileUrl the profileUrl to set
	 */
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
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
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the profileImage
	 */
	public String getProfileImage() {
		return profileImage;
	}
	/**
	 * @param profileImage the profileImage to set
	 */
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	/**
	 * @return the isEmployee
	 */
	public boolean isEmployee() {
		return isEmployee;
	}
	/**
	 * @param isEmployee the isEmployee to set
	 */
	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
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
	
}

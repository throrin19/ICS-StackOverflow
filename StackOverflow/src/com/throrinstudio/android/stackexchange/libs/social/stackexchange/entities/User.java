package com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities;

import java.util.Date;

public class User extends AbstractEntity{

	public static enum UserType{
		unregistered, registered, moderator, does_not_exist
	};
	
	public static class BadgeCount{
		private int bronze;
		private int gold;
		private int silver;
		
		public int getBronze() {
			return bronze;
		}
		public void setBronze(int bronze) {
			this.bronze = bronze;
		}
		public int getGold() {
			return gold;
		}
		public void setGold(int gold) {
			this.gold = gold;
		}
		public int getSilver() {
			return silver;
		}
		public void setSilver(int silver) {
			this.silver = silver;
		}
	}
	
	private String about_me;
	private int accept_rate;
	private int account_id;
	private int age;
	private int answer_count;
	private BadgeCount badge_count;
	private Date creation_date;
	private String display_name;
	private int down_vote_count;
	private boolean is_employee;
	private Date last_access_date;
	private Date last_modified_date;
	private String link;
	private String location;
	private String profile_image;
	private int question_count;
	private int reputation;
	private int reputation_change_day;
	private int reputation_change_month;
	private int reputation_change_quarter;
	private int reputation_change_week;
	private int reputation_change_year;
	private Date timed_penalty_date;
	private int up_vote_count;
	private int user_id;
	private UserType user_type;
	private int view_count;
	private String website_url;
	
	
	public String getAbout_me() {
		return about_me;
	}
	public void setAbout_me(String about_me) {
		this.about_me = about_me;
	}
	public int getAccept_rate() {
		return accept_rate;
	}
	public void setAccept_rate(int accept_rate) {
		this.accept_rate = accept_rate;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAnswer_count() {
		return answer_count;
	}
	public void setAnswer_count(int answer_count) {
		this.answer_count = answer_count;
	}
	public BadgeCount getBadge_count() {
		return badge_count;
	}
	public void setBadge_count(BadgeCount badge_count) {
		this.badge_count = badge_count;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public int getDown_vote_count() {
		return down_vote_count;
	}
	public void setDown_vote_count(int down_vote_count) {
		this.down_vote_count = down_vote_count;
	}
	public boolean isIs_employee() {
		return is_employee;
	}
	public void setIs_employee(boolean is_employee) {
		this.is_employee = is_employee;
	}
	public Date getLast_access_date() {
		return last_access_date;
	}
	public void setLast_access_date(Date last_access_date) {
		this.last_access_date = last_access_date;
	}
	public Date getLast_modified_date() {
		return last_modified_date;
	}
	public void setLast_modified_date(Date last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public int getQuestion_count() {
		return question_count;
	}
	public void setQuestion_count(int question_count) {
		this.question_count = question_count;
	}
	public int getReputation() {
		return reputation;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	public int getReputation_change_day() {
		return reputation_change_day;
	}
	public void setReputation_change_day(int reputation_change_day) {
		this.reputation_change_day = reputation_change_day;
	}
	public int getReputation_change_month() {
		return reputation_change_month;
	}
	public void setReputation_change_month(int reputation_change_month) {
		this.reputation_change_month = reputation_change_month;
	}
	public int getReputation_change_quarter() {
		return reputation_change_quarter;
	}
	public void setReputation_change_quarter(int reputation_change_quarter) {
		this.reputation_change_quarter = reputation_change_quarter;
	}
	public int getReputation_change_week() {
		return reputation_change_week;
	}
	public void setReputation_change_week(int reputation_change_week) {
		this.reputation_change_week = reputation_change_week;
	}
	public int getReputation_change_year() {
		return reputation_change_year;
	}
	public void setReputation_change_year(int reputation_change_year) {
		this.reputation_change_year = reputation_change_year;
	}
	public Date getTimed_penalty_date() {
		return timed_penalty_date;
	}
	public void setTimed_penalty_date(Date timed_penalty_date) {
		this.timed_penalty_date = timed_penalty_date;
	}
	public int getUp_vote_count() {
		return up_vote_count;
	}
	public void setUp_vote_count(int up_vote_count) {
		this.up_vote_count = up_vote_count;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public UserType getUser_type() {
		return user_type;
	}
	public void setUser_type(UserType user_type) {
		this.user_type = user_type;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public String getWebsite_url() {
		return website_url;
	}
	public void setWebsite_url(String website_url) {
		this.website_url = website_url;
	}
	
	
}

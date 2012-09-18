package com.throrinstudio.java.stackexchange.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class StackExchangeDBGenerator {

	public static void main(String[] args) throws Exception
    {
		Schema schema = new Schema(1, "com.throrinstudio.android.stackexchange.models");

        schema.enableKeepSectionsByDefault();
        schema.enableActiveEntitiesByDefault();
        
		accountTable(schema);
		
		new DaoGenerator().generateAll(schema, "../StackOverflow/src-gen");
    }
	
	private static void accountTable(Schema schema){
		Entity account = schema.addEntity("Account");
		account.setSuperclass("com.throrinstudio.android.stackexchange.entities.AbstractPojo");
		account.addIdProperty();
		account.addStringProperty("site");
		account.addStringProperty("logo");
		account.addStringProperty("avatar");
		account.addStringProperty("pseudo");
		account.addStringProperty("token");
		
	}
}
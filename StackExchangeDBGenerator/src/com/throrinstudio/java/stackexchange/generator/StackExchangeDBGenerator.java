package com.throrinstudio.java.stackexchange.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Schema;

public class StackExchangeDBGenerator {

	public static void main(String[] args) throws Exception
    {
		Schema schema = new Schema(1, "com.throrinstudio.android.stackexchange.models");

        schema.enableKeepSectionsByDefault();
        schema.enableActiveEntitiesByDefault();
        
		accountTable();
		
		new DaoGenerator().generateAll(schema, "../StackOverflow/src-gen");
    }
	
	private static void accountTable(){
		
	}
}
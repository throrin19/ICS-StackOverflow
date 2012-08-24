package com.throrinstudio.android.stackexchange.libs.social.stackexchange.mappers;

import java.io.InputStream;

public abstract class AbstractMapper<A> {

	
	public abstract A map(InputStream stream);
}

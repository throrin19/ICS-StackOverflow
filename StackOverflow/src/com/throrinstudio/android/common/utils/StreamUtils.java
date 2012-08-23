package com.throrinstudio.android.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtils {
    public static void CopyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
              int count=is.read(bytes, 0, buffer_size);
              if(count==-1)
                  break;
              os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }
    
    public static String getInflatedString(InputStream inputStream){
		
		byte[] buffer = new byte[512];
		int len;
		StringBuffer sb_result = new StringBuffer();
		
		try {
			while ((len = inputStream.read(buffer)) > 0) {
				sb_result.append(new String(buffer,0,len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb_result.toString();
	}
}
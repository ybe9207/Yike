package yk.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	    String str=sdf.format(new Date());
	     System.out.println(str);	
	}
	
}

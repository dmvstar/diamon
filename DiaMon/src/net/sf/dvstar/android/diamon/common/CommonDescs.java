package net.sf.dvstar.android.diamon.common;

import java.util.ArrayList;

public class CommonDescs {

	public static class InsulinDesc{
		public double  time;
		public int     dose;
		public boolean compare(){
			boolean ret = true;
			
			return ret;
		}
	}

	public static class InsulinDescList{
		public ArrayList<InsulinDesc> list;
		public InsulinDescList(){
			list = new ArrayList<InsulinDesc>();
		}
		
		public boolean addItem(InsulinDesc desc){
			boolean ret = false;
			if(!list.contains(desc)) {list.add(desc); ret = true;}
			return ret;
		} 
	}
	
	
}

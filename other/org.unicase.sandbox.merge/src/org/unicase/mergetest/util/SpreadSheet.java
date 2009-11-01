package org.unicase.mergetest.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpreadSheet {

	public Map<Row, List<Object>> rows;
	
	public SpreadSheet() {
		rows = new HashMap<Row, List<Object>>();
	}
	
	
	public class Row {
		
		public Row(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int index;
		public String name;
	}


	public List<Object> addRow(int index, String name) {
		ArrayList<Object> arrayList = new ArrayList<Object>();
		rows.put(new Row(index, name), arrayList);
		return arrayList;
	}
	
	public void display() {
		List<Row> rows = new ArrayList<Row>();
		rows.addAll(this.rows.keySet());
		
		Collections.sort(rows,new Comparator<Row>() {
			public int compare(Row o1, Row o2) {
				if(o1.index > o2.index) {
					return 1;
				} else if (o1.index < o2.index) {
					return -1;
				}
				return 0;
			}
		});
		
		
		for(Row row : rows) {
			System.out.print("\"["+row.index+"] "+row.name+"\";");
			for(Object obj : this.rows.get(row)) {
				System.out.print(obj.toString()+"; ");
			}
			System.out.println("");
		}
	}
}

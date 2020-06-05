package test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Location> list = new LinkedList<>();
//		list.add(new Location(1,6,4));
//		list.add(new Location(1,7,4));
//		list.add(new Location(1,1,4));
//		list.add(new Location(1,2,4));
//		list.add(new Location(1,5,4));
//		Collections.sort(list);
//		System.out.println(list);
//		StringBuilder str = new StringBuilder();
//		str.append("\"");
//		str.append(",");
//		str.append("\"");
//		System.out.print(str.toString());
	}

}
class Location implements Comparable<Location>{
    int x, y, val;
    Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Location that) {
        if (this.x != that.x)
            return Integer.compare(this.x, that.x);
        else if (this.y != that.y)
            return Integer.compare(this.y, that.y);
        else
            return Integer.compare(this.val, that.val);
    }
    public String toString() {
    	return "("+x+","+y+","+val+")";
    }
}

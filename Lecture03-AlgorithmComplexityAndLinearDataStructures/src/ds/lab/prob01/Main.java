package ds.lab.prob01;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// Add
		System.out.println("Add:");
		System.out.println(list);
		System.out.println("count: " + list.getCount());
		System.out.println();
		list.add(1);
		list.add(2);
		System.out.println(list);
		System.out.println("count: " + list.getCount());
		System.out.println();
		list.add(3);
		System.out.println(list);
		System.out.println("count: " + list.getCount());
		System.out.println();
		list.add(4);
		list.add(5);
		System.out.println(list);
		System.out.println("count: " + list.getCount());
		System.out.println();
		
		// Get
		System.out.println("Get:");
		System.out.println("1st element (index 0): " + list.get(0));
		System.out.println("2nd element (index 1): " + list.get(1));
		System.out.println("3rd element (index 2): " + list.get(2));
		System.out.println();
		
		// Set
		System.out.println("Set:");
		list.set(4, 2);
		System.out.println("index 2: " + list.get(2));
		System.out.println();
		
		System.out.println("RemoveAt:");
		list.removeAt(2);
		System.out.println(list);
		System.out.println("count: " + list.getCount());
		System.out.println();
		list.removeAt(2);
		System.out.println(list);
		System.out.println("count: " + list.getCount());
		System.out.println();
		list.removeAt(2);
		System.out.println(list);
		System.out.println("count: " + list.getCount());
		System.out.println();
	}

}

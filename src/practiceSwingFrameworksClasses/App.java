package practiceSwingFrameworksClasses;
import java.util.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		List arr = new ArrayList<>();
		arr.add("1");
		arr.add(2);
		arr.add(true);
		arr.add(0.7);
		ListIterator iterator1 = arr.listIterator();
//		
//		while (iterator1.hasNext()) {
//			System.out.println(iterator1.next());
//			
//		}
		
		System.out.println("listiterator 2nd time");
		while (iterator1.hasNext()) {
			System.out.println(iterator1.previousIndex());
			
		}	
		
		
		Iterator iterator = arr.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());	
			if(iterator.next().equals(2))
				iterator.remove();
		}
		
		System.out.println("2nd Time");
		iterator=arr.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());			
		}
		
		//for(Object ob :arr)System.out.println(ob);
		
	//	new MainFrame();
		

	}

}

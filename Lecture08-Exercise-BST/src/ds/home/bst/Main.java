package ds.home.bst;

import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

//        bst.insert(12);
//        bst.insert(21);
//        bst.insert(5);
//        bst.insert(1);
//        bst.insert(8);
//        bst.insert(18);
//        bst.insert(23);
//
//        Integer selected = bst.select(6);
//        System.out.println(selected);
		
//		bst.insert(1);
//        bst.insert(3);
//        bst.insert(4);
//        bst.insert(5);
//        bst.insert(8);
//        bst.insert(6);
//        bst.insert(9);
//        bst.insert(10);
//        bst.insert(37);
//        bst.insert(39);
//        bst.insert(45);
//        
//        bst.delete(5);
//        
//        bst.eachInOrder(new Consumer<Integer>() {
//			
//			@Override
//			public void accept(Integer t) {
//				System.out.print(t + " ");
//			}
//		});
		
		bst.insert(5);
		bst.insert(5);
		bst.insert(5);
		bst.insert(5);
		
		System.out.println(bst.getNodesCount());
		bst.eachInOrder(new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.print(t + " ");
			}
		});
	}
}
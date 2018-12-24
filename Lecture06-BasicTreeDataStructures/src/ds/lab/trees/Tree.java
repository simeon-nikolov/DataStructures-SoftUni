package ds.lab.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Tree<T> {
	private T value;
	private List<Tree<T>> children; 

    @SafeVarargs
	public Tree(T value, Tree<T>... children) {
    	this.value = value;
    	this.children = new LinkedList<Tree<T>>();
    	
    	for (Tree<T> child : children) {
			this.children.add(child);
		}
    }

    // append output to builder
    public String print(int indent, StringBuilder builder) {
        this.appendIndent(indent, builder);
        builder.append(this.value + "\n");
        
        for (Tree<T> node : children) {
			node.print(indent + 1, builder);
		}
        
        return builder.toString();
    }
    
    private void appendIndent(int indent, StringBuilder builder) {
    	for (int count = 0; count < indent * 2; count++) {
			builder.append(' ');
		}
    }

    public void each(Consumer<T> consumer) {
        throw new UnsupportedOperationException();
    }

    public Iterable<T> orderDFS() {
        throw new UnsupportedOperationException();
    }

    public Iterable<T> orderBFS() {
        throw new UnsupportedOperationException();
    }

}
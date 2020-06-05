package hfmtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class hfmTree {
	public static void main(String[] args) {
		int[] a = {13,7,8,3,29,6,1};
		Node root = createHfmTree(a);
		prev(root);
	}
	public static Node createHfmTree(int[] arr) {
		List<Node> nodes = new ArrayList<>();
		for(int value:arr) {
			nodes.add(new Node(value));
		}
		while(nodes.size()>1) {
			Collections.sort(nodes);
			//System.out.println(nodes)
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parent = new Node(leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	public static void prev(Node root) {
		if(root==null) {
			System.out.println("树为空，无法遍历");
		}else {
			root.prev();
		}
	}
}
class Node implements Comparable<Node>{
	public int weight;
	public Node left;
	public Node right;
	public Node(int weight) {
		this.weight=weight;
	}
	public String toString() {
		return "node:"+this.weight;
	}
	public int compareTo(Node o) {
		return this.weight-o.weight;
	}
	public void prev() {
		System.out.println(this.weight);
		if(this.left!=null) {
			this.left.prev();
		}
		if(this.right!=null) {
			this.right.prev();
		}
	}
}
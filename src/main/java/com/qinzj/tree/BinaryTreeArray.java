package com.qinzj.tree;

import java.util.Arrays;
import java.util.Scanner;

/**   
 * 通过数组实现二叉树
* @Description: TODO
* @author qinzj  
* @date 2019年12月13日 下午3:31:25 
*/
public class BinaryTreeArray {
	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		System.out.println("请输入节点数字，输入0结束。。。。。。。。。。");
		//控制台输入
		Scanner input = new Scanner(System.in);
		int node = 0;
		do{
			node = input.nextInt();
			bt.addNode(node);
		} while(node != 0);
		
		bt.printAllNode();
		input.close();
	}
	
}

/**   
 * 二叉树数组存储结构及操作
* @Description: TODO
* @author qinzj  
* @date 2019年12月13日 下午5:01:58 
*/
class BinaryTree {
	
	private static final int MAX_SIZE = 16;
	private int[] tree = new int[MAX_SIZE];
	
	//初始化树数组，将每个节点值都置为0
	{
		for(int i = 0; i < MAX_SIZE; i++) {
			tree[i] = 0;
		}
	}
	
	public void addNode(int node) {
		
		//核心代码
		//二叉树的性质可得如下代码
		//具体性质请查看当前目录下“二叉树的数组存储结构.png”
		int level = 0;
		while(tree[level] != 0) {
			if(node <= tree[level]) {
				level = (level+1) * 2 - 1;
			} else {
				level = (level+1) * 2;
			}
			
			//动态扩展数组，默认数组长度为16，通过动态扩展，可随意输入数值，不会出现数组越界的异常
			if(level > MAX_SIZE - 1) {
				tree = Arrays.copyOf(tree, tree.length*2);
			}
		}
		
		tree[level] = node;
	}
	
	/**   
	 * 打印数组结果
	* @Description: TODO
	* @author qinzj  
	* @date 2019年12月13日 下午4:36:36 
	*/
	public void printAllNode() {
		
		for(int i = 0; i < tree.length; i++) {
			System.out.print("  [" + (i+1) + "]" + tree[i]);
		}
		
	}
	
}

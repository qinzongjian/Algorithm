package com.qinzj.tree;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryTreeLinkedArray {
	
	public static void main(String[] args) {
		
		BinaryLinkedTree tree = new BinaryLinkedTree();
		Scanner scaner = new Scanner(System.in);
		
		while(true) {
			
			int input = scaner.nextInt();
			
			if(input == 0)
				break;
			
			tree.addNodeData(input);
		}
		
		tree.printAllNode();
		scaner.close();
	}
	
}

class BinaryLinkedTree {
	
	//记录当前数据层级
	private static int current_level = 0;
	//初始化数组大小
	private int MAX_SIZE = 16;
	
	protected int[] treeData = new int[MAX_SIZE];
	protected int[] lChild = new int[MAX_SIZE];
	protected int[] rChild = new int[MAX_SIZE];
	
	{
		//初始值
		for(int i = 0; i < MAX_SIZE; i++) {
			treeData[i] = 0;
			lChild[i] = -1;
			rChild[i] = -1;
		}
	}
	
	public void addNodeData(int data) {
		int i = 0;
		//根节点，只需要设置值，还没有左右子节点
		if(treeData[i] == 0) {
			treeData[i] = data;
			current_level++;
			return;
		}
		
		//核心代码
		//具体逻辑通过结合“二叉树链表数组存储结构.png”进行理解
		while(treeData[i] != 0) {
			if(data <= treeData[i]) {	//左子树
				if(lChild[i] == -1) {  //如果为-1，则说明该节点为空
					treeData[current_level] = data;
					lChild[i] = current_level;
					current_level++;
					break;
				} else {
					i = lChild[i];  //把当前节点的左子节点下标赋值给i，查找坐标为i的节点
				}
			} else {	//右字树
				if(rChild[i] == -1) {
					treeData[current_level] = data;
					rChild[i] = current_level;
					current_level++;
					break;
				} else {
					i = rChild[i];
				}
			}
			
			//如果层级超过了初始值，则进行扩容，扩容为原来的两倍
			if(current_level >= MAX_SIZE) {
				treeData = Arrays.copyOf(treeData, treeData.length*2);
				lChild = Arrays.copyOf(lChild, treeData.length*2);
				rChild = Arrays.copyOf(rChild, treeData.length*2);
			}
		}
		
	}
	
	/**   
	 * 打印值
	* @Description: TODO
	* @author qinzj  
	* @date 2019年12月14日 下午5:06:13 
	*/
	public void printAllNode() {
		for(int i = 0; i < treeData.length; i++) {
			System.out.print(lChild[i] + " " + treeData[i] + " " + rChild[i] + "\t\n");
		}
	}
}

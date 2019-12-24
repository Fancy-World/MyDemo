package random.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetRandomStudent {
	/**
	 * 根据从excel中获取的学生信息生成随机学生名单
	 */
	public String[] getRandomStudent(int personNum,List<String> list,int sumNum) {
		//使用set存放获得的personNum个随机数（使用Set是因为Set的“无重复”特性，从而保证不会获得相同的随机数）。
		//list为从HandlerExcel得到的存放着所有学生名单的List
		Set<Integer> set = new HashSet<Integer>();
		for(int i =0;i<personNum;i++) {
			//此循环用来获得随机数（放进set中，且set中没有重复的随机数）
			int tempNum =-1;
			while(set.contains( tempNum =getRandomNum(sumNum))) {
				//若集合中有这个数了，则进入循环，重新生成一个数
				continue;
			}
//			System.out.print(tempNum+" ");
			set.add(tempNum);
		}
		//set中放的是生成的随机数。
		System.out.println("生成的人数："+set.size());
		
		//通过随机数提取学生并存到一个数组中。
		String [] studentsArr = new String[personNum];
		int j = 0;
		//将学生姓名放入数组中.
		System.out.print("生成的随机名单为:");
		for(int i : set) {
			studentsArr[j] =list.get(i);
			System.out.print(studentsArr[j]+" ");
			j++;
		}
		//返回存放着随机学生的数组。
		return studentsArr;
	}
	
	//一个获得随机数的函数(根据输入的max值)范围：[0,max-1]
	private int getRandomNum(int max) {
		//Math.floor(a)     获得小于给定数的最大数（向下取整）
		int randomNum = (int)((Math.floor(Math.random()*max)));
		return randomNum;
	}
}

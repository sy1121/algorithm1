package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GroupAnagrams49 {
	
	//AC 15ms beats 100%
  public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<String,List<String>>();
        List<List<String>> result=new ArrayList<List<String>>();
        for(int i=0;i<strs.length;i++){
        	String curstr=strs[i];
        	curstr=sort(curstr);
        	List<String> curList;
            if(map.containsKey(curstr)){
            	curList=map.get(curstr);
                insert(curList,strs[i]);
            }else{
            	curList=new ArrayList<String>();
            	curList.add(strs[i]);
            	map.put(curstr, curList);
            	result.add(curList);
            }
        }
        return result;
        
    }
  
  public String sort(String str){
	   char[] temp=str.toCharArray();
	   //插入排序
	   for(int i=1;i<temp.length;i++){
		   char cur=temp[i];
		   int index=0;
		   for(int j=i-1;j>=0;j--){
			  if(cur<temp[j]){
				  temp[j+1]=temp[j];//比当前元素大 ，则后移一格
			  }else{
				  index=j+1;
				  break;
			  }
		   }
		   temp[index]=cur;
	   }
	   return String.valueOf(temp); //字符数组转字符串用String.valueOf
  }
  
  public void insert(List<String> list,String str){
	  int size=list.size(),index=0;
	  for(int i=0;i<size;i++){
		  if(str.compareTo(list.get(i))>0){
			  index++;
		  }else{
			  break;
		  }
	  }
	  list.add(index, str);
  }
  
  public static void main(String [] args){
	  GroupAnagrams49 g=new GroupAnagrams49();
	  String[] strs={"and","dan"};
	  List<List<String>> result=g.groupAnagrams(strs);
	  System.out.println("result size="+result.size());
	  for(int i=0;i<result.size();i++){
		  System.out.print("[ ");
		  for(int j=0;j<result.get(i).size();j++){
			  System.out.print("\""+result.get(i).get(j)+"\",");
		  }
		  System.out.println(" ]");
	  }
  }
}

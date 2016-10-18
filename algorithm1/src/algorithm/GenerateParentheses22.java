package algorithm;

import java.util.ArrayList;
import java.util.List;


public class GenerateParentheses22 {
	//5ms 
	 public List<String> generateParenthesis(int n) {
	        List<String> result=new ArrayList<String>();
	        traceback(0,result,new StringBuilder(),n,0,0);
	        return result;
	 }
	 //按照回溯的套路写
	 public void traceback(int level,List<String> result,StringBuilder temp,int n,int neg,int pos){
		  //先确定回溯的结束条件
		 if(level==2*n){
			 String str=temp.toString();
		     result.add(str);
		     return ;
		 }else{
			 //构建候选集
			 List<Character> list=new ArrayList<Character>();
			 if(pos<n) list.add('(');
			 if(pos>neg&&neg<n) list.add(')');
			 for(int i=0;i<list.size();i++){
			      if(list.get(i)=='(') {
			    	  temp.append("(");
			    	  pos++;
			      }else{
			    	   temp.append(")");
			    	   neg++;
			      }
			      //进入下一层
					 level++;
			      traceback(level,result,temp,n,neg,pos);
			      //回溯
			      temp.deleteCharAt(temp.length()-1);
			      level--;
			      if(list.get(i)=='(') pos--;
			      else neg--;
			 }
		 }
	 }
	 
	 
	 public static void main(String[] args){
		 GenerateParentheses22 g=new GenerateParentheses22();
		 List<String> list=g.generateParenthesis(4);
		 for(int i=0;i<list.size();i++){
			 System.out.println(list.get(i));
		 }
		  System.out.println("size="+list.size());
	 }
}

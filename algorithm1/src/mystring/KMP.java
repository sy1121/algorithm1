package mystring;

public class KMP {
     public void Next(char[] s,int[] next){
    	 int p=0;
    	 next[0]=0;  //next数组表示能匹配到前面第几个字符
    	 for(int i=1;i<s.length;i++){
    		 while(p>0&&s[i]!=s[p])  //遇到不匹配 递归的找前面可能匹配的字符位置
    			 p=next[p-1];
    		 if(s[i]==s[p]){
    			 p++;
    		 }
    		 next[i]=p;
    	 }
     }
     
     public int kmp(String s1,String s2){
    	 char[] T=s1.toCharArray(),P=s2.toCharArray();
    	 int[] next=new int[P.length];
    	 int k=0,result=-1;
    	 Next(P,next);
    	 for(int i=0;i<T.length;i++){
    		 while(k>0&&T[i]!=P[k])
    			 k=next[k-1];
    		 if(T[i]==P[k]){
    			 k++;
    		 }
    		 if(k==P.length) {
    			 result=i-k+1;
    			 break;
    		 }
    	 }
    	 return result;
     }
     
     public static void main(String[] args){
    	 KMP k=new KMP();
    	 int r=k.kmp("abab", "abcdabd");
    	 System.out.println("result="+r);
     }
}

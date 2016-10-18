package algorithm;

public class CompareVersionNumbers165 {
	
	// AC  3ms
	 public int compareVersion(String version1, String version2) {
	        String[] strs1=version1.split("\\.");
	        String[] strs2=version2.split("\\.");
	        int groupSize=strs1.length<strs2.length?strs1.length:strs2.length;
	        for(int i=0;i<groupSize;i++){
	        	//去除前面的0
	        	int index=0;
	        	while(index<strs1[i].length()&&strs1[i].charAt(index)=='0') index++;
		        strs1[i]=strs1[i].substring(index);
		        index=0;
		        while(index<strs2[i].length()&&strs2[i].charAt(index)=='0') index++;
		        strs2[i]=strs2[i].substring(index);
		        
		        if(strs1[i].length()>strs2[i].length())  return 1;
		        else if(strs1[i].length()<strs2[i].length()) return -1;
		        else{
	        		int length=strs1[i].length(),count=0;
	        		while(count<length){
	        			if(strs1[i].charAt(count)>strs2[i].charAt(count)){
	        				return 1;
	        			}else if(strs1[i].charAt(count)<strs2[i].charAt(count)){
	        				return -1;
	        			}
	        			count++;
	        		}
	          }
	        }
	        //处理剩余的组，如果都是0就返回0
	        if(groupSize<strs1.length){
	        	for(int i=groupSize;i<strs1.length;i++){
	        		for(int j=0;j<strs1[i].length();j++){
	        			if(strs1[i].charAt(j)=='0') continue;
	        			else
	        				return 1;
	        		}
	        	}
	        	return 0;
	        }
	        else if(groupSize<strs2.length) {
	        	for(int i=groupSize;i<strs2.length;i++){
	        		for(int j=0;j<strs2[i].length();j++){
	        			if(strs2[i].charAt(j)=='0') continue;
	        			else
	        				return -1;
	        		}
	        	}
	        	return 0;
	        }
	        else return 0;
	    }
	 
	 // 网上的比较简洁的方法  AC 1ms
	 /*public int compareVersion(String version1, String version2) {
		    int i=0,j=0;
		    while(i<version1.length()||j<version2.length())
		    {
		        int v1=0;
		        int v2=0;
		        while(i<version1.length()&&version1.charAt(i)!='.') v1=v1*10+version1.charAt(i++)-'0';
		        while(j<version2.length()&&version2.charAt(j)!='.') v2=v2*10+version2.charAt(j++)-'0';
		        if(v1<v2) return -1;
		        if(v1>v2) return 1;
		        i++;
		        j++;
		    }
		    return 0;
		}*/
	 public static void main(String[] args){
		 CompareVersionNumbers165 c=new CompareVersionNumbers165();
		 int r=c.compareVersion("1.0", "1");
		 System.out.println("r="+r);
	 }
}

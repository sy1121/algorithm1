package jianzhioffer;

public class T53 {
/*	 public boolean isMatch(String s, String p) {
	       if(s.length()==0||p.length()==0) return false;
	       return match(s,p);
	}
	private boolean match(String s,String p){
		if(s.isEmpty()&&p.isEmpty()) return true;
		if(!s.isEmpty()&&p.isEmpty()) return false;
		if(s.isEmpty()&&!p.isEmpty()) return matchEmpty(p);
		if(p.length()>1&&p.charAt(1)=='*'){
		    if(s.charAt(0)==p.charAt(0)||(p.charAt(0)=='.'&&!s.isEmpty())){
		    	return match(s.substring(1),p.substring(2))||
		    		   match(s.substring(1),p.substring(0))||
		    		   match(s.substring(0),p.substring(2));
		    }else return match(s.substring(0),p.substring(2));
		}
		if(s.charAt(0)==p.charAt(0)||(p.charAt(0)=='.'&&!s.isEmpty())){
			return match(s.substring(1),p.substring(1));
		}
		return false;
	}
	
    private boolean matchEmpty(String s){
    	if(s.isEmpty()) return true;
    	if(s.length()>=2){
    		if(s.charAt(1)=='*') return matchEmpty(s.substring(2));
    	}else return false;
    	return false;
    	
    }*/
	public boolean isMatch(String s, String p) {
		 boolean[][] dp=new boolean[s.length()+1][p.length()+1];
		 dp[0][0]=true;
		 for(int i=0;i<s.length()+1;i++){
			 for(int j=1;j<p.length()+1;j++){
				 if(p.charAt(j-1)!='*')
					 dp[i][j]=i>0&&dp[i-1][j-1]&&(p.charAt(j-1)=='.'||p.charAt(j-1)==s.charAt(i-1));
				 else
					 dp[i][j]=dp[i][j-2]||(i>0&&dp[i-1][j]&&(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.'));
			 }
		 }
		 return dp[s.length()][p.length()];
	}
	
	public static void main(String[] args){
		T53 t=new T53();
	    boolean r=t.isMatch("aa", "a");
	    System.out.println(r);
	}
}

package algorithm;

public class ReverseWordsinaString151 {
	public String reverseWords(String s) {
		s=s.trim();
		if("".equals(s)) return "";
        String[] strs=s.split(" ");
        StringBuffer sb=new StringBuffer();
        for(int i=strs.length-1;i>0;i--){
        	if(!strs[i].isEmpty())
        	sb.append(strs[i]+" ");
        }
        sb.append(strs[0]);
        return sb.toString();
    }
	
	public  static void main(String[] args){
		ReverseWordsinaString151 r=new ReverseWordsinaString151();
		String s="   a   b ";
		String rs=r.reverseWords(s);
		System.out.println("rs="+rs);
	}
}

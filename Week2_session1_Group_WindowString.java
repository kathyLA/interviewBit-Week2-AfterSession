public class Solution {
    public String minWindow(String S, String T) {
        if(S==null||S.isEmpty()||T==null||T.isEmpty()){
            return "";
        }
        
        int i=0;
        int j=0;
        int[] Tmap=new int[256];
        int[] Smap=new int[256];
        for(int k=0; k< T.length(); k++){
            Tmap[T.charAt(k)]++;
        }
        int index = 0;
        int length =Integer.MAX_VALUE;
        String ans = "";
        while(j<S.length()){
            if(index <T.length()){
                if(Tmap[S.charAt(j)]>0){
                    Smap[S.charAt(j)]++;
                    if(Smap[S.charAt(j)] <= Tmap[S.charAt(j)]){
                        index++;
                    }
                }
                j++;
            }
            while(index == T.length()){
                if(j-i< length){
                    length =j-i;
                    ans =S.substring(i,j);
                }
                if(Tmap[S.charAt(i)]>0){
                    Smap[S.charAt(i)]--;
                    if(Smap[S.charAt(i)]<Tmap[S.charAt(i)]){
                        index --;
                    }
                }
                i++;
            }
        }
        return ans;
    }
}

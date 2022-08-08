
public class Hash {
    final static int sz = 1010;
    final static int base [] = {1231, 1567};
    final static int mod [] = {1000000000 + 7, 1000000000 + 9};
    static int hash[][] = new int[2][sz];
    static int power[][] = new int[2][sz];
   
    
    static void init(){
        power[0][0] = 1;
        power[1][0] = 1;

        for (int i = 0; i < 2; i++){
            for (int j = 1; j < sz; j++){
                power[i][j] = (power[i][j - 1] * base[i]) % mod[i];
            }
        }
    }
    
    public static String getHash(String password){
        
        init();
        
        int len = password.length();

        hash[0][0] = 0;
        hash[1][0] = 0;
        
        for (int i = 0; i < 2; i++){
            for (int j = 1; j <= len; j++){
                hash[i][j] = (hash[i][j - 1] * base[i] + (password.charAt(j-1) - '0' + 1)) % mod[i];
            }
        }
        
        Integer first = hash[0][len];
        Integer second = hash[1][len];
        
        String newPass = first.toString();
        newPass = newPass + ",";
        newPass = newPass + second.toString();
        
        
        
        return newPass;
        
    }

    
}

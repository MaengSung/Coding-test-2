class Solution {
    public String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();
        //2
        new_id = new_id.replaceAll("[^a-zA-Z0-9-_.]","");
        //3
        new_id = new_id.replaceAll("\\.{2,}",".");
        //4
        if(new_id.length() > 0 && new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);
        //5
        if(new_id.isEmpty()) new_id = "a";
        //6
        if(new_id.length() > 15) {
            new_id = new_id.substring(0,15);
            if(new_id.charAt(new_id.length()-1)=='.') new_id = new_id.substring(0,new_id.length()-1);
        }
        //7
        StringBuilder new_idBuilder = new StringBuilder(new_id);
        while(new_idBuilder.length() < 3){
            new_idBuilder.append(new_idBuilder.charAt(new_idBuilder.length() - 1));
        }
        new_id = new_idBuilder.toString();

        return new_id;
    }
}
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curHealth = health;
        int curTime = 0;

        for(int[] atk : attacks){
            int attackTime = atk[0];
            int power = atk[1];


            curHealth = heal(attackTime - curTime -1, curHealth, health, bandage);
            curHealth -= power;

            curTime = attackTime;

            if(curHealth <= 0){
                curHealth = -1;
                break;
            }
        }

        return curHealth;
    }

    private int heal(int time, int curHealth, int health, int[] bandage){
        int bonus = time/bandage[0];

        curHealth += time*bandage[1] + bonus * bandage[2];

        return Math.min(curHealth, health);
    }
}
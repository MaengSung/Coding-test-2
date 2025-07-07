import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<String,Info> parkingLot = new TreeMap<>();
        for(String record : records){
            String[] recordArr = record.split(" ");
            int time = changeTime(recordArr[0]);
            String carNum = recordArr[1];
            boolean parking = recordArr[2].equals("IN");

            if(parkingLot.containsKey(carNum)){
                Info info = parkingLot.get(carNum);
                if(parking) info.in(time);
                else info.out(time);
                parkingLot.put(carNum,info);
            }
            else parkingLot.put(carNum, new Info(0,true,time));
        }

        for(String carNum : parkingLot.keySet()){
            Info info = parkingLot.get(carNum);
            if(info.parking) info.out(1439);
        }

        int idx = 0;
        int[] res = new int[parkingLot.size()];
        for(Info info : parkingLot.values()){
            if(info.totalTime <= fees[0]){
                res[idx++] = fees[1];
            }
            else{
                res[idx++] = fees[1]
                        +(int) (Math.ceil(
                        (double) (info.totalTime - fees[0]) / fees[2]))
                        * fees[3];
            }
        }

        for(Entry<String,Info> entry : parkingLot.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue().totalTime);
        }
        return res;
    }

    private int changeTime(String time){
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }

    private class Info{
        int totalTime;
        boolean parking;
        int lastTime;

        Info(int totalTime, boolean parking, int lastTime){
            this.totalTime = totalTime;
            this.parking = parking;
            this.lastTime = lastTime;
        }

        void out(int outTime){
            totalTime += (outTime - lastTime);
            lastTime = 0;
            parking = false;
        }

        void in(int inTime){
            lastTime = inTime;
            parking = true;
        }
    }
}
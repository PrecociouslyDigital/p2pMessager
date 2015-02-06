package generators;

import java.util.Random;

public class LevelGenerator {
    private int maxRooms;
    private int minRooms;
    private int maxRoomX;
    private int maxRoomY;
    private int minRoomX;
    private int minRoomY;
    private float addProb;
    private int maxAddSize;
    private int minAddSize;
    private int x;
    private int y;
    private Random rand;
    public byte[][] map(){
        byte[][] toSender = new byte[x][y];
        int target = genRange(minRooms, maxRooms);
        for(int i = 0; i < target; i++){
            int x = genRange(minRoomX, maxRoomX);
            int y = genRange(minRoomY, maxRoomY);
            Point center = new Point();
        }
    };
    public int genRange(int min, int max){
        return rand.nextInt(max - min) + 1 + max;
    }
    class Limit{
        int xMin;
        int xMax;
        int yMin;
        int yMax;
        public Limit(int xMin, int xMax, int yMin, int yMax){
            this.xMin = xMin;
            this.yMin = yMin;
            this.xMax = xMax;
            this.yMax = yMax;
        }
        public Limit(Point center, int x, int y){
            this.xMin = center.x - x;
            this.yMin = center.y - y;
            this.xMax = center.x + x;
            this.yMax = center.y + y;
        }
        
        public boolean checkCorner(int[][] map){
            return (map[yMin][xMin] == 0 && map[yMin][xMax] == 0&&map[yMax][xMin] == 0 && map[yMax][xMax] == 0);
        }
    }
    class Point{
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int x;
        public int y;
    }
}

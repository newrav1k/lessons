package game.RPG;

public class Build {
    public static AbstractEnemy getEnemyOfRoom(Floor floor, Room room) {
        for (int i = 1; i <= Floor.floor; i++) {
            for (int j = 0; j < 5; j++) {
                return AbstractEnemy.takeEnemy();
            }
        }
        return null;
    }
    public static class Floor extends Room {
        private static final int floor = 3;
    }

    public static class Room {
        private static int room = 1;
        public static void setRoom(int room) {
            Room.room = room;
        }
    }
}

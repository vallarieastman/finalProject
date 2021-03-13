package Game;

public class Game {

    public static class World {
        private int width;
        private int height;

        public static class Snake2 {
            private int length;
            private int xLocation;
            private double speed;
            private int yLocation;
            private boolean direction;

            public void eat() {
            }

            public void move() {
            }

            public void setDirection() {
            }

            public void die() {
            }

            public void grow() {
            }

            public static class InputManager {
                private boolean input;
            }

            public static class Score {
                private int Score;

                public void scoreTracker() {
                }
            }
        }

        public static class Snake1 {

            private int length;
            private int xLocation;
            private int yLocation;
            private float speed;
            private boolean direction;

            public void eat() {
            }

            public void move() {
            }

            public void setDirection() {
            }

            public void die() {
            }

            public void grow() {
            }

            public static class InputManager {
                private boolean input;
            }

            public static class Score {
                private int Score;

                public void scoreTracker() {
                }
            }
        }

        public static class Grid {
            private boolean contains_food;
            private int xSize;
            private int ySize;
            private boolean containsCharacters;

            public static class Food {
                private int xLocation;
                private int yLocation;
                private int food;


                public void randomSpawnGenerator() {
                }

                public void getsEaten() {
                }
            }

        }

    }

    public static class MainMenu {
        private String startGame;
        private String setting;
        private String quitGame;
        private boolean input;

        public void startGame() {
        }

        public void quitGame() {
        }

        public void toSettings() {
        }

        public void input() {
        }

        public static class Settings {
            private String difficulty;
            private boolean returnToMenu;
            private boolean snakeSkin;

            public void returnToMenu() {
            }

            public void chooseSkin() {
            }

            public void changeDifficulty() {
            }
        }
    }
}

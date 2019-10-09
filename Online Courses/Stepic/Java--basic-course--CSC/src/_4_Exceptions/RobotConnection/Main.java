package _4_Exceptions.RobotConnection;

public class Main {
    public static void main(String[] args) {

    }

    public void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY){
        for (int i = 0; i < 3; i++){
            try(RobotConnection rConnection = robotConnectionManager.getConnection()){
                rConnection.moveRobotTo(toX, toY);
                i = 3;
            }
            catch(RobotConnectionException e){
                if(i == 2){
                    throw new RobotConnectionException(e.getMessage(), e);
                }
            }
            catch(Exception ex){
                throw ex;
            }
        }
    }

    public class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
        void close();
    }
}

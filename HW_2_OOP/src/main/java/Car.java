public class Car {
    private double speed;
    private boolean isEngineOn;
    private boolean isEngineOff;
    private boolean isMove;
    private boolean isStop;

    public Car() {
        isEngineOff = true;
        isStop = true;
    }

    public void EngineOn() {
        isEngineOff = false;
        isEngineOn = true;
    }

    public void CarMove() {
        isStop = false;
        isMove = true;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }
}

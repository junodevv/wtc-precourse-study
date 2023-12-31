package car;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    // 명령한 수만큼 move() 메서드를 실행시키는 기능
    public void moveAsOrdered(final int orderCount) {
        validatePermittedOrderCount(orderCount);
        this.position += orderCount;
    }

    // 이동시킬 거리는 1 이상 10 이하의 수만 가능하다.
    private void validatePermittedOrderCount(final int orderCount) {
        if (orderCount < 1 || orderCount > 10) {
            throw new IllegalArgumentException("이동 시킬 거리는 1 이상 10 이하의 수만 가능합니다.");
        }
    }

    public int getPosition() {
        return position;
    }
}

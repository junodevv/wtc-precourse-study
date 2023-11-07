package enumtest;

public class EnumTest {
    public static void main(String[] args) {

        String YesValue1Test = YesOrNo.YES.getValue1();
        String YesValue2Test = YesOrNo.YES.getValue2();
        boolean YesValue3Test = YesOrNo.YES.isValue3();
        // Object YesInstanceTest = new YesOrNo(); 오류
        Object YesInstanceTest = YesOrNo.YES;

        String NoValue1Test = YesOrNo.NO.getValue1();
        String NoValue2Test = YesOrNo.NO.getValue2();
        boolean NoValue3Test = YesOrNo.NO.isValue3();
        Object NoInstanceTest = YesOrNo.NO;

        System.out.println("YES-value1: " + YesValue1Test);
        System.out.println("YES-value2: " + YesValue2Test);
        System.out.println("YES-value3: " + YesValue3Test);
        System.out.println("YES-Instance: " + YesInstanceTest);

        System.out.println("NO-value1: " + NoValue1Test);
        System.out.println("NO-value2: " + NoValue2Test);
        System.out.println("NO-value3: " + NoValue3Test);
        System.out.println("NO-Instance: " + NoInstanceTest);
    }
}

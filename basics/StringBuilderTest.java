package basics;

public class StringBuilderTest {
    public static void main(String[] args){
        //StringBuilder elapse
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 100; i++){
            sb.append("TestTestTest");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (end - start) + "ms");

        //String +
        start = System.currentTimeMillis();
        String s = "";
        for(int i = 0; i < 100; i++){
            s += "TestTestTest";
        }
        end = System.currentTimeMillis();
        System.out.println("String: " + (end - start) + "ms");

        StringBuilder sbsub = new StringBuilder(sb.substring(1,3));
        System.out.println(sbsub.toString().equals("es"));
    }
}

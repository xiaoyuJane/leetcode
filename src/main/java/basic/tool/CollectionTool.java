package basic.tool;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

public class CollectionTool {

   @Test
    public void collectionSortTest(){
       ArrayList<Integer> integers = new ArrayList<>();
       integers.add(1);
       integers.add(3);
       integers.add(2);
       integers.add(5);
       System.out.println(integers); //[1, 3, 2, 5]

       Collections.reverse(integers); //在原list上操作，不生成新list
       System.out.println(integers); //[5, 2, 3, 1]

       Collections.swap(integers,1,3); //交换1和3的位置
       System.out.println(integers); //[5, 1, 3, 2]

       Collections.rotate(integers,3); //list整体向后位置+3
       System.out.println(integers); //[1, 3, 2, 5]

       Collections.shuffle(integers); //随机打散位置
       System.out.println(integers); //[5, 3, 1, 2]

   }

   //自定义排序
    @Test
    public void collectionCompTest(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("aca");
        list.add("aba");
        list.add("sba");
        list.add("nba");
        Collections.addAll(list, "dd","ee");
        //排序方法  按照第一个单词的降序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0) - o1.charAt(0);
            }
        });
        System.out.println(list); //[sba, nba, aca, aba]

    }

    @Test
    public void collectionFindTest(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(2);
        System.out.println(list); //[1, 3, 2, 5, 2]

        Integer max = Collections.max(list);
        System.out.println(max); //5

        Integer min = Collections.min(list);
        System.out.println(min); //1

        Collections.replaceAll(list,2,33);
        System.out.println(list); //[1, 3, 33, 5, 33]

        int frequency = Collections.frequency(list, 33);
        System.out.println(frequency); //2

        Collections.sort(list);
        System.out.println(list); //[1, 3, 5, 33, 33]
        int i = Collections.binarySearch(list, 5);
        System.out.println(i); //2

        int i1 = Collections.indexOfSubList(list, Arrays.asList(1, 3));
        System.out.println(i1); //0

        Collections.fill(list,2);
        System.out.println(list); //[2, 2, 2, 2, 2]

    }


    @Test
    public void collectionSynTest() throws InterruptedException {
       final List<String> list1 = new ArrayList<String>(); //线程不安全
       final  List<String> list2 = Collections.synchronizedList(new ArrayList<String>()); //线程安全

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        list1.add(Thread.currentThread().getName()+"_"+j);
                        list2.add(Thread.currentThread().getName()+"_"+j);
//                        System.out.println("list1==:"+list1);
                        System.out.println("list2==:"+list2);
                        System.out.println();

                    }
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("End");

   }

}

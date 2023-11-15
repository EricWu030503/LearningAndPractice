public class LongestString {
    public static String longest(List61B<String> list) { // can pass in any object that implements List61B
        int maxDex = 0;
        for (int i = 0; i < list.size(); i += 1) {
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if (thisString.length() > longestString.length()) {
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static void main(String[] args) {
        SLList<String> someList1 = new SLList<>();
        someList1.addLast("elk");
        someList1.addLast("are");
        someList1.addLast("watching");
        someList1.print(); // SLList object inherit this method from List61B interface
        System.out.println(longest(someList1));

        AList<String> someList2 = new AList<>();
        someList2.addLast("elk");
        someList2.addLast("are");
        someList2.addLast("watching");
        System.out.println(longest(someList2));
        // note that we can use both SLList and AList as a parameter in longest method

        List61B<String> someList3 = new SLList<String>();
        someList3.addLast("elk");
        someList3.addLast("are");
        someList3.addLast("watching");
        someList3.print(); // would use the override print method in SLList

    }

}

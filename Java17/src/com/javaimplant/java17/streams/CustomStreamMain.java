package com.javaimplant.java17.streams;

import com.javaimplant.java17.models.DataLogHolder;
import com.javaimplant.java17.streams.interfaces.FileInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class CustomStreamMain implements FileInterface {
    public static void main(String[] args) throws IOException {
        fileCreator();
        List<DataLogHolder> mainlid=retLogHolder();
        methA(mainlid);
        System.out.println("-----streamtoListandSet output-----");
        streamtoListandSet();
        minMaxCountSortStream();
    }

    private static void minMaxCountSortStream() {
        Integer[] arr= {1222,1,32,43,54,12,7,9,3,7799,98,65};
        Optional<Integer> max = Arrays.asList(arr).stream().max((a, b) -> a - b);
        System.out.println("Maximum value is:"+max.get());
        Comparator<Integer> comp=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        Comparator<Integer> comp1=(a,b)->a-b;
        Optional<Integer> min = Arrays.asList(arr).stream().min(comp);
        System.out.println("Minimum value is:"+min.get());
        Arrays.asList(arr).sort((a,b)->(a-b));
        System.out.println("Sorted Array in ascending order:"+Arrays.toString(arr));
        Arrays.asList(arr).sort((a,b)->(b-a));
        System.out.println("Sorted Array in descending order:"+Arrays.toString(arr));
        Map<Double,Integer> map= Arrays.asList(arr).stream().collect(Collectors.toMap((a->Math.pow(a, 2)), b->b));
        Iterator<Entry<Double, Integer>> itr = map.entrySet().iterator();
        while(itr.hasNext()) {
            Entry<Double, Integer> aab= itr.next();
            System.out.println("Key: "+aab.getKey()+"|| Value: "+aab.getValue());
        }
        long count = Arrays.asList(arr).stream().count();
        System.out.println("Count of elements in array is:"+count);
    }

    private static void fileCreator() throws IOException {
        System.out.println("File path is: " + filePath);
        FileOutputStream fos =new FileOutputStream(new File(filePath));
        String str="";
        for(int i=0;i<1000;i++){
            str+="Log("+i+")="+Math.log(i)+":";
        }
        fos.write(str.getBytes());
        fos.flush();
        fos.close();
        System.out.println("File written successfully");
    }

    private static void streamtoListandSet() throws IOException {
        List<DataLogHolder> lid=retLogHolder();
		lid.stream().filter(n->(n.getId()>500&&n.getId()<550)).forEach(System.out::println);
		retLogHolder().stream().map(DataLogHolder::getdValue).forEach(System.out::println);
		List<String> lida=retLogHolder().stream().map(DataLogHolder::getdValue).toList();
		lida.stream().forEach(System.out::println);

        Set set=lid.stream().map(n->n.getId()).collect(Collectors.toSet());
        for(var a:set) {
            System.out.println(a);
        }
    }

    private static void methA(List<DataLogHolder> lid) {
        lid.stream().forEach(n->{
            System.out.println(n.getId()+" "+n.getdValue());
        });
    }

    private static List<DataLogHolder> retLogHolder() throws IOException {
        List<DataLogHolder> lid=new ArrayList<DataLogHolder>();
        FileInputStream fis = new FileInputStream(new File(filePath));
        int a = 0;
        String fin = "";
        while ((a = fis.read()) != -1) {
            fin += (char) a;
        }
        StringTokenizer stk=new StringTokenizer(fin,":");
        int i=0;
        while(stk.hasMoreTokens()) {
            i++;
            String j=stk.nextToken();
            lid.add(new DataLogHolder(i, j));
        }
        return lid;
    }
}

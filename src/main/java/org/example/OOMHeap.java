package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * -XX:+PrintGCDetails
 * -Xloggc:/Users/pankaj/Desktop/javacodes/playground/gc.log [create gc.log.0 if gc.log exist on startup, same goes from gc.log.1]
 * -Xms512m
 * -Xmx2048m
 *
 *
 * -----------
 * jmap -dump:live,format=b,file=heapdump.hprof <pid> [takes current snapshot of heap using terminal]
 *
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=/Users/pankaj/Desktop/javacodes/playground/dump.hprof [gives error if file already exists on does not save dump]
 *
 *
 * analysis tool: GCeasy
 */
public class OOMHeap {

    public static Map<String,String> map =new HashMap<>();
    public static void main(String[] args) {
        int i=1;
        while (true){
            String value = "DSFGHJGRFGRF" +
                    "GBNGFGHFRGHFRHRDFESBHVNFESGHTREHGJFDJHGTREG" +
                    "HREGHJTRHJGTREGHMGREGFNBGFREGFNBHGRFBMNBH" +
                    "GREDFJHERFGHREWFDGHGFRGHFREWF" +
                    "GHREWGFHFREWFGNBHGFRDHFREWDBV NDFEWFSDGNVFEWQHGNBGFRDGNERSDFGDRFGDFGRFGDFGRFGDFGRDBFGRFDGGFRFDFGRNRDFFREGNTRNFRWGDFHGTERGDFREGDNREG"+ UUID.randomUUID();
            map.put(UUID.randomUUID().toString(), value);

            i+=1;
            if (i%10000==0){
                Map<String, String> temp = new HashMap<> (map);
                System.out.println(map.size());
            }
        }
    }
}

package org.example;

public class OOMMetaspace {

    /**
     *jps -l
     * Output might be something like:
     * 2345 my.java.Application
     *
     * Using jcmd
     * jcmd 12345 VM.native_memory summary
     *
     * Using jstat
     * jstat -gc 12345
     *
     *
     * The jstat -gc command provides various statistics about the Java heap and GC behavior. Here are some key columns you might see:
     *
     * S0C and S1C: Current size of survivor spaces (in KB).
     * S0U and S1U: Current usage of survivor spaces (in KB).
     * EC: Current size of the Eden space (in KB).
     * EU: Current usage of the Eden space (in KB).
     * OC: Current size of the Old space (in KB).
     * OU: Current usage of the Old space (in KB).
     * MC: Current size of the Metaspace (in KB).
     * MU: Current usage of the Metaspace (in KB).
     * CCSC: Current size of the Compressed Class Space (in KB).
     * CCSU: Current usage of the Compressed Class Space (in KB)
     *
     *
     * in case of OOM because of metaspace error is printed: OOM: Metaspace with stacktrace
     *
     * class loading logs: -Xlog:class+load=info:<filepath> [>=9]
     * class loading logs: -verbose:class [<9]
     * solution increase metaspace size
     * -XX:MetaspaceSize
     */
    public static void main(String[] args) {

    }
}

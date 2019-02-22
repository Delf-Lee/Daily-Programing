package hackerrank;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author delf
 */
public class SubStringDiff {
    public static void main(String[] args) {
        System.out.println(substringDiff(11, "gltezejtfdehkmndtauvicffiiafozhkqmzlieedldbmqjdfpeadgjxcirbkmkcfxorthhpujbnekzansboejjrqfxoohuozsxgohukxmpzbukzvkduurvajrodlpxojzsvhiqftrbgixbcxmaqpiyadbkzqnhmigunrzfzugzfkeszcpbdotulketftuekfqzkymqpeidhpyuhotynqqxknnsheitgrhobrajzkrekexvorlvlyhtmstjrldhjzahvmjnprgtgulhvftgoiyctjgtthleeunkgbemapsntmfdnuaydkrbyigbrbpsknfdftonfmbtahqrpgddbkokvdxfflzysneapnqvsqhilnabbjamkdhpktsxxsczpoontmliozurkrvagnidnmcayiradtbacltouzacvseayrdzkkkqgbfrrnfydbnnxuctfegtfpbmfzsqjnclcnttftcvvpbmkovahvpdnjqghcafzcxhrgumhoxkityjqypljzsbidfcoynlumdrhokvmstydlmymldvimrduvzzcmiyxapbrrrndhjnhncpjbdmiryjteyvcydxkthxcbgxshffyzevvfrcrpzaotcpbefqqppehgdlbfstaalgzbtdfervuvehyvvocrabkioojxjnnrshvyijymnnzioeakpbkgxdbtlobybgzvpvvhhkdcvplpvnlecqizvzhgiglsotobprnnntqdsiquxvdxojripdlmzsyorhjandaqtjfptgegxbjmnokevncfxkladrsqjvxugtokcabeqxehmnhkcbgrdmnmmyfsmifrrkriggeplcfbfpxsbfcxbdzbvdgsbrcebmkpsdbdntfdbaltnsdzrfafhobrsygktetomeqvkrztyzeqimcaktnvfcehaeexqjnjfyvomfqsbdjxhhjojvytaovvirpfrdpgurzfhknsimnmhctbkixfcjrzfjvjsigilmoxcuiginjitarxettzzcpcesnufbtlpdxupmpfmhzqnufjxrkaapaaalaulebxizfjshbjsagmxmueshecuoobzctngykkzsftzatquxxdgmjxuybkzvxsftzpqhmarlsbayriaahlrcdgjadhbrizmnaycfaftnfdzobdhhyhrxvddsycenimblnrcicasqhttekqyiafijoiykcmstzbjupsbqxbzeyqxbsshelvzxekiozylenrlaelpykdpvzhvpttmsyxsjbrfqchgrxcubkgqinluzjrqltzitvhlofjizxsxvbbqbcsuoufodozsrmjecfdricsljmmrcletuvxcxfitpmgocjdcurzbfqpefxtndzkuuzxpaxfanxdxntuiapkzoufqiykxntmlyepmyzjneyvnfuqzlrkseyhpbgrtcpnqmpqcgubjuourdriziimoflmyzsskvfagldopgthcdmmqhrmksxgeckarmjgauvj", "gatezejttddpkmndtauvjcffiiafgzhkqgzliirdldbmqkdfpeadgjxcirgkmkcfxorthhpujbnenxansboejjrqfxoohuolsxgohukxmpzfukzvkduurvajrodlpxojzsihiqftrbkixbcxraqpiyadbkzqihmigunrzfzcgzfkeszcpkdotulkktfduekyqzkymqpeidhpyuhotynqaxknnsheiogrhobrajzkrekexvorlvlyhtgstjrtdgjzahvmjnprcumulnvftgoiyctjgtthleeunkgbemapsntmfdnuaydkrbyngbrbpsznfdftonfmbjahqrpgddbkokvdxfflzysneapnqvsqhilxabbjamkdhpktscxsczpoontmliozurkrvagnidnmcayiradtbacltouzacvseayrdzkkkqgbfrrnfydbnnxvctffgtfpbmfzsqjnclcnttztcvvpbmkovahvpdnjqghcafzcxhrxumhxxkdtyjqypljzsbidfpoydlumdrhokvmstydlmymldvimdduvzzcmiyxapbrrrndhjnhncpibdmiryjteyvcydxkthxcbgxshffuzevvfrcrpzaotcpbefqqppehgdlbfstralgzbtdfervuvejyvvocrabkiohjxjnnrshvyijyonzzioeakpbkgxybtlcbybgzvvvvhhkdfvpupxnlecqizvzhgigliotybprnnntqdsiquxvdxojripdlmzsyorhjandaqtjfptgebxbjmnokevncfxkkadrsqjvxuttokcabefxehmnhkcbgrdmnmmycflifrrkriggeplcfafpxsbfchbdzbvdgsbrcebgkgsdbdntfdbaltnsdzraafhobrsygkvetomeqvkrntyzeqimcaktnvfcehaeexqjnjfyvomfqlbdjxhhjojvytaovvprpfrdpgurzfhknsimnmhctbkzxfxjrzfjvjsigivmlxcgiginjitarxettzzcpceonufetlpdxupmpfmhzanufjxrkaapaaalaulebxizfjshbjsagmxmuesvecuoobuctngykkzsztzauquxxdgmjxuybkzvxsftzpqhmarlsbaeriaahlrcdgjadhbrizmnabcfadtnfdzobdhayhrxmdddycenimblnrlicasqhttekqyiafijoiykcmutzbjupsbqxbzeyqxbsshelvzieoiozylenrlaelpykdpvzhvpttmsyxsjbrfqchgrxcuvkgqinluzjrqlnzitvhlofjiznsxvbbhscsuoufodozsrmjecfdrkcslgmmrcletuvxcdfitpmgocjdcurrbfqpefxtndzkuuzxpaxfanxdxnteiapkzouvqiykxntmltdpmyzjveivnfuhzlrkseyhpbgrtcvnqmpqcgubjyourdrizixmoflmyzsskvfagtdopgthcdmmqhkmksxgeckagmjgauvz"));

    }


    static int substringDiff(int k, String s1, String s2) {
        char[] sa1 = s1.toCharArray();
        char[] sa2 = s2.toCharArray();
        int max = 1;

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < sa1.length; i++) {
            for (int j = 0; j < sa2.length; j++) {
                if (sa1[i] == sa2[j]) q.add(j);
            }
            while (q.isEmpty()) {
                int index = q.remove();
                
            }
        }
        return max;
    }
}

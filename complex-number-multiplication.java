public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] parts = a.split("+");
        String areal = parts[0], avirtual = parts[1].substring(0, parts[1].length-1);
        parts = b.split("+");
        String breal = parts[0], bvirtual = parts[1].substring(0, parts[1].length-1);
        int arealInt, brealInt, avirtualInt, bvirtualInt;
        if (areal.charAt(0) == '-') arealInt = -1*Integer.valueOf(areal); else arealInt = Integer.valueOf(areal);
        if (avirtual.charAt(0) == '-') avirtualInt = -1*Integer.valueOf(avirtual); else avirtualInt = Integer.valueOf(avirtual);
        if (breal.charAt(0) == '-') brealInt = -1*Integer.valueOf(breal); else brealInt = Integer.valueOf(breal);
        if (bvirtual.charAt(0) == '-') bvirtualInt = -1*Integer.valueOf(bvirtual); else bvirtualInt = Integer.valueOf(bvirtual);
        int real = -1*avirtual*bvirtual + areal*breal;
        int virtual = avirtual*breal + bvirtual*areal;
        String res = "";
        if (real < 0) res += "-";
        res += real + " + ";
        if (virtual < 0) res += "-";
        res += virtual;
        return res;
        
    }
}

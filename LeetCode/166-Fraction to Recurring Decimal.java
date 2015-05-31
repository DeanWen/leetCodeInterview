 public static String fractionToDecimal(int numerator, int denominator) {
    if (denominator == 0) {
        return "";
    }
    if (numerator == 0) {
        return "0";
    }
    
    StringBuilder result = new StringBuilder();
    Long n = new Long(numerator);
    Long d = new Long(denominator);
    //check if negative
    if (n * d < 0) {
        result.append("-");
    }
    n = Math.abs(n);
    d = Math.abs(d);
    result.append(Long.toString(n/d));
    //check result if integer or float
    if (n % d == 0) {
        return result.toString();
    }else {
        result.append(".");
    }
    //calculate the reminder
    //store in the hashmap, key is reminder & value the starting position
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    Long r = n % d;
    while (r > 0) {
        if (map.containsKey(r)) {
            result.insert(map.get(r), "(");
            //result.append(Long.toString(r));
            result.append(")");
            break;
        }
        map.put(r, result.length());
        r *= 10;
        result.append(Long.toString(r / d));
        r %= d;
    }
    return result.toString();
}

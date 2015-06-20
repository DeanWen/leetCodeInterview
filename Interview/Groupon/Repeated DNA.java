//This problem pertains to the field of bioinformatics, but it does not require any specialized 
//biological knowledge.  All DNA is composed of sequences of four "letters" of nucleotides, whose
//abbreviations are A, C, G, and T, strung together, for example: "AAGATCCGTC".  A typical 
//chromosome (a very long DNA molecule) may have several millions of these letters strung together. 
//When studying DNA, it is sometimes useful to know when a particular sequence of letters is repeated.
//
//For this problem, we would like to identify all the 10-letter-long sequences that occur more 
//than once in any given chromosome.  

// Function should take InputStream 

// AAGATCCGTCAAGATCCGTC
// AAGATCCGTC
// int  4 bytes
// char 2 bytes

input.read() // returns a byte
  if(input.read() == -1)

public List<String> findRepeatOne (InputStream input) {
  List<String> res = new ArrayList<String>();
   input.read();//return a byte 8 bits
    
   HashMap<Character, Integer> map = new HashMap<Character, Integer>();
   map.put("A", 0);
   map.put("C", 1);
   map.put("G", 2);
   map.put("T", 3);
  
  HashSet<Integer> set = new HashSet<Integer>();
  HashSet<Integer> add = new HashSet<Integer>();
  
  int hash = 0;
  
  List<Byte> blist = new List<Byte>();
  while(input.read() != -1) {
    Byte byte = input.read();
    blist.add(byte);
  }
  
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < blist.size() - 1; i += 2) {
     char c = (char)(blist.get(i) + blist.get(i + 1));
     sb.append(c);
  }
  
  String s = sb.toString();
  for (int i = 0; i < s.length(); i++) {
    if (i < 9) {
      hash = (hash << 2) + map.get();
    }else {
      hash = (hash << 2) + map.get(s.charAt(i));
      hash = hash & (1 << 20) - 1;
      
      if (set.contains(hash) && !add.contains(hash)) {
          res.add(s.substring(i - 9, i + 1));
          add.add(hash);
      }else {
          set.add(hash);
      } 
    }
  }
  
  return res;
}
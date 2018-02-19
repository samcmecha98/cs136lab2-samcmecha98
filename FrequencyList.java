import structure5.*;
import java.util.Scanner;
import java.util.Random;


public class FrequencyList {

  protected Vector<Association<String, Integer>> charCount;

  public FrequencyList (String text, String seq) {

    charCount = new Vector<Association<String, Integer>>();
    int seqIndex = 0;
    int charIndex = 0;
    String nextChar = new String ("");
    int nextIndex = 0;
    Integer freq = 0;


    for (int i = 0; i < text.length(); i++) {
      seqIndex = text.indexOf(seq, nextIndex);

      while (seqIndex < text.length()) {


        int length = seq.length();
        charIndex = seqIndex + length;
        nextChar = Character.toString(text.charAt(charIndex));
        //System.out.println(nextChar);


        freq = 1;

        if (!(text.indexOf(seq+nextChar) < i)) {
          int next = 1;

          for (Integer j = i + next; j < text.length(); j++) {

            if (text.indexOf(seq+nextChar) == j) {
              freq++;
            }
          }
          //System.out.println(freq);



        }

        nextIndex = seqIndex + 1;
        seqIndex = text.length() + 1;
      }
      charCount.add(new Association<String, Integer>(nextChar, freq));

    }
    System.out.println(charCount);
  }

  public String getChar () {
    Random random = new Random(this.getTotal(charCount));
    int randomNum = random.nextInt();
    String character = new String("");
    for (int i = 0; i < charCount.size(); i++) {
      if (charCount.get(i).getValue() > randomNum+1) {
        character = charCount.get(i).getKey();
      }
      //help from Aki Takigawa
    }
    return character;
  }

  public Integer getTotal(Vector<Association<String, Integer>> vector) {
    Integer total = 0;
    vector = charCount;
    for (int i = 0; i < charCount.size(); i++) {
      Integer addend = charCount.get(i).getValue();
      total = total + addend;
    }
    return total;
  }

  /*public long getProb(Association<String, Integer> association) {
  Integer numerator = association.getValue();
  long percent = numerator / this.getDenom(charCount);
  return percent;

}*/
}

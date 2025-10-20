public class BigNumber {
   int[] arr = new int[1000];
   int size = 0;

   BigNumber() {
      this("");
   }

   BigNumber(String n) {
      int len = n.length();
      for (int i = 0; i < len; i++) {
         arr[999 - i] = n.charAt(len - i - 1) - '0';
         size++;
      }
   }

   public boolean equals(BigNumber n) {
      if (this.size != n.size)
         return false;
      for (int i = 999; i > 999 - size; i--) {
         if (this.arr[i] != n.arr[i])
            return false;
      }
      return true;
   }

   public BigNumber add(BigNumber n) {
      BigNumber newN = new BigNumber();
      int len = Math.max(n.size, this.size);
      int resto = 0;
      for (int i = 999; i > 999 - len; i--) {
         int sum = (this.arr[i] + n.arr[i] + resto);
         // System.out.println(sum)
         newN.arr[i] = sum % 10;
         newN.size++;
         resto = sum / 10;
      }
      if (resto > 0) {
         newN.arr[999 - len] = resto;
         newN.size++;
      }
      return newN;
   }

   public BigNumber multiply(BigNumber n) {
      BigNumber newN = new BigNumber();
      for (int i = 999; i > 999 - n.size; i--) {
         int resto = 0;
         for (int j = 999; j > 999 - size; j--) {
            int pos = i + j - 999;
            int sum = newN.arr[pos] + arr[j] * n.arr[i] + resto;
            newN.arr[pos] = sum % 10;
            resto = sum / 10;
         }
         if (resto > 0){
            newN.arr[i - size] += resto;
         }
      }
      for (int i = 0; i < 1000; i++){
         if (newN.arr[i] > 0){
            newN.size = 999-i +1;
            break;
         }
      }
      return newN;
   }

   @Override
   public String toString() {
      String str = "";
      for (int i = 999 - size + 1; i <= 999; i++) {
         str += arr[i];
      }
      return str;
   }

   public static void main(String[] args) {
      BigNumber n1 = new BigNumber("123");
      BigNumber n2 = new BigNumber("789");
      BigNumber n3 = n1.add(n2);
      BigNumber n4 = n1.multiply(n2);
      System.out.println(n1);
      System.out.println(n2);
      System.out.println(n3);
      System.out.println(n4);
   }
}

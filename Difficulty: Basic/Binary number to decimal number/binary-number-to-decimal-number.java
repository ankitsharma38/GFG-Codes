class Solution {
    public int binaryToDecimal(String b) {
        int decimal = 0;
        int power = 0;

        // traverse string from right to left
        for (int i = b.length() - 1; i >= 0; i--) {
            if (b.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }
}

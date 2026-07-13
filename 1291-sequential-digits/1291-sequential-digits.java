class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> answer = new ArrayList<>();

        int current = 12;

        while(current <= high) {

            if(current >= low) {
                answer.add(current);
            }

            int lastDigit = current % 10;

            int digits = 0;
            int temp = current;

            while(temp > 0) {
                temp /= 10;
                digits++;
            }


            if(lastDigit == 9) {

                if(digits == 9) {
                    break;
                }

                current = (int)Math.pow(10, digits) + create(digits, false);

            } else {
                current += create(digits, true);
            }
        }

        return answer;
    }


    public int create(int digits, boolean ones) {

        switch(digits) {

            case 2:
                return ones ? 11 : 23;
            case 3:
                return ones ? 111 : 234;
            case 4:
                return ones ? 1111 : 2345;
            case 5:
                return ones ? 11111 : 23456;
            case 6:
                return ones ? 111111 : 234567;
            case 7:
                return ones ? 1111111 : 2345678;
            case 8:
                return ones ? 11111111 : 23456789;
            case 9:
                return ones ? 111111111 : 0;
            default:
                return 0;
        }
    }
}
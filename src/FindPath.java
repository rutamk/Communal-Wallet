import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;

public class FindPath {

    // HashMap to store each person's balance (positive or negative)
    static HashMap<String, Double> parm;

    public static void main(String[] args) {
        parm = new HashMap<>();
        parm.put("Aarav", -5.0); // Aarav owes ₹5
        parm.put("Bhavna", 25.0); // Bhavna is owed ₹25
        parm.put("Chaitanya", -20.0); // Chaitanya owes ₹20
        parm.put("Devika", 25.0); // Devika is owed ₹25
        parm.put("Esha", -20.0); // Esha owes ₹20
        parm.put("Farhan", -5.0); // Farhan owes ₹5

        // Call findPath to process and settle payments
        findPath(parm);
    }

    /**
     * Method to find and settle payments among friends.
     *
     * @param details A map where the key is a friend's name and the value is their
     *                balance.
     *                Positive values indicate amounts owed to the friend, negative
     *                values indicate
     *                amounts the friend owes.
     */
    public static void findPath(HashMap<String, Double> details) {
        // Find the maximum and minimum balances in the map
        Double maxBalance = Collections.max(details.values()); // Most money owed to someone
        Double minBalance = Collections.min(details.values()); // Most money someone owes

        // Process only if there are differing balances
        if (!maxBalance.equals(minBalance)) {
            // Identify friends with the maximum and minimum balances
            String maxKey = getKeyFromValue(details, maxBalance); // Friend to receive money
            String minKey = getKeyFromValue(details, minBalance); // Friend to pay money

            // Calculate the net result of the payment
            Double result = maxBalance + minBalance;
            result = round(result, 1); // Round result to one decimal place

            if (result >= 0.0) {
                // If result is non-negative: minKey needs to pay maxKey the absolute value of
                // minBalance
                System.out.println(minKey + " needs to pay " + maxKey + ": ₹" + round(Math.abs(minBalance), 2));

                // Update balances in the map
                details.remove(maxKey); // Remove the maxKey entry
                details.remove(minKey); // Remove the minKey entry
                details.put(maxKey, result); // Update maxKey balance
                details.put(minKey, 0.0); // Set minKey balance to zero
            } else {
                // If result is negative: minKey needs to pay maxKey the absolute value of
                // maxBalance
                System.out.println(minKey + " needs to pay " + maxKey + ": ₹" + round(Math.abs(maxBalance), 2));

                // Update balances in the map
                details.remove(maxKey); // Remove the maxKey entry
                details.remove(minKey); // Remove the minKey entry
                details.put(maxKey, 0.0); // Set maxKey balance to zero
                details.put(minKey, result); // Update minKey balance
            }

            // Recursively process the remaining balances
            findPath(details);
        }
    }

    /**
     * Method to find the key associated with a given value in a HashMap.
     *
     * @param hm    The HashMap containing balances.
     * @param value The balance value for which to find the key.
     * @return The key corresponding to the given value.
     */
    public static String getKeyFromValue(HashMap<String, Double> hm, Double value) {
        for (String key : hm.keySet()) {
            if (hm.get(key).equals(value)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Method to round a double value to a specified number of decimal places.
     *
     * @param value  The value to be rounded.
     * @param places The number of decimal places to round to.
     * @return The rounded value.
     */
    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException(); // Ensure places is non-negative

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP); // Round using HALF_UP mode
        return bd.doubleValue(); // Return the rounded value
    }
}

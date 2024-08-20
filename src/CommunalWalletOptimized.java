import java.util.*;

public class CommunalWalletOptimized {

    public static void main(String[] args) {
        // Initialize balances
        HashMap<String, Double> balances = new HashMap<>();
        balances.put("Aarav", -5.0); // Aarav owes ₹5
        balances.put("Bhavna", 25.0); // Bhavna is owed ₹25
        balances.put("Chaitanya", -20.0);// Chaitanya owes ₹20
        balances.put("Devika", 25.0); // Devika is owed ₹25
        balances.put("Esha", -20.0); // Esha owes ₹20
        balances.put("Farhan", -5.0); // Farhan owes ₹5

        // Find and print the settlement plan
        List<String> settlementPlan = findSettlementPlan(balances);
        for (String settlement : settlementPlan) {
            System.out.println(settlement);
        }
    }

    public static List<String> findSettlementPlan(HashMap<String, Double> balances) {
        // Check if the sum of all debts equals the sum of all credits
        double totalDebt = 0.0;
        double totalCredit = 0.0;

        for (double balance : balances.values()) {
            if (balance < 0) {
                totalDebt += -balance; // Add absolute value of debt
            } else {
                totalCredit += balance; // Add credit
            }
        }

        // If the sums do not match, return an error or empty settlement plan
        if (Math.abs(totalDebt - totalCredit) > 0.001) {
            System.out.println("Error: The total debt does not equal the total credit.");
            return Collections.emptyList();
        }

        // Create lists for debtors and creditors
        Queue<Person> debtors = new LinkedList<>();
        Queue<Person> creditors = new LinkedList<>();

        // Populate queues based on net balances
        for (Map.Entry<String, Double> entry : balances.entrySet()) {
            String person = entry.getKey();
            double balance = entry.getValue();

            if (balance < 0) {
                debtors.offer(new Person(person, -balance)); // Store debt as positive value
            } else if (balance > 0) {
                creditors.offer(new Person(person, balance));
            }
        }

        // Prepare a list to store the settlement plan
        List<String> settlementPlan = new ArrayList<>();

        // Settle debts using the queues
        while (!debtors.isEmpty() && !creditors.isEmpty()) {
            Person debtor = debtors.poll();
            Person creditor = creditors.poll();

            double amountToSettle = Math.min(debtor.amount, creditor.amount);
            settlementPlan.add(debtor.name + " needs to pay " + creditor.name + " ₹" + amountToSettle);

            // Adjust remaining balances
            debtor.amount -= amountToSettle;
            creditor.amount -= amountToSettle;

            // If there's remaining debt, push the debtor back to the queue
            if (debtor.amount > 0) {
                debtors.offer(debtor);
            }

            // If there's remaining credit, push the creditor back to the queue
            if (creditor.amount > 0) {
                creditors.offer(creditor);
            }
        }

        return settlementPlan;
    }

    static class Person {
        String name;
        double amount;

        Person(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }
    }
}

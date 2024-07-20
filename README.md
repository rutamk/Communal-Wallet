Communal Wallet: Debt Settlement Algorithm 💸

Overview
The Communal Wallet algorithm simplifies debt transactions among a group of people by addressing the largest debts and credits first. The aim is to minimize the number of transactions needed to settle all debts efficiently.

Scenario
Imagine a group of friends who have shared expenses, resulting in the following balances:

Aarav: -₹5 (owes ₹5) 💰
Bhavna: ₹25 (is owed ₹25) 💵
Chaitanya: -₹20 (owes ₹20) 💰
Devika: ₹25 (is owed ₹25) 💵
Esha: -₹20 (owes ₹20) 💰
Farhan: -₹5 (owes ₹5) 💰
Using this algorithm, we simplify their transactions by directly settling the largest amounts.

Steps
Calculate Net Amounts:

Each person's net balance is provided:
Positive Balance: Person is owed money. 💵
Negative Balance: Person owes money. 💰
Identify Debtors and Creditors:

Largest Debtor: Esha and Chaitanya (both owe ₹20, which is the maximum debt). 💰
Largest Creditor: Bhavna and Devika (both are owed ₹25, which is the maximum credit). 💵
Settle Debts:

Step 1: Esha (largest debtor) should pay Devika (largest creditor). Esha owes ₹20 and Devika is owed ₹25. Transfer ₹20 from Esha to Devika.

Updated Balances:
Esha: -₹0 (debt settled) ✅
Devika: ₹5 (remaining credit) 💵
Step 2: Chaitanya (next largest debtor) should pay Bhavna (next largest creditor). Chaitanya owes ₹20 and Bhavna is owed ₹25. Transfer ₹20 from Chaitanya to Bhavna.

Updated Balances:
Chaitanya: -₹0 (debt settled) ✅
Bhavna: ₹5 (remaining credit) 💵
Step 3: Handle the remaining balances:

Aarav: -₹5 (owes ₹5) 💰
Farhan: -₹5 (owes ₹5) 💰
Bhavna and Devika have remaining credits of ₹5 each. 💵
Aarav can pay Bhavna ₹5, and Farhan can pay Devika ₹5.

Final Balances:

Aarav: ₹0 (debt settled) ✅
Farhan: ₹0 (debt settled) ✅
Bhavna: ₹0 (credit settled) ✅
Devika: ₹0 (credit settled) ✅
Update Balances:

Adjust the balances after each settlement and remove anyone whose balance becomes zero from further consideration.
Repeat:

Continue this process with updated balances until all debts are settled or only one person remains with a non-zero balance.
Conclusion
By following the Communal Wallet algorithm, you ensure that debts are settled efficiently, minimizing the number of transactions and simplifying the settlement process for everyone involved. 🎉

# How to Use?  
  
I have created a method which just do it.  
   **"findPath(parm)"**  
    
**Create a HashMap Variable**  
  "static HashMap parm = new HashMap()"  
  
**Add the Expense in below formate**  

       "parm.put("Name", Amount)"  
  
  For Example,  
  
        parm.put("Aarav", -5.0);  // Aarav owes ₹5
        parm.put("Bhavna", 25.0); // Bhavna is owed ₹25
        parm.put("Chaitanya", -20.0); // Chaitanya owes ₹20
        parm.put("Devika", 25.0); // Devika is owed ₹25
        parm.put("Esha", -20.0); // Esha owes ₹20
        parm.put("Farhan", -5.0); // Farhan owes ₹5

**Passing values to find the Net Amount to be Paid with Person Name -Cash Flow / Shortest Path**  
      
      findPath(parm);  
      
**Output**  
Chaitanya needs to pay Bhavna: ₹20.0
Esha needs to pay Devika: ₹20.0
Farhan needs to pay Bhavna: ₹5.0
Aarav needs to pay Devika: ₹5.0
        


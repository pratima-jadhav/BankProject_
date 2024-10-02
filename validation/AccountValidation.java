package validation;

public class AccountValidation {
	public boolean checkAccNo(int accno) {
		if (accno <= 0) {
			System.out.println("Invalid Account number");
			return false;
		} else
			return true;

	}

	public boolean checkBalance(double Balance) {
		if (Balance <= 0) {
			System.out.println("the Balance is Invalid ");
			return false;

		} else if (Balance > 100000) {
			System.out.println("Please show the proof...");
			return false;

		} else
			return true;

	}

	public boolean checkAccHolderName(String accHolderName) {
		boolean valid = false;
		char ch;
		for (int i = 0; i < accHolderName.length(); i++) {
			ch = accHolderName.charAt(i);

			if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
				valid = true;
			} else {
				valid = false;
				break;
			}
		}
		if (valid == true) {
			System.out.println("valid name");
			return true;
		} else {
			System.out.println("Name is Invalid");
			return false;
		}
	}

	public boolean checkAll(int accNo, String accHolderNAme, Double Balance) {
		if (!checkAccNo(accNo))
			return false;
		else if (!checkAccHolderName(accHolderNAme))
			return false;
		else if (!checkBalance(Balance))
			return false;
		else
			return true;

	}
}

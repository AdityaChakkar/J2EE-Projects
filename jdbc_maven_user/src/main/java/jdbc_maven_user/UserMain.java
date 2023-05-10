package jdbc_maven_user;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		User user = new User();

		UserCRUD crud = new UserCRUD();

		boolean condition = true;
		do {

			System.out.println("Enter your Choice \n 1.SignUp User \n 2.Login User \n 3.exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the id : ");
				user.setId(scanner.nextInt());
				System.out.println("Enter the Name : ");
				user.setName(scanner.next());
				System.out.println("Enter the Email : ");
				user.setEmail(scanner.next());
				System.out.println("Enter the Password : ");
				user.setPassword(scanner.next());
				System.out.println("Enter the Address : ");
				user.setAddress(scanner.next());

				crud.signupUser(user);
				break;
			case 2: {
				System.out.println("Enter the Email : ");
				String email = scanner.next();
				user.setEmail(email);
				System.out.println("Enter the Password : ");
				user.setPassword(scanner.next());

				boolean result = crud.loginUser(user);
				if (result) {
					System.out.println("Login successfull..!!");
					crud.displayPassword(email);

					System.out.println("Enter your Choice \n 1.Update Password \n 2.logged out");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1:
						System.out.println("Enter Facebook Password : ");
						String facebook = scanner.next();
						System.out.println("Enter Whatsapp Password : ");
						String whatsapp = scanner.next();
						System.out.println("Enter Instagram Password : ");
						String instagram = scanner.next();
						System.out.println("Enter Twitter Password : ");
						String twitter = scanner.next();
						System.out.println("Enter Snapchat Password : ");
						String snapchat = scanner.next();

						// single set password program {

						/*
						 * System.out.println( "Enter your Choice " + "\n 1. Change facebook Password "
						 * + "\n 2. Change Whatsapp Password " + "\n 3. Change Instagram Password " +
						 * "\n 4. Change Twitter Password " + "\n 5. Change Snapchat Password \n "); int
						 * choice2 = scanner.nextInt(); switch (choice2) { case 1:
						 * System.out.println("Enter Facebook Password : "); String facebook =
						 * scanner.next(); user.setFacebook(facebook); break; case 2:
						 * System.out.println("Enter Whatsapp Password : "); String whatsapp =
						 * scanner.next(); user.setWhatsapp(whatsapp); break; case 3:
						 * System.out.println("Enter Instagram Password : "); String instagram =
						 * scanner.next(); user.setInstagram(instagram); break; case 4:
						 * System.out.println("Enter Twitter Password : "); String twitter =
						 * scanner.next(); user.setTwitter(twitter); break; case 5:
						 * System.out.println("Enter Snapchat Password : "); String snapchat =
						 * scanner.next(); user.setSnapchat(snapchat); break; default: break; }
						 */

						// }single set password end

						user.setFacebook(facebook);
						user.setWhatsapp(whatsapp);
						user.setInstagram(instagram);
						user.setTwitter(twitter);
						user.setSnapchat(snapchat);

						crud.updatePassword(user);
						break;

					default:
						break;
					}
				} else {
					System.out.println("Invalid password,Please try again..!!");
				}
			}
				break;
			default:
				condition = false;
			}
		} while (condition);
	}
}

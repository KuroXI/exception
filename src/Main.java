import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final int MAX_ATTEMPT = 3;
		final String VALID_PASSWORD = "password";
		
		try (Scanner scanner = new Scanner(System.in)) {
			int attempt = 0;
			while (attempt < MAX_ATTEMPT) {
				System.out.print("Enter password: ");
				String password = scanner.next();
				
				try {
					if (password.equals(VALID_PASSWORD)) {
						System.out.println("Password is correct!");
						break;
					} else {
						throw new InvalidPasswordException("Invalid password. Please try again!");
					}
				} catch (InvalidPasswordException e) {
					System.out.println(e.getMessage());
					attempt++;
				}
			}
			
			if (attempt == MAX_ATTEMPT) {
				throw new TooManyAttemptException("Too many attempt. Please try again later!");
			}
		} catch (TooManyAttemptException e) {
			System.out.println(e.getMessage());
		}
	}
}
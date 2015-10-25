package hh_partition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Methods {

	/**
	 * ������� ��� �������� ���������� �������� ��������� ������ ����� N �� �
	 * ���������, �� ������ 0
	 * 
	 * @param n
	 *            - ����� ����������� �� ���������
	 * @param k
	 *            - ���������� ��������� �� ������� ��������� ������� �����
	 * @return ���������� �������� ���������
	 */
	public static int partition(int n, int k) {
		/*
		 * ���� ���������� ��������� ����������� �����, �� ��� �������� ���
		 * ������ ��������� ���� ���������� ��������� ����� 1 ��� �����, ��
		 * ���������� ���� ������ ������ ��������� ��������� (n-1),(k-1) -
		 * ��������� ���������� ������� ��������� (n-k),k - �������� ��
		 * ���������� ������� ����� ���������� ��������� - ����� (n-1),(k-1) �
		 * (n-k),k ���������
		 */
		if (k > n) {
			return 0;
		}

		if (n == k || k == 1) {
			return 1;
		}

		return partition(n - 1, k - 1) + partition(n - k, k);

	}

	/**
	 * ��������� ������ �� �������
	 */
	public static void readFromConsole() {

		Scanner in = new Scanner(System.in);
		String input = new String();
		int n, k;

		System.out.println(
				"Enter \'n\' and \'k\' values in the folowing format: <n><space><k>.\nType \'end\' for complite.");
		input = in.nextLine();
		while (!input.equals("end")) {
			try {
				n = Integer.valueOf(input.substring(0, input.indexOf(" ")));
				k = Integer.valueOf(input.substring(input.indexOf(" ") + 1));
				System.out.println(getAnswerAtStringForm(n, k));
				input = in.nextLine();
			} catch (NumberFormatException e) {
				System.out.println("Uncorrect format of input data. Or numbers are not is Integer");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Uncorrect format of input data. String must be look like <n><space><k>");
			}
		}
		in.close();
	}

	/**
	 * ��������� ������ �� ���������� �����, ������ ������ � �����
	 * <n><������><k>
	 * 
	 * @param path
	 *            - ���� � �����
	 * @throws FileNotFoundException
	 *             - ��������� ���� �� ������
	 */
	public static void readFromFile(String path) throws FileNotFoundException {

		int n, k;
		String input;
		File file = new File(path);
		Scanner fin = new Scanner(file);

		if (file.exists() && file.canRead()) {
			while (fin.hasNextLine()) {
				try {
					input = fin.nextLine();
					n = Integer.valueOf(input.substring(0, input.indexOf(" ")));
					k = Integer.valueOf(input.substring(input.indexOf(" ") + 1));
					System.out.println(getAnswerAtStringForm(n, k));
				} catch (NumberFormatException e) {
					System.out.println("Uncorrect format of input data. Or numbers are not is Integer");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Uncorrect format of input data. String must be look like <n><space><k>");
				}
			}
			fin.close();
		} else {
			System.out.println("The specified file does not exist or is being used by another process.");
		}

	}

	/**
	 * ���������� ���������� � ���������� ��������� n �� k ��������� � �����
	 * ������
	 * 
	 * @param n
	 *            - ����� ��� ���������
	 * @param k
	 *            - ���������� ���������
	 * @return ���������� �������� ���������
	 */
	public static String getAnswerAtStringForm(int n, int k) {
		return ("N=" + n + " k=" + k + " count of ways C=" + partition(n, k));
	}
}

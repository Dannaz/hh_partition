package hh_partition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Methods {

	/**
	 * Функция для подсчета количества способов разбиения целого числа N на К
	 * слагаемых, не равных 0
	 * 
	 * @param n
	 *            - Число разбиваемое на слагаемые
	 * @param k
	 *            - Количество слагаемых на которые требуется разбить число
	 * @return Количество способов разбиения
	 */
	public static int partition(int n, int k) {
		/*
		 * Если количество слагаемых превосходит число, то нет способов для
		 * такого разбиения Если количество слагаемых равно 1 или числу, то
		 * существует один способ такого разбиения Разбиения (n-1),(k-1) -
		 * разбиения содержащие единицу Разбиения (n-k),k - разбения не
		 * содержащие единицу Общее количество разбиений - сумма (n-1),(k-1) и
		 * (n-k),k разбиений
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
	 * Считывает данные из консоли
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
	 * Считывает данные из указанного файла, формат данных в файле
	 * <n><пробел><k>
	 * 
	 * @param path
	 *            - путь к файлу
	 * @throws FileNotFoundException
	 *             - Указанный Файл не найден
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
	 * Возвращает информацию о количестве разбиений n на k слагаемых в форме
	 * строки
	 * 
	 * @param n
	 *            - Число для разбиения
	 * @param k
	 *            - Количество слагаемых
	 * @return Количество способов разбиения
	 */
	public static String getAnswerAtStringForm(int n, int k) {
		return ("N=" + n + " k=" + k + " count of ways C=" + partition(n, k));
	}
}

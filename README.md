# Количество разбиений на k слагаемых
## Задание №2 для школы программирования HeadHunter
###### Формулировка задания
Для данных натуральных чисел n и k определите количество способов представить число n в виде суммы k натуральных слагаемых, 
если способы, отличающиеся только порядком слагаемых считать одинаковыми.
Программа получает на вход два натуральных числа n и k, не превосходящих 150.
###### Решение
Если количество слагаемых превосходит число, то нет способов для 
такого разбиения Если количество слагаемых равно 1 или числу, то 
существует один способ такого разбиения Разбиения (n-1),(k-1) - 
разбиения содержащие единицу Разбиения (n-k),k - разбения не 
содержащие единицу Общее количество разбиений - сумма (n-1),(k-1) и (n-k),k разбиений
###### Формат входных данных
Данные на вход программы можно подать через консоль или считать из файла.
Данные должны быть представленны в следующем формате:<br>
<code>
<число><пробел><количество слагаемых>
</code>
<br>
<code>
<число><пробел><количество слагаемых>
</code>
###### Пример входных данных
6 3<br>
15 3<br>
15 2<br>
100 6<br>
###### Пример выходных данных
N=6 k=3 count of ways C=3<br>
N=15 k=3 count of ways C=19<br>
N=15 k=2 count of ways C=7<br>
N=100 k=6 count of ways C=143247<br>
###### Запуск проекта
Скачать, добавить как проект в Eclipse или запустить partition_runnable.jar с помощью runnable.bat находящегося в \runnable в корне проекта

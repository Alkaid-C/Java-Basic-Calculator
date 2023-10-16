# Java-Basic-Calculator
Thi is the first program I wrote when I was in high school. It is a very basic calculator, supporting addition, subtraction, multiplication, division, and exponentiation. It takes a string of usual mathematical expression as input, like (12.14*(2+7.5))^3, and give its value as output.

The main difficulty of this program is to break the string and determine the sequence of operation. (function BreakNumbers and BreakOrders.) There is no precision or overflow measure; all numbers are stored as double.

Don't ask me what those comments are; I have also forgotten and do not know what code it uses.

Usage: Call function public static double Calculate(String Original). The input string should be a usual mathematical expression, like (12.14*(2+7.5))^3. Only parentheses "()" are allowed, please don't use brackets "[]".

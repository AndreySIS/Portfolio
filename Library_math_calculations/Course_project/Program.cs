using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Course_project
{

    public delegate double IntOperation (double i, double j);

    class Program
    {
        static void Main(string[] args)
        {
            double s = 0;
            int col = 0;
            int m = 0;
            double sum = 0;
            string selection = "";

            while (++m < 2)
            {
                Console.WriteLine("Выберете вариант работы программы");
                Console.WriteLine("Нажмите 1 для вычисления тригонометрических функций");
                Console.WriteLine("Нажмите 2 для вычисления интеграла");
                selection = Console.ReadLine();
                if (selection == "1")
                    Console.WriteLine("Введите искомую тригонометрическую функцию");
                else if (selection == "2")
                    Console.WriteLine("Введите искомую подынтегральную функцию");
                else
                {
                    Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                    Console.ReadLine();
                    --m;
                    Console.Clear();
                    continue;
                }

                string f = Console.ReadLine();
                Char charRange = '0';
                Char charRange1 = '0';
                for (int i = 0; i < f.Length; i++)
                {
                    if (Char.IsDigit(f[i]) == true && col < 1)
                    {
                        charRange = f[i];
                        col++;
                    }
                    if (Char.IsDigit(f[i]) == true)
                    {
                        charRange1 = f[i];
                    }
                }
                int startIndex = f.IndexOf(charRange);
                int endIndex = f.LastIndexOf(charRange1);
                int length = Math.Abs(endIndex - startIndex + 1);
                if (startIndex >= 0)
                    s = Convert.ToDouble(f.Substring(startIndex, length));
                if (selection == "1")
                {
                    Console.WriteLine("Введите количество шагов разбиения");
                    string N = Console.ReadLine();
                    int n = Convert.ToInt32(N);
                    if (n < 1)
                    {
                        Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                        Console.ReadLine();
                        --m;
                        Console.Clear();
                        continue;
                    }
                    if (f.Contains("sin") == true)
                    {
                        sum = Library_math_calculations.sinus(s, n);
                    }
                    else if (f.Contains("cos") == true)
                    {
                        sum = Library_math_calculations.cosine(s, n);
                    }
                    else if (f.Contains("ctg") == true)
                    {
                        sum = Library_math_calculations.cotangent(s, n);
                    }
                    else if (f.Contains("tg") == true)
                    {
                        sum = Library_math_calculations.tangent(s, n);
                    }
                    else if (f.Contains("exp") == true)
                    {
                        sum = Library_math_calculations.exponent(s, n);
                    }
                    else if (f.Contains("!") == true)
                    {
                        sum = Library_math_calculations.factorial(s);
                    }
                    else
                    {
                        Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                        Console.ReadLine();
                        --m;
                        Console.Clear();
                        continue;
                    }
                }


                //интеграл

                else if (selection == "2")
                {
                    Console.WriteLine("Введите начало интервала a");
                    string A = Console.ReadLine();
                    int a = Convert.ToInt32(A);
                    Console.WriteLine("Введите конец интервала b");
                    string B = Console.ReadLine();
                    int b = Convert.ToInt32(B);
                    Console.WriteLine("Введите количество шагов разбиения");
                    string N = Console.ReadLine();
                    int n = Convert.ToInt32(N);
                    if (n < 1)
                    {
                        Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                        Console.ReadLine();
                        --m;
                        Console.Clear();
                        continue;
                    }
                    Console.WriteLine("Выбирете метод вычисления интеграла:");
                    Console.WriteLine("Метод прямоугольников - 1");
                    Console.WriteLine("Метод трапеций - 2");
                    Console.WriteLine("Метод Симпсона - 3");
                    string selection2 = Console.ReadLine();
                    if (f.Contains("^") == true)
                    {
                        IntOperation op1 = new IntOperation(Math.Pow);
                        if (selection2 == "1")
                        {
                            sum = Library_math_calculations.integral_rectangle_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "2")
                        {
                            sum = Library_math_calculations.integral_trapezoid_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "3")
                        {
                            sum = Library_math_calculations.integral_simpsons_method(op1, a, b, n, s);
                        }
                        else
                        {
                            Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                            Console.ReadLine();
                            --m;
                            Console.Clear();
                            continue;
                        }
                    }

                    else if (f.Contains("sqrt") == true)
                    {
                        IntOperation op1 = new IntOperation(Library_math_calculations.Sqrt);
                        if (selection2 == "1")
                        {
                            sum = Library_math_calculations.integral_rectangle_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "2")
                        {
                            sum = Library_math_calculations.integral_trapezoid_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "3")
                        {
                            sum = Library_math_calculations.integral_simpsons_method(op1, a, b, n, s);
                        }
                        else
                        {
                            Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                            Console.ReadLine();
                            --m;
                            Console.Clear();
                            continue;
                        }
                    }

                    else if (f.Contains("*") == true)
                    {
                        IntOperation op1 = new IntOperation(Library_math_calculations.Prz);
                        if (selection2 == "1")
                        {
                            sum = Library_math_calculations.integral_rectangle_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "2")
                        {
                            sum = Library_math_calculations.integral_trapezoid_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "3")
                        {
                            sum = Library_math_calculations.integral_simpsons_method(op1, a, b, n, s);
                        }
                        else
                        {
                            Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                            Console.ReadLine();
                            --m;
                            Console.Clear();
                            continue;
                        }
                    }

                    else if (f.Contains("/") == true)
                    {
                        IntOperation op1 = new IntOperation(Library_math_calculations.Del);
                        if (selection2 == "1")
                        {
                            sum = Library_math_calculations.integral_rectangle_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "2")
                        {
                            sum = Library_math_calculations.integral_trapezoid_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "3")
                        {
                            sum = Library_math_calculations.integral_simpsons_method(op1, a, b, n, s);
                        }
                        else
                        {
                            Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                            Console.ReadLine();
                            --m;
                            Console.Clear();
                            continue;
                        }
                    }

                    else if (f.Contains("+") == true)
                    {
                        IntOperation op1 = new IntOperation(Library_math_calculations.Sum);
                        if (selection2 == "1")
                        {
                            sum = Library_math_calculations.integral_rectangle_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "2")
                        {
                            sum = Library_math_calculations.integral_trapezoid_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "3")
                        {
                            sum = Library_math_calculations.integral_simpsons_method(op1, a, b, n, s);
                        }
                        else
                        {
                            Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                            Console.ReadLine();
                            --m;
                            Console.Clear();
                            continue;
                        }
                    }

                    else if (f.Contains("-") == true)
                    {
                        IntOperation op1 = new IntOperation(Library_math_calculations.Dif);
                        if (selection2 == "1")
                        {
                            sum = Library_math_calculations.integral_rectangle_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "2")
                        {
                            sum = Library_math_calculations.integral_trapezoid_method(op1, a, b, n, s);
                        }
                        else if (selection2 == "3")
                        {
                            sum = Library_math_calculations.integral_simpsons_method(op1, a, b, n, s);
                        }
                        else
                        {
                            Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                            Console.ReadLine();
                            --m;
                            Console.Clear();
                            continue;
                        }
                    }
                    else
                    {
                        Console.WriteLine("Ошибка!!! Введены некоректные данные. Для продолжения нажмите Enter");
                        Console.ReadLine();
                        --m;
                        Console.Clear();
                        continue;
                    }
                }
            }
            Console.WriteLine(Math.Round(sum,5));
            Console.ReadLine();
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Course_project
{
    public class Library_math_calculations
    {
        public static double Sqrt(double x, double y)
        {
            return Math.Sqrt(x);
        }

        public static double Prz(double x, double y)
        {
            return x * y;
        }

        public static double Del(double x, double y)
        {
            return x / y;
        }

        public static double Sum(double x, double y)
        {
            return x + y;
        }
        public static double Dif(double x, double y)
        {
            return x - y;
        }

        public static double integral_rectangle_method(IntOperation op1, double a, double b, int n, double s)
        {
            if (n < 1)
                throw new ArgumentException();
            double h = (b - a) / n;
            double xi = h / 2;
            double sum = 0, x = 0, s1 = 0, func = 0;

            for (int i = 0; i < n; i++)
            {
                x = xi + i * h;
                func = op1(x, s);
                sum = sum + func;
            }

            s1 = sum * h;
            return s1;
        }

        public static double integral_trapezoid_method(IntOperation op1, double a, double b, double n, double s)
        {
            if (n < 1)
                throw new ArgumentException();
            double x = 0, h = 0, sum = 0, func = 0;
            h = (b - a) / n;
            for (int i = 0; i <= n; i++)
            {
                x = a + h * i;
                func = func + op1(x, s);
            }
            sum = func * h;
            return sum;
        }

        public static double integral_simpsons_method(IntOperation op1, double a, double b, double n, double s)
        {
            if (n < 1)
                throw new ArgumentException();
            double x, h, s1;
            h = (b - a) / n;
            s1 = 0; x = a + h;
            while (x < b)
            {
                s1 = s1 + 4 * op1(x, s);
                x = x + h;
                s1 = s1 + 2 * op1(x, s);
                x = x + h;
            }
            s1 = h / 3 * (s1 + op1(a, s) - op1(b, s));
            return s1;
        }

        public static double factorial(double n)
        {
            if (n < 0)
                throw new ArgumentException();
            double fact = 1;
            for (int i = 1; i <= n; i++)
            {
                fact *= i;
            }
            return fact;
        }

        public static double sinus(double x, int n)
        {
            if ( x < 0 || n < 1)
                throw new ArgumentException();
            double sin = 0;
            double sum = 0;
            for (int i = 0; i < n; i++)
            {
                sin = Math.Pow(-1, i) * Math.Pow(x, 2 * i + 1) / factorial(2 * i + 1);
                sum = sum + sin;
            }
            return sum;
        }

        public static double cosine(double x, int n)
        {
            if (x < 0 || n < 1)
                throw new ArgumentException();
            double cos = 0;
            double sum = 0;
            for (int i = 0; i < n; i++)
            {
                cos = Math.Pow(-1, i) * Math.Pow(x, 2 * i) / factorial(2 * i);
                sum = sum + cos;
            }
            return sum;
        }

        public static double tangent(double x, int n)
        {
            if (x < 0 || n < 1)
                throw new ArgumentException();
            double sin = sinus(x,n);
            double cos = cosine(x, n);
            double tg = sin / cos;
            return tg;
        }

        public static double cotangent(double x, int n)
        {
            if (x < 0 || n < 1)
                throw new ArgumentException();
            double sin = sinus(x,n);
            double cos = cosine(x, n);
            double ctg = cos / sin;
            return ctg;
        }

         public static double exponent(double x, int n)
        {
            if (x < 0 || n < 1)
                throw new ArgumentException();
            double e = 0;
            double sum = 0;
            for (int i = 0; i < n; i++)
            {
                e = Math.Pow(x, i) / factorial(i);
                sum = sum + e;
            }
            return sum;
        }

    }
}

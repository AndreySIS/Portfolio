using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using Course_project;

namespace Course_project_test
{
    [TestFixture()]
    public class Library_math_calculations_Test
    {
        [Test()]
        [ExpectedException(typeof(ArgumentException))]
        public void integral_rectangle_method_Error_Test()
        {
            IntOperation op1 = new IntOperation(Math.Pow);
            int n = 0;
            double actual = Library_math_calculations.integral_rectangle_method(op1, 0, 5, n, 2);
        }

        [Test()]
        public void integral_rectangle_method_Pow_Test()
        {
            IntOperation op1 = new IntOperation(Math.Pow);
            double expected = 41.66666;
            double actual = Library_math_calculations.integral_rectangle_method(op1, 0, 5, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        public void integral_rectangle_method_Sqrt_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Sqrt);
            double expected = 1.88562;
            double actual = Library_math_calculations.integral_rectangle_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        public void integral_rectangle_method_Prz_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Prz);
            double expected = 4.00000;
            double actual = Library_math_calculations.integral_rectangle_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        public void integral_rectangle_method_Del_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Del);
            double expected = 1.00000;
            double actual = Library_math_calculations.integral_rectangle_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        public void integral_rectangle_method_Sum_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Sum);
            double expected = 6.00000;
            double actual = Library_math_calculations.integral_rectangle_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        public void integral_rectangle_method_Dif_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Dif);
            double expected = -2.00000;
            double actual = Library_math_calculations.integral_rectangle_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }



        [Test()]
        [ExpectedException(typeof(ArgumentException))]
        public void integral_trapezoid_method_Error_Test()
        {
            IntOperation op1 = new IntOperation(Math.Pow);
            int n = 0;
            double actual = Library_math_calculations.integral_trapezoid_method(op1, 0, 5, n, 2);
        }

        [Test()]
        public void integral_trapezoid_method_Pow_Test()
        {
            IntOperation op1 = new IntOperation(Math.Pow);
            double expected = 41.73;
            double actual = Library_math_calculations.integral_trapezoid_method(op1, 0, 5, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 2));
        }

        [Test()]
        public void integral_trapezoid_method_Sqrt_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Sqrt);
            double expected = 1.89;
            double actual = Library_math_calculations.integral_trapezoid_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 2));
        }

        [Test()]
        public void integral_trapezoid_method_Prz_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Prz);
            double expected = 4.00;
            double actual = Library_math_calculations.integral_trapezoid_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 2));
        }

        [Test()]
        public void integral_trapezoid_method_Del_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Del);
            double expected = 1.00;
            double actual = Library_math_calculations.integral_trapezoid_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 2));
        }

        [Test()]
        public void integral_trapezoid_method_Sum_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Sum);
            double expected = 6.01;
            double actual = Library_math_calculations.integral_trapezoid_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 2));
        }

        [Test()]
        public void integral_trapezoid_method_Dif_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Dif);
            double expected = -2.00000;
            double actual = Library_math_calculations.integral_trapezoid_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 2));
        }



        [Test()]
        [ExpectedException(typeof(ArgumentException))]
        public void integral_simpsons_method_Error_Test()
        {
            IntOperation op1 = new IntOperation(Math.Pow);
            int n = 0;
            double actual = Library_math_calculations.integral_simpsons_method(op1, 0, 5, n, 2);
        }

        [Test()]
        public void integral_simpsons_method_Pow_Test()
        {
            IntOperation op1 = new IntOperation(Math.Pow);
            double expected = 41.66667;
            double actual = Library_math_calculations.integral_simpsons_method(op1, 0, 5, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        public void integral_simpsons_method_Sqrt_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Sqrt);
            double expected = 1.88561;
            double actual = Library_math_calculations.integral_simpsons_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        public void integral_simpsons_method_Prz_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Prz);
            double expected = 4.00000;
            double actual = Library_math_calculations.integral_simpsons_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        public void integral_simpsons_method_Del_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Del);
            double expected = 1.00000;
            double actual = Library_math_calculations.integral_simpsons_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        public void integral_simpsons_method_Sum_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Sum);
            double expected = 6.00000;
            double actual = Library_math_calculations.integral_simpsons_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        public void integral_simpsons_method_Dif_Test()
        {
            IntOperation op1 = new IntOperation(Library_math_calculations.Dif);
            double expected = -2.00000;
            double actual = Library_math_calculations.integral_simpsons_method(op1, 0, 2, 1000, 2);
            Assert.AreEqual(expected, Math.Round(actual, 5));
        }

        [Test()]
        [ExpectedException(typeof(ArgumentException))]
        public void factorial_Error_Test()
        {
            int n = -1;
            double actual = Library_math_calculations.factorial(n);
        }

        [TestFixture]
        public class sinus_Test_TestCase
        {
            [TestCase(0, 100, 0)]
            [TestCase(30, 100, -0.988)]
            public void sinus_Test(double x, int n, double result)
            {
                double actual = Library_math_calculations.sinus(x, n);
                Assert.AreEqual(result, Math.Round(actual, 3));
            }
        }

        [TestFixture]
        public class sinus_Error_Test_TestCase
        {
            [TestCase(-1, 100)]
            [TestCase(30, 0)]

            [ExpectedException(typeof(ArgumentException))]
            public void sinus_Test(double x, int n)
            {
                double actual = Library_math_calculations.sinus(x, n);
            }
        }

        [TestFixture]
        public class cosine_Test_TestCase
        {
            [TestCase(0, 100, 1)]
            [TestCase(30, 100, 0.154)]
            public void cosine_Test(double x, int n, double result)
            {
                double actual = Library_math_calculations.cosine(x, n);
                Assert.AreEqual(result, Math.Round(actual, 3));
            }
        }

        [TestFixture]
        public class cosinus_Error_Test_TestCase
        {
            [TestCase(-1, 100)]
            [TestCase(30, 0)]

            [ExpectedException(typeof(ArgumentException))]
            public void cosine_Test(double x, int n)
            {
                double actual = Library_math_calculations.cosine(x, n);
            }
        }

        [TestFixture]
        public class tangent_Test_TestCase
        {
            [TestCase(0, 100, 0)]
            [TestCase(30, 100, -6.397)]
            public void tangent_Test(double x, int n, double result)
            {
                double actual = Library_math_calculations.tangent(x, n);
                Assert.AreEqual(result, Math.Round(actual, 3));
            }
        }

        [TestFixture]
        public class tangent_Error_Test_TestCase
        {
            [TestCase(-1, 100)]
            [TestCase(30, 0)]

            [ExpectedException(typeof(ArgumentException))]
            public void tangent_Test(double x, int n)
            {
                double actual = Library_math_calculations.tangent(x, n);
            }
        }

        [TestFixture]
        public class cotangent_Test_TestCase
        {
            [TestCase(30, 100, -0.156)]
            public void cotangent_Test(double x, int n, double result)
            {
                double actual = Library_math_calculations.cotangent(x, n);
                Assert.AreEqual(result, Math.Round(actual, 3));
            }
        }

        [TestFixture]
        public class cotangent_Error_Test_TestCase
        {
            [TestCase(-1, 100)]
            [TestCase(30, 0)]

            [ExpectedException(typeof(ArgumentException))]
            public void cotangent_Test(double x, int n)
            {
                double actual = Library_math_calculations.cotangent(x, n);
            }
        }

        [TestFixture]
        public class exponent_Test_TestCase
        {
            [TestCase(0, 100, 1)]
            [TestCase(1, 100, 2.718)]
            [TestCase(2, 100, 7.389)]
            public void exponent_Test(double x, int n, double result)
            {
                double actual = Library_math_calculations.exponent(x, n);
                Assert.AreEqual(result, Math.Round(actual, 3));
            }
        }

        [TestFixture]
        public class exponent_Error_Test_TestCase
        {
            [TestCase(-1, 100)]
            [TestCase(30, 0)]

            [ExpectedException(typeof(ArgumentException))]
            public void exponent_Test(double x, int n)
            {
                double actual = Library_math_calculations.exponent(x, n);
            }
        }
    }
}

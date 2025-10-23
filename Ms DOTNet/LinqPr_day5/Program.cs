using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinqPr_day5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] arry = { 2, 4, 6, 7, 7, 2,44, 73, 573, 36 };

            var nums = arry.Where(x => x < 20);
            Console.WriteLine("Number below 20 : ");
            foreach(int num in nums)
            {
                Console.Write(num + " ");
            }
        }
    }
}

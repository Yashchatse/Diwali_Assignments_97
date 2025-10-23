using Microsoft.SqlServer.Server;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace Array_List_day5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ArrayList list = new ArrayList();
            Console.WriteLine("Please Enter 10 names:");

            for(int i =0; i < 10; i++)
            {
                Console.Write("Enter name {0}: ", i + 1);
                string name = Console.ReadLine();

                if (string.IsNullOrWhiteSpace(name))
                {
                    Console.WriteLine("Invalid input. please enter a valid name .");
                    i--;
                }
                list.Add(name);
            }
            list.Sort();
            Console.WriteLine("\n Sorted Names:");
            foreach(string name in list)
            {
                Console.WriteLine(name);
            }
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();


        }
    }
}

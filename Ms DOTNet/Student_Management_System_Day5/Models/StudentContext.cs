using Microsoft.EntityFrameworkCore;

namespace Student_Management_System_Day5.Models
{
    public class StudentContext :  DbContext 
    {
        public StudentContext(DbContextOptions<StudentContext> options)
           : base(options)
        {
        }

        public DbSet<Student> Students { get; set; }
    }
}

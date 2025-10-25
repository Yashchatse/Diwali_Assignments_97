using Microsoft.EntityFrameworkCore;
using Student_Management_System_Day7.Models;

namespace Student_Management_System_Day7.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
        {
        }
        public DbSet<Student> Students { get; set; }
        public DbSet<Course> Courses { get; set; }

    }
}

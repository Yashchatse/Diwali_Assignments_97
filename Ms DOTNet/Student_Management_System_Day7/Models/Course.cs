using System.ComponentModel.DataAnnotations;

namespace Student_Management_System_Day7.Models
{
    public class Course
    {
        public int CourseID { get; set; }

        [Required(ErrorMessage = "Course name is required")]
        [Display(Name = "Course Name")]
        public string CourseName { get; set; } = string.Empty;
    }
}

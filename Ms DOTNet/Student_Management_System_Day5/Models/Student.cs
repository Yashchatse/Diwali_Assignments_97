using System.ComponentModel.DataAnnotations;

namespace Student_Management_System_Day5.Models
{
    public class Student
    {
        public int Id { get; set; }

        [Required]
        [StringLength(100)]
        public string Name { get; set; }

        [Display(Name = "Birth Date")]
        [DataType(DataType.Date)]
        public DateTime BirthDate { get; set; }

        [Required]
        [StringLength(200)]
        public string Address { get; set; }

        [Display(Name = "School Name")]
        [Required]
        [StringLength(150)]
        public string SchoolName { get; set; } 

        [Display(Name = "Percentage Marks")]
        [Range(0, 100, ErrorMessage = "Percentage must be between 0 and 100")]
        public decimal PercentageMarks { get; set; }
    }
}

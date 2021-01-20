using MicroserviceAspDemo.Shared;
using System.ComponentModel.DataAnnotations.Schema;

namespace MicroserviceAspDemo.Db.Models {

    [Table("Puzzle")]
    public class PuzzleDto {
        public long Id { get; set; }
        public string Name { get; set; }
        public Difficulty Difficulty { get; set; }
    }
}

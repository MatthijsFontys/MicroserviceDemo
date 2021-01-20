using MicroserviceAspDemo.Db.Models;
using Microsoft.EntityFrameworkCore;

namespace MicroserviceAspDemo.Db {
    public class MyContext : DbContext {
        public DbSet<PuzzleDto> Puzzles { get; set; }


        public MyContext(DbContextOptions<MyContext> options)
        : base(options) { }
    }
}

using MicroserviceAspDemo.Db.Models;
using MicroserviceAspDemo.Viewmodels;
using System;
using System.Collections.Generic;
using System.Linq;

namespace MicroserviceAspDemo.Shared {
    public class PuzzleMapper {

        public PuzzleViewModel Map(PuzzleDto source) {
            return new PuzzleViewModel {
                Name = source.Name,
                Difficulty = source.Difficulty.ToString(),
            };
        }

        public PuzzleDto Map(PuzzleViewModel source) {
            return new PuzzleDto {
                Name = source.Name,
                Difficulty = (Difficulty)Enum.Parse(typeof(Difficulty), source.Difficulty)
            };
        }

        public IEnumerable<PuzzleViewModel> Map(IEnumerable<PuzzleDto> source) {
            List<PuzzleViewModel> mappedModels = source.Select(x => Map(x)).ToList();
            return mappedModels;
        }

    }
}

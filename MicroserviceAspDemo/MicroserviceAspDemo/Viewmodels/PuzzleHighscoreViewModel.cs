using System.Collections.Generic;

namespace MicroserviceAspDemo.Viewmodels {
    public class PuzzleHighscoreViewModel {
        public string Name { get; set; }
        public List<HighscoreViewModel> Highscores { get; set; }
    }
}

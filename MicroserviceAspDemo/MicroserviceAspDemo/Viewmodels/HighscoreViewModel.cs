using System;
using System.ComponentModel;

namespace MicroserviceAspDemo.Viewmodels {
    public class HighscoreViewModel {
        public string PlayerName { get; set; }
        public int SecondsToComplete { get; set; }

        [DisplayName("Time")]
        public string CompletionTimeFormatted {
            get {
                TimeSpan time = TimeSpan.FromSeconds(SecondsToComplete);
                return time.ToString(@"mm\:ss");
            }
        }
    }
}

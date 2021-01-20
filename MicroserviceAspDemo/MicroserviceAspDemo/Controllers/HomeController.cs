using GrpcServer;
using MicroserviceAspDemo.Db;
using MicroserviceAspDemo.Db.Models;
using MicroserviceAspDemo.Shared;
using MicroserviceAspDemo.Viewmodels;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;

namespace MicroserviceAspDemo.Controllers {
    public class HomeController : Controller {
        private readonly ILogger<HomeController> _logger;
        private readonly MyContext _context;
        private readonly HighscoreService.HighscoreServiceClient _hiscoreClient;
        private readonly Greeter.GreeterClient _greetClient;

        public HomeController(ILogger<HomeController> logger, MyContext context, HighscoreService.HighscoreServiceClient hiscoreClient, Greeter.GreeterClient greetClient) {
            _logger = logger;
            _context = context;
            _hiscoreClient = hiscoreClient;
            _greetClient = greetClient;
        }

        public IActionResult Index() {
            var mapper = new PuzzleMapper();
            using (_context) {
                IEnumerable<PuzzleDto> models = _context.Puzzles.OrderBy(x => x.Difficulty).ToList();
                IEnumerable<PuzzleViewModel> vm = mapper.Map(models);
                return View(vm);
            }
        }

        public IActionResult Create() {
            return View();
        }

        [HttpPost]
        public IActionResult Create(PuzzleViewModel vm) {
            var mapper = new PuzzleMapper();
            PuzzleDto entity = mapper.Map(vm);
            using (_context) {
                _context.Puzzles.Add(entity);
                _context.SaveChanges();
            }
            return RedirectToAction("index");
        }

        public IActionResult HelloWorld() {
            HelloReply reply = _greetClient.SayHello(new HelloRequest() { Name = " world!" });
            Console.WriteLine(reply.Message);
            return new JsonResult(reply.Message);
        }

        [HttpGet("[controller]/Highscore/{puzzleName}")]
        public IActionResult Highscore(string puzzleName) {
            var mapper = new PuzzleMapper();
            PuzzleHighscoreViewModel vm;
            int puzzleId = -1;

            using (_context) {
                PuzzleDto puzzle = _context.Puzzles.First(x => x.Name == puzzleName);
                vm = new PuzzleHighscoreViewModel() { Name = puzzle.Name, Highscores = new List<HighscoreViewModel>() };
                puzzleId = (int)puzzle.Id;
            }

            PuzzleReply reply = _hiscoreClient.GetPuzzleHighscore(new PuzzleRequest() { PuzzleId = puzzleId });
            foreach (PuzzleHighscore item in reply.Highscores.OrderBy(x => x.SecondsToComplete)) {
                vm.Highscores.Add(new HighscoreViewModel {
                    PlayerName = item.AttemptName,
                    SecondsToComplete = item.SecondsToComplete
                });
            }

            return View(vm);
        }

        public IActionResult Login() {
            return View();
        }

        public IActionResult Privacy() {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error() {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}

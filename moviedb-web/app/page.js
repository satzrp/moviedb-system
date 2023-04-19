import { MovieCard } from "./components/movie-card";

const BASE_URL = "http://localhost:8080";

const movies = [
  {
    id: 1,
    name: "The Shawshank Redemption",
    yearOfRelease: 1994,
    description:
      "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
    runningLength: 142,
    genre: "Crime, Drama",
    avatarUrl: "/images/thumbnails/1.jpg",
    imageUrl: "/images/media/1.jpg",
    actors: "Tim Robbins, Morgan Freeman",
    director: "Frank Darabont",
  },
  {
    id: 2,
    name: "The Godfather",
    yearOfRelease: 1972,
    description:
      "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
    runningLength: 175,
    genre: "Crime, Drama",
    avatarUrl: "/images/thumbnails/2.jpg",
    imageUrl: "/images/media/2.jpg",
    actors: "Marlon Brando, Al Pacino",
    director: "Francis Ford Coppola",
  },
  {
    id: 3,
    name: "The Godfather: Part II",
    yearOfRelease: 1974,
    description:
      "The early life and career of Vito Corleone in 1920s New York is portrayed while his son, Michael, expands and tightens his grip on the family crime syndicate.",
    runningLength: 202,
    genre: "Crime, Drama",
    avatarUrl: "/images/thumbnails/3.jpg",
    imageUrl: "/images/media/3.jpg",
    actors: "Al Pacino, Robert De Niro",
    director: "Francis Ford Coppola",
  },
  {
    id: 4,
    name: "The Dark Knight",
    yearOfRelease: 2008,
    description:
      "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham, the Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
    runningLength: 152,
    genre: "Action, Crime, Drama, Thriller",
    avatarUrl: "/images/thumbnails/4.jpg",
    imageUrl: "/images/media/4.jpg",
    actors: "Christian Bale, Heath Ledger",
    director: "Christopher Nolan",
  },
  {
    id: 5,
    name: "12 Angry Men",
    yearOfRelease: 1957,
    description:
      "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.",
    runningLength: 96,
    genre: "Crime, Drama",
    avatarUrl: "/images/thumbnails/5.jpg",
    imageUrl: "/images/media/5.jpg",
    actors: "Henry Fonda, Lee J. Cobb",
    director: "Sidney Lumet",
  },
  {
    id: 6,
    name: "Pulp Fiction",
    yearOfRelease: 1994,
    description:
      "The lives of two mob hit men, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
    runningLength: 154,
    genre: "Crime, Drama",
    avatarUrl: "/images/thumbnails/6.jpeg",
    imageUrl: "/images/media/6.jpg",
    actors: "John Travolta, Uma Thurman, Samuel L. Jackson",
    director: "Quentin Tarantino",
  },
];
export default function Home() {
  return (
    <main>
      <div class="container ps-4 pe-4">
        <div class="row pb-5">
          {movies.map((movie) => (
            <MovieCard
              key={movie.movieId}
              movieId={movie.movieId}
              movieName={movie.name}
              movieDesc={movie.description}
              avatarUrl={`${BASE_URL}${movie.avatarUrl}`}
            />
          ))}
        </div>
      </div>
    </main>
  );
}

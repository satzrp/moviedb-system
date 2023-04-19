import { MovieCard } from "./components/movie-card";
import { BASE_URL, API_URL } from "./config";

async function fetchAllMovies() {
  console.log(`${API_URL}/movies`);
  const response = await fetch(`${API_URL}/movies`, {
    next: {
      revalidate: 60,
    },
  });
  const movies = await response.json();
  return movies;
}

const Home = async () => {
  const movies = await fetchAllMovies();
  return (
    <main>
      <div className="container ps-4 pe-4">
        <div className="row pb-5">
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
};

export default Home;

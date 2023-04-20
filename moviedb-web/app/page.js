import MovieCard from "./components/movie-card";
import { httpGet } from "./api-utils";
import { BASE_URL, API_URL } from "./config";

async function fetchAllMovies() {
  return await httpGet(`${API_URL}/movies`);
}

const Home = async () => {
  const movies = await fetchAllMovies();
  return (
    <section>
      <div className="container ps-4 pe-4">
        <div className="row pb-5">
          {movies.map((movie) => (
            <MovieCard
              key={movie.id}
              movieId={movie.id}
              movieName={movie.name}
              movieDesc={movie.description}
              avatarUrl={`${BASE_URL}${movie.avatarUrl}`}
            />
          ))}
        </div>
      </div>
    </section>
  );
};

export default Home;

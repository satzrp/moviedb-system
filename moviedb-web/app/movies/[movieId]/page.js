import MovieDetail from "./movie-detail";
import ReviewList from "./review-list";
import { API_URL } from "@/app/config";

async function fetchMovie(movieId) {
  const response = await fetch(`${API_URL}/movies/${movieId}`, {
    next: {
      revalidate: 60,
    },
  });
  const movie = await response.json();
  return movie;
}

const MovieDetailPage = async ({ params: { movieId } }) => {
  const movie = await fetchMovie(movieId);
  return (
    <section>
      <div className="mt-5 pb-5 text-dark">
        <div className="row d-flex justify-content-center">
          <div className="col-md-10 col-lg-10">
            <MovieDetail movieDetails={movie.movieDetails} />
            <ReviewList reviews={movie.reviews} />
          </div>
        </div>
      </div>
    </section>
  );
};

export default MovieDetailPage;
